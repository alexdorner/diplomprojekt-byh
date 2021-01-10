import React, { Component } from 'react';
import { Button, Table, Container, Row, Col } from 'react-bootstrap';
import history from "../history";

class Ueberweisung extends Component {
    render() {
        return (
            <Container>
                <Row>
                    <Col>Haben Sie eine Ueberweisung?</Col>
                </Row>
                <Row>
                    <Col>
                        <Button variant="btn btn-success" onClick={() => history.push('/AuswahlBereich')}>Ja</Button>
                    </Col>
                    <Col>
                        <Button variant="btn btn-success" onClick={() => history.push('/KeineUeberweisung')}>Nein</Button>
                    </Col>
                    <Col>
                        <Button variant="btn btn-success" onClick={() => history.push('/WasUeberweisung')}>Was ist eine Ueberweisung?</Button>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default Ueberweisung;