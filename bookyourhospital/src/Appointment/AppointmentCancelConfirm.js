import React, { Component } from 'react';
import {Col, Container, ListGroup, Row} from "react-bootstrap";

class AppointmentCancelConfirm extends Component {
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
                <h1>Individueller Termincode: {this.appointmentView/*Termincode hier anzeigen*/}</h1>
                <h2>Ihr Termin wurde erfolgreich storniert</h2>
                <Col>
                    {this.state.data.map(el => <ListGroup.Item>{el.Date} {el.start}</ListGroup.Item>)}
                </Col>
            </Container>
        );
    }
}
export default AppointmentCancelConfirm;