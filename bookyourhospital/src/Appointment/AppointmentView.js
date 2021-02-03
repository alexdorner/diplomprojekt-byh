import React, { Component } from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Auswahl/ServiceUnit";

class AppointmentView extends Component{
    appointmentOverView = this.props.match.params.appointmentOverView

    async componentDidMount(){
        try {
            let result = await fetch("http://localhost:8080/api", {
                method: 'post',
                mode: "cors",
                headers: {
                    'Accept': 'application/json',
                    'Content-type': 'application/json',
                },
                body: JSON.stringify({
                    appointmentOverView: this.appointmentOverView
                })
            })
        }
        catch (e){
            console.log(e);
        }

    }

    render() {
        return (
            <Container>
                <h1>Ausgewählter Termin: {this.appointmentOverView}</h1>
                <Col>
                    <ListGroup>
                        <ListGroup.Item href="/AppointmentView">Cras justo odio</ListGroup.Item>
                        <ListGroup.Item href="/AppointmentView">Dapibus ac facilisis in</ListGroup.Item>
                        <ListGroup.Item href="/AppointmentView">Morbi leo risus</ListGroup.Item>
                        <ListGroup.Item href="/AppointmentView">Porta ac consectetur ac</ListGroup.Item>
                        <ListGroup.Item href="/AppointmentView">Vestibulum at eros</ListGroup.Item>
                    </ListGroup>
                </Col>
            </Container>
        );
    }
}
export default AppointmentView;