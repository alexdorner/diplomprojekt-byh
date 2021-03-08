//Nach dem TAN
//Termincode
//Wird per SMS gesendet --> Beenden Button (Kommt man auf Home)
import React, { Component } from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";
import AppointmentOverview from "./AppointmentOverview";

class AppointmentInformation extends Component{

    constructor(props) {
        super(props);

        if(this.props.match != null) {
            this.parent = this.props.match.params.parent
            this.type = this.props.match.params.type
            this.to = this.props.match.params.to
            this.appointmentView = this.props.match.params.appointmentView;
        } else {
            this.parent = "parent"
            this.type = "type"
            this.to = "to"
            this.appointmentView = "appointmentView";
        }
    }

    async componentDidMount() {
        try {
            let result = await fetch("http://localhost:8080/api", {
                method: 'post',
                mode: "cors",
                headers: {
                    'Accept': 'application/json',
                    'Content-type': 'application/json',
                },
                body: JSON.stringify({
                    appoinmentView: this.appointmentView
                })
            })
        } catch (e) {
            console.log(e);
        }
    }

    render() {
        return (
            <center>
                <h1>Ausgewählter individueller Termincode: {this.appointmentView/*Termincode hier anzeigen*/}</h1>
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
                <div> {/*<!-- Termin wird im KIS vorgemerkt -->*/}
                    <Button size="lg" variant="dark" type="submit" action href={'/TanOK/' + this.appointmentView + '/' + this.parent + '/' + this.type + '/' + this.to}>Termin vormerken beenden</Button>
                </div>
            </center>
        );
    }

}
export default AppointmentInformation;