import React, { Component } from 'react';
import {Button, Col, Container, ListGroup, Row} from "react-bootstrap";

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
                <Button size="lg" variant="dark" type="submit" action href={'/'}>Beenden</Button>
            </Container>
        );
    }
}
export default AppointmentCancelConfirm;