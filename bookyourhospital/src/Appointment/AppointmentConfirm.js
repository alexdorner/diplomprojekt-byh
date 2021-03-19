import React, { Component } from 'react';
import {Button, Col, Container, ListGroup, Row} from "react-bootstrap";

class AppointmentConfirm extends Component {

    constructor(props) {
        super(props);
        this.state = {data: []}

        if(this.props.match != null) {
            this.appointmentView = this.props.match.params.appointmentView;
        } else {
            this.appointmentView = "appointmentView";
        }
    }
    render() {
        return (
            <center>
                <h1>Individueller Termincode: </h1>
                <h1>{this.appointmentView}</h1>
                <h2>Ihr Termin wurde erfolgreich vorgemerkt</h2>
                <Button size="lg" variant="dark" type="submit" action href={'/'}>Beenden</Button>
            </center>
        );
    }
}
export default AppointmentConfirm;