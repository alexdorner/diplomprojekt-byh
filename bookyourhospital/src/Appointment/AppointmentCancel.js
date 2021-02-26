import React, { Component } from "react";
import { withRouter } from "react-router-dom";

class AppointmentCancel extends Component {
  appointmentView = this.props.match.params.appointmentView;

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
          appointmentView: this.appointmentView,
        }),
      });
    } catch (e) {
      console.log(e);
    }
  }

  render() {
    return (
      <center>
        <h1>Termin stornieren </h1>
        <div>
          <form>
            <button type="submit">Weiter</button>
          </form>
        </div>
      </center>
    );
  }
}
export default withRouter(AppointmentCancel);
