import React, { Component } from 'react';
import { Button, Table, Container, Row, Col, Dropdown } from 'react-bootstrap';
import history from "../history";

class ServiceUnit extends Component{
    state = {data: []}

    async componentWillMount() {
        const url = "http://localhost:8080/api/device/Get";
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
    }

    render() {
        return (
            <center>
                <div style={{ padding: 30 }}>
                    <h1>Ausgewählte Abteilung: {this.department}</h1>
                    <div style={{ padding: 30 }}>
                        <h5>Bitte wählen Sie eine Art aus!</h5>
                    </div>
                    <div style={{ padding: 30 }}>
                        <Dropdown>
                            <Dropdown.Toggle variant="info" id="dropdown-basic">
                                Art auswählen
                            </Dropdown.Toggle>
                            <Dropdown.Menu>
                                <Dropdown.Item onClick={() => this.postData("Mittelfuß")} href="/AppointmentOverview/Mittelfuß">Mittelfuß</Dropdown.Item>
                                <Dropdown.Item onClick={() => this.postData("Hüfte")} href="/AppointmentOverview/Huefte">Hüfte</Dropdown.Item>
                                <Dropdown.Item onClick={() => this.postData("Schulter")} href="/AppointmentOverview/Schulter">Schulter</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>
                    </div>
                </div>
            </center>
        );
    }
}
export default ServiceUnit;