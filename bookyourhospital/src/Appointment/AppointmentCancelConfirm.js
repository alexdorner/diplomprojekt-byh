import React, { Component } from 'react';
import {Col, Container, ListGroup, Row} from "react-bootstrap";

class AppointmentCancelConfirm extends Component {

    constructor(props) {
        super(props);

        if(this.props.match != null) {
            this.appointmentOverView = this.props.match.params.appointmentOverView;
        } else {
            this.appointmentOverView = "appointmentOverView";
        }
    }

    render() {
        return (
            <Container>
                <h1>Individueller Termincode: {this.appointmentOverView/*Termincode hier anzeigen*/}</h1>
                <h2>Ihr Termin wurde erfolgreich storniert</h2>
                <Col>
                </Col>
            </Container>
        );
    }
}
export default AppointmentCancelConfirm;