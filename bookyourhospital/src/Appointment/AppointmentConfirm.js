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

    async componentWillMount() {
        const url = "http://localhost:8080/api/appointment/vormerken?termincode=" + this.appointmentView;
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
        // console.log(this.state.data);
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