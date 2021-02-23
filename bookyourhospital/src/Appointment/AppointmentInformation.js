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
                <h1>Ausgewählter Termin: {this.appointmentView}</h1>
                <div>
                    <p>Informationen zum Termin</p>
                </div>
                <div>
                    <button type="submit">Termin vormerken beenden</button>
                </div>
            </center>
        );
    }

}
export default AppointmentInformation;