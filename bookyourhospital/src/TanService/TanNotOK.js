import React, { Component } from "react";
import { Col, Container, Row } from "react-bootstrap";
import "./TanService.css";

class TanNotOK extends Component {
  render() {
    return (
      <Container>
        <Row>
          <Col>
            <br></br>
            <div className="d-flex justify-content-center">
              <h4>Der Tan stimmt mit dem gesendeten Tan nicht überein</h4>
            </div>
            <div className="d-flex justify-content-center">
              <a href="./TanCheck">Tan nochmal eingeben</a>
            </div>
          </Col>
        </Row>
      </Container>
    );
  }
}

export default TanNotOK;
