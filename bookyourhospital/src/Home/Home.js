import React, { Component } from "react";
import { Button, Image, ButtonGroup } from 'react-bootstrap';
import history from "../history";
import "./Home.css";
import ByhLogo from '../byh_logo.svg';

export default class Home extends Component {
  render() {
    return (
      <center>
        <div className="Home">
          <div className="lander">
            <Image src={ByhLogo}></Image>
            <h4>Willkommen bei BookYourHospital</h4>
            <Button size="lg" variant="dark" action href={'/Transfer'}>Starten</Button>
            <Button size="lg" variant="dark" action href={'/AppointmentConfirm'}>Stornieren</Button>
          </div>
        </div>
      </center>
    );
  }
}
