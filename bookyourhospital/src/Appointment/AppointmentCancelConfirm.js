import React, { Component } from 'react';
import {Col, Container, ListGroup, Row} from "react-bootstrap";

class AppointmentCancelConfirm extends Component {

    render() {
        return (
            <Container>
                <h1>Individueller Termincode: {this.appointmentView/*Termincode hier anzeigen*/}</h1>
                <h2>Ihr Termin wurde erfolgreich storniert</h2>
                <Col>
                </Col>
            </Container>
        );
    }
}
export default AppointmentCancelConfirm;