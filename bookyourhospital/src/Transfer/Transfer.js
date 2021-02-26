import React from "react";
import { Button } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "./Transfer.css";

const Transfer = () => {
  const history = useHistory();

  return (
    <center>
      <div className="Ueberweisung" style={{ padding: 30 }}>
        <h2>Haben Sie eine Transfer?</h2>
      </div>
      <div style={{ padding: 10 }}>
        <Button
          variant="dark"
          onClick={() => history.push("/MedicalDepartment")}
        >
          Ja
        </Button>
      </div>
      <div style={{ padding: 10 }}>
        <Button variant="dark" onClick={() => history.push("/NoTransfer")}>
          Nein
        </Button>
      </div>
      <div style={{ padding: 10 }}>
        <Button variant="dark" onClick={() => history.push("/WhatTransfer")}>
          Was ist eine Transfer?
        </Button>
      </div>
    </center>
  );
};

export default Transfer;
