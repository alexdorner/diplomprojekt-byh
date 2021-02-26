import React, { Component } from "react";
import { Col, Container, Row } from "react-bootstrap";
import "./TanService.css";

class TanError extends Component {
  render() {
    return (
      <Container>
        <Row>
          <Col>
            <br></br>
            <div className="d-flex justify-content-center">
              <h4>Leider gab es ein Problem beim Versenden</h4>
            </div>
            <div className="d-flex justify-content-center">
              <a href="./TanServiceEmail">Tan per Email senden</a>
            </div>
            <div className="d-flex justify-content-center">
              <a href="./TanServiceSMS">Tan per SMS senden</a>
            </div>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default TanError;
