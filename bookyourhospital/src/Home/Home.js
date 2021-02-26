import React from "react";
import { Button, Image } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import ByhLogo from "../byh_logo.svg";
import "./Home.css";

const Home = () => {
  const history = useHistory();

  return (
    <center>
      <div className="Home">
        <div className="lander">
          <Image src={ByhLogo}></Image>
          <h4>Willkommen bei BookYourHospital</h4>
          <Button
            size="lg"
            variant="dark"
            onClick={() => history.push("/Transfer")}
          >
            Starten
          </Button>
          <Button
            size="lg"
            variant="dark"
            onClick={() => history.push("/NoTransfer")}
          >
            Stornieren
          </Button>
        </div>
      </div>
    </center>
  );
};

export default Home;
