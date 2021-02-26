import React, { Component } from "react";
import { Button, Container, Row } from "react-bootstrap";
import { withRouter } from "react-router-dom";

class AppointmentView extends Component {
  appointmentOverView = this.props.match.params.appointmentOverView;

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
          appointmentOverView: this.appointmentOverView,
        }),
      });
    } catch (e) {
      console.log(e);
    }
  }

  render() {
    return (
      <Container>
        <h1>Ausgewählter Termin: {this.appointmentOverView}</h1>
        <Row>
          <p>Adresse so und so</p>
        </Row>
        <Row>
          <p>Map</p>
        </Row>
        <Button
          size="lg"
          variant="dark"
          onClick={() => this.props.history.push("/AppointmentInformation")}
        >
          Weiter
        </Button>
      </Container>
    );
  }
}
export default withRouter(AppointmentView);
