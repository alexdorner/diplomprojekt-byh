import React, { Component } from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";

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
                <Row>
                    <Col>
                        <p>Krankenhaus</p>
                        <p>Datum</p>
                        <p>Uhrzeit</p>
                        <p>Adresse</p>
                    </Col>
                    <Col>
                        <p>Map</p>
                    </Col>
                </Row>
                {/*<!-- Bitte Michelle, da sollte man zum TAN kommen -->*/}
                <Button size="lg" variant="dark" action href={'/TanServiceSMS/AppointmentView'}>TAN per SMS senden</Button>
            </Container>
        );
    }
}
export default AppointmentView;