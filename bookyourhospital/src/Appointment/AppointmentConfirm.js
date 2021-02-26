import React, { Component } from "react";
import { Col, Container } from "react-bootstrap";

class AppointmentConfirm extends Component {
  appointmentInformation = this.props.match.params.appointmentInformation;

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
          appointmentInformation: this.appointmentInformation,
        }),
      });
    } catch (e) {
      console.log(e);
    }
  }

  render() {
    return (
      <Container>
        <h1>Ausgewählter Termin: {this.appointmentInformation}</h1>
        <Col>
          <p>Adresse so und so</p>
        </Col>
        <Col>
          <div style={{ height: "100vh", width: "100%" }}></div>
        </Col>
      </Container>
    );
  }
}
export default AppointmentConfirm;
