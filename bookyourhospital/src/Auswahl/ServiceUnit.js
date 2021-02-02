import React, { Component } from 'react';
import { Button, Table, Container, Row, Col, Dropdown } from 'react-bootstrap';
import history from "../history";

class ServiceUnit extends Component{
    department = this.props.match.params.department

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
                    department: this.department
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
                <h1>Ausgewählte Abteilung: {this.department}</h1>
                <Row>
                    Bitte wählen Sie eine Art aus!
                </Row>
                <Row>
                    <Dropdown>
                        <Dropdown.Toggle variant="success" id="dropdown-basic">
                            Art auswählen
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            <Dropdown.Item href="/calender">Mittelfuß</Dropdown.Item>
                            <Dropdown.Item href="/calender">Hüfte</Dropdown.Item>
                            <Dropdown.Item href="/calender">Schulter</Dropdown.Item>
                        </Dropdown.Menu>
                    </Dropdown>
                </Row>
            </Container>
        );
    }
}
export default ServiceUnit;