import React, { Component } from "react";
import { Button, Image } from 'react-bootstrap';
import history from "../history";
import "./Home.css";
import ByhLogo from '../byh_logo.svg';

export default class Home extends Component {
  render() {
    return (
      <div className="Home">
        <div className="lander">
          <img src={ByhLogo}></img>
          <p>Willkommen bei BookYourHospital</p>
          <form>
            <Button variant="dark" onClick={() => history.push('/Ueberweisung')}>Starten</Button>
          </form>
        </div>
      </div>
    );
  }
}
