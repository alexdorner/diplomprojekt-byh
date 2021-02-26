import React, { Component } from "react";
import { Dropdown } from "react-bootstrap";

class ServiceUnit extends Component {
  department = this.props.match.params.department;

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
          department: this.department,
        }),
      });
    } catch (e) {
      console.log(e);
    }
  }

  render() {
    return (
      <center>
        <div style={{ padding: 30 }}>
          <h1>Ausgewählte Abteilung: {this.department}</h1>
          <div style={{ padding: 30 }}>
            <h5>Bitte wählen Sie eine Art aus!</h5>
          </div>
          <div style={{ padding: 30 }}>
            <Dropdown>
              <Dropdown.Toggle variant="info" id="dropdown-basic">
                Art auswählen
              </Dropdown.Toggle>
              <Dropdown.Menu>
                <Dropdown.Item
                  onClick={() => this.postData("Mittelfuß")}
                  href="/AppointmentOverview/Mittelfuß"
                >
                  Mittelfuß
                </Dropdown.Item>
                <Dropdown.Item
                  onClick={() => this.postData("Hüfte")}
                  href="/AppointmentOverview/Huefte"
                >
                  Hüfte
                </Dropdown.Item>
                <Dropdown.Item
                  onClick={() => this.postData("Schulter")}
                  href="/AppointmentOverview/Schulter"
                >
                  Schulter
                </Dropdown.Item>
              </Dropdown.Menu>
            </Dropdown>
          </div>
        </div>
      </center>
    );
  }
}
export default ServiceUnit;
