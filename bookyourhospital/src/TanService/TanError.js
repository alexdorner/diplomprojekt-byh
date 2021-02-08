import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanError extends Component {
    render() {
        return (
            <Container>
                <Row>
                    <Col>
                        <br></br>
                        <div class="d-flex justify-content-center">
                            <h4>Leider gab es ein Problem beim Versenden</h4>
                        </div>
                        <div class="d-flex justify-content-center">
                            <a href="./TanServiceEmail">Tan per Email senden</a>
                        </div>
                        <div class="d-flex justify-content-center">
                            <a href="./TanServiceSMS">Tan per SMS senden</a>
                        </div>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default TanError;