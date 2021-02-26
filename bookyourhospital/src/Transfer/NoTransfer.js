import React from "react";
import { Button } from "react-bootstrap";
import { useHistory } from "react-router-dom";

const NoTransfer = () => {
  const history = useHistory();

  return (
    <center>
      <div className="KeineUeberweisung" style={{ padding: 30 }}>
        <Button size={"lg"} variant="dark" onClick={() => history.push("/")}>
          Zurück zum Start
        </Button>
      </div>
      <div className="KeineUeberweisung" style={{ padding: 30 }}>
        <Button
          size={"lg"}
          variant="dark"
          onClick={() => history.push("/WasUeberweisung")}
        >
          Was ist eine Überweisung?
        </Button>
      </div>
    </center>
  );
};
export default NoTransfer;
