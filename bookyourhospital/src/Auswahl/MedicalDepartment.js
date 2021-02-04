import React, { Component } from 'react';
import { Button, Table, Container, Row, Col, Dropdown } from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "./ServiceUnit";
import "./Auswahl.css";

class MedicalDepartment extends Component {state = { data : "" }



    async componentDidMount(){
        const url = "http://localhost:8080/api";
        const response = await fetch(url);
    }

    render() {
        return (
            <center>
                <div className="MedicalDepartment" style={{ padding: 30 }}>
                    <h2>Bitte wählen Sie einen Fachbereich aus!</h2>
                </div>
                <div>
                    <Dropdown id="drop">
                        <Dropdown.Toggle variant="info" id="dropdown-basic">
                           Fachbereich auswählen
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            <Dropdown.Item onClick={() => this.postData("Orthopäde")} href="/ServiceUnit/Orthopaedie">Orthopaedie</Dropdown.Item>
                            <Dropdown.Item onClick={() => this.postData("Chirurgie")} href="/ServiceUnit/Chirurgie">Chirurgie</Dropdown.Item>
                            <Dropdown.Item onClick={() => this.postData("Augenambulanz")} href="/ServiceUnit/Augenambulanz">Augenambulanz</Dropdown.Item>
                        </Dropdown.Menu>
                    </Dropdown>
                </div>
            </center>
        );
    }
}
export default MedicalDepartment;