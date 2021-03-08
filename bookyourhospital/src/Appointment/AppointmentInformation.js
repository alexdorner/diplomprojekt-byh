//Nach dem TAN
//Termincode
//Wird per SMS gesendet --> Beenden Button (Kommt man auf Home)
import React, { Component } from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";
import AppointmentOverview from "./AppointmentOverview";

class AppointmentInformation extends Component{
    appointmentView = this.props.match.params.appointmentView

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
                    appoinmentView: this.appointmentView
                })
            })
        }
        catch (e){
            console.log(e);
        }

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
                <div> {/*<!-- Bitte Michelle, da sollte man SMS kommen UND Termin wird im KIS vorgemerkt -->*/}
                    <button type="submit" action href={'/AppointmentConfirm'}>Termin vormerken beenden</button>
                </div>
            </center>
        );
    }

}
export default AppointmentInformation;