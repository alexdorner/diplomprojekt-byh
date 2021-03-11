import React, { Component } from 'react';
import {Button, Col, Container, Form} from "react-bootstrap";


class AppointmentCancel extends Component {

    render() {
        return (
            <center>
                <h1>Termin stornieren </h1>
                <Form>
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label>Hier bitte Ihren individuellen Termincode eingeben</Form.Label>
                        <Form.Control type="email" placeholder="individuellen Termincode" />
                    </Form.Group>
                    <Button size="lg" variant="dark" action href={'/TanServiceSMS/' + this.appointmentOverView + '/AppointmentView'}>TAN per SMS senden</Button>
                </Form>
            </center>
        );
    }
}
export default AppointmentCancel;