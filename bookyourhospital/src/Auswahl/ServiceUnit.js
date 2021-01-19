import React, { Component } from 'react';
import { Button, Table, Container, Row, Col, Dropdown } from 'react-bootstrap';
import history from "../history";

class ServiceUnit extends Component{
    render() {
        return (
            <Container>
                <Row>
                    Bitte wählen Sie eine Art aus!
                </Row>
                <Row>
                    <Dropdown>
                        <Dropdown.Toggle variant="success" id="dropdown-basic">
                            Art auswählen
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            <Dropdown.Item href="/action-1">Action</Dropdown.Item>
                            <Dropdown.Item href="/action-2">Another action</Dropdown.Item>
                            <Dropdown.Item href="/action-3">Something else</Dropdown.Item>
                        </Dropdown.Menu>
                    </Dropdown>
                </Row>
            </Container>
        );
    }
}
export default ServiceUnit;