import React, { Component } from 'react';
import {Col, Container, ListGroup, Row} from "react-bootstrap";

class AppointmentConfirm extends Component {
    state = {data: []}
    appointmentView = this.props.match.params.appointmentView
    async componentWillMount() {
        const url = "http://localhost:8080/api/appointment/GetAll";
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
        // console.log(this.state.data);
    }

    render() {
        return (
            <Container>
                <h1>Individueller Termincode: {/*Termincode hier anzeigen*/}</h1>
                <h2>Ihr Termin wurde erfolgreich vorgemerkt</h2>
            </Container>
        );
    }
}
export default AppointmentConfirm;