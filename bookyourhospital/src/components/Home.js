import React, { Component } from "react";
import {Button, Image, ButtonGroup, Row, Col} from 'react-bootstrap';
import "./Home.css";
import ByhLogo from '../byh_logo.svg';

export default class Home extends Component {
  render() {
    return (
      <center>
        <div>
          <Image height="200" width="500" src={ByhLogo}></Image>
        </div>
        <h4>Willkommen bei BookYourHospital</h4>
        <div>
          <Row>
            <Col>
              <Button size="lg" variant="dark" action href={'/Transfer'}>Starten</Button>
            </Col>
            <Col>
              <Button size="lg" variant="dark" action href={'/AppointmentCancel'}>Stornieren</Button>
            </Col>
          </Row>
        </div>
      </center>
    );
  }
}
