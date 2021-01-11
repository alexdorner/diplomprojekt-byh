import React, { Component } from "react";
import { Button, Image } from 'react-bootstrap';
import history from "../history";
import "./Home.css";

export default class Home extends Component {
  render() {
    return (
      <div className="Home">
        <div className="lander">
          <Image src = "./byh_logo.svg"></Image>
          <p>Willkommen bei BookYourHospital</p>
          <form>
            <Button variant="dark" onClick={() => history.push('/Ueberweisung')}>Starten</Button>
          </form>
        </div>
      </div>
    );
  }
}
