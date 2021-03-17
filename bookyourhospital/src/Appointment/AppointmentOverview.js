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
        const url = "http://localhost:8080/api/appointment/GetAll";
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
            }

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