import React, {Component} from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";

class AppointmentOverview extends Component {

    constructor(props) {
        super(props);
        this.state = {data: []}

        if(this.props.match != null) {
            this.serviceUnit = this.props.match.params.serviceUnit;
            this.department = this.props.match.params.medicalDepartment;
        } else {
            this.serviceUnit = "serviceUnit";
            this.department = "medicalDepartment";
        }
    }

    async componentWillMount() {
        //const url = "/api/appointment/GetAll?idOrganization=" + this.department + "&idDevice=" + this.serviceUnit + "&datum=" + "";
        const url = "/api/appointment/GetAll";
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
        let actors = [];
        let filtered = [];
        this.state.data.map(el => actors.push(el))

        filtered = this.state.data.filter(el => el.participant.map(par => par.id === "Device" && par.actor.id === "Audiometrie"));

        console.log(filtered)
        //(e.id === "Device" && e.actor.id === this.serviceUnit)

    }



    /*async componentDidMount(){
        try {
            let result = await fetch("http://localhost:8080/api", {
                method: 'post',
                mode: "cors",
                headers: {
                    'Accept': 'application/json',
                    'Content-type': 'application/json',
                },
                body: JSON.stringify({
                    serviceUnit: this.serviceUnit
                })
            })
        }
        catch (e){
            console.log(e);
        }

    }*/

    render() {
        return (
            <Container>
                <h1>Termine für: {this.department} - {this.serviceUnit}</h1>
                <Col>
                    <ListGroup>
                        {this.state.data.length > 0 &&
                        this.state.data.map(el => <ListGroup.Item action
                                                                  href={"/AppointmentView/" + el.id}>{el.Date} {el.start}</ListGroup.Item>)}
                    </ListGroup>
                </Col>
            </Container>
        );
    }
}

export default AppointmentOverview;