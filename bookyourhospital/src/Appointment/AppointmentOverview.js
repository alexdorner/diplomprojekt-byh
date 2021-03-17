import React, {Component} from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";

class AppointmentOverview extends Component {

    constructor(props) {
        super(props);
        this.state = {data: []}

        if (this.props.match != null) {
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
        let hospital = ""
        //filtered = this.state.data.filter(el => console.log(el.participant.filter(e => e.id === "Location")));
        //filtered = this.state.data.filter(el => el.participant.filter((e) => e.id === "Location").map(el => console.log(el.actor.id)));



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
                <ListGroup>
                    {this.state.data.length > 0 &&
                    this.state.data.map(el => <ListGroup.Item action
                                                              href={"/AppointmentView/" + el.id}>
                        {el.Date} {el.start} || {el.participant.filter((e) => e.id === "Location").map(el => el.actor.id)}</ListGroup.Item>)}
                </ListGroup>
            </Container>
        );
    }
}

export default AppointmentOverview;