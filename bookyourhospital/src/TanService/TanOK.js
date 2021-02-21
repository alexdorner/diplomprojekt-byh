import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanOK extends Component {
    render() {
        return (
            <Container>
                <Row>
                    <Col>
                        <br></br>
                        <div className="d-flex justify-content-center">
                            <h4>Die eingegebene TAN stimmt überein</h4>
                        </div>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default TanOK;