import React, { Component } from "react";
import { Col, Container, ListGroup } from "react-bootstrap";

class AppointmentOverview extends Component {
  serviceUnit = this.props.match.params.serviceUnit;

  async componentDidMount() {
    try {
      await fetch("http://localhost:8080/api", {
        method: "post",
        mode: "cors",
        headers: {
          Accept: "application/json",
          "Content-type": "application/json",
        },
        body: JSON.stringify({
          serviceUnit: this.serviceUnit,
        }),
      });
    } catch (e) {
      console.log(e);
    }
  }

  render() {
    return (
      <Container>
        <h1>Ausgewählter Bereich: {this.serviceUnit}</h1>
        <Col>
          <ListGroup>
            <ListGroup.Item
              onClick={() => this.postData("Test2")}
              href="/AppointmentView/Test1"
              action
            >
              Tes1
            </ListGroup.Item>
            <ListGroup.Item
              onClick={() => this.postData("Test2")}
              href="/AppointmentView/Test2"
              action
            >
              Tes2
            </ListGroup.Item>
            <ListGroup.Item
              onClick={() => this.postData("Test3")}
              href="/AppointmentView/Test3"
              action
            >
              Test3
            </ListGroup.Item>
            <ListGroup.Item
              onClick={() => this.postData("Test4")}
              href="/AppointmentView/Test4"
              action
            >
              Test4
            </ListGroup.Item>
            <ListGroup.Item
              onClick={() => this.postData("Test5")}
              href="/AppointmentView/Test5"
              action
            >
              Test5
            </ListGroup.Item>
          </ListGroup>
        </Col>
      </Container>
    );
  }
}
export default AppointmentOverview;
