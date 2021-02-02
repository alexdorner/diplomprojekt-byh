import React, { Component } from 'react';
import { Button, Table, Container, Row, Col, Dropdown } from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "./ServiceUnit";

class MedicalDepartment extends Component {state = { data : "" }



    async componentDidMount(){
        const url = "http://localhost:8080/api";
        const response = await fetch(url);
    }

    render() {
        return (
            <Container>
                <Row>
                    Bitte wählen Sie einen Fachbereich aus!
                </Row>
                <Row>
                    <Dropdown id="drop">
                        <Dropdown.Toggle variant="success" id="dropdown-basic">
                            Fachbereich auswählen
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            <Dropdown.Item onClick={() => this.postData("Orthopäde")} href="/ServiceUnit/Orthopaedie">Orthopaedie</Dropdown.Item>
                            <Dropdown.Item onClick={() => this.postData("Chirurgie")} href="/ServiceUnit/Chirurgie">Chirurgie</Dropdown.Item>
                            <Dropdown.Item onClick={() => this.postData("Augenambulanz")} href="/ServiceUnit/Augenambulanz">Augenambulanz</Dropdown.Item>
                        </Dropdown.Menu>
                    </Dropdown>
                </Row>
            </Container>
        );
    }
}
export default MedicalDepartment;