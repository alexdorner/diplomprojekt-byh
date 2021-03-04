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
                <h1>Ihr Termincode: {this.appointmentView}</h1>
                <Col>
                    {this.state.data.map(el => <ListGroup.Item>{el.Date} {el.start}</ListGroup.Item>)}
                </Col>
            </Container>
        );
    }
}
export default AppointmentConfirm;