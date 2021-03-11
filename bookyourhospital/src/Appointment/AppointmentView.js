import React, { Component } from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";

class AppointmentView extends Component{
    state = {data: []}
    appointmentOverView = this.props.match.params.appointmentOverView
    async componentWillMount() {
        const url = "/api/appointment/GetAll?idOrganization=" + "" + "&idDevice=" + "" + "&datum=" + "";
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
        // console.log(this.state.data);
    }

    render() {
        return (
            <Container>
                <h1>Ausgewählter Termin: {this.appointmentOverView}</h1>
                <Row>
                    <Col>
                        <p>Krankenhaus</p>
                        <p>Adresse</p>
                        <p>Datum</p>
                        <p>Uhrzeit</p>
                    </Col>
                    <Col>
                        <p>Map</p>
                    </Col>
                </Row>
                <Button size="lg" variant="dark" action href={'/TanServiceSMS/' + this.appointmentOverView + '/AppointmentView'}>TAN per SMS senden</Button>
            </Container>
        );
    }
}
export default AppointmentView;