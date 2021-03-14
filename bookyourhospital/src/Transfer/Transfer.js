import React, { Component } from 'react';
import { Button, Table, Container, Row, Col } from 'react-bootstrap';
import history from "../history";
import { withRouter } from 'react-router-dom';
import "./Transfer.css";


class Transfer extends Component {
    render() {
        return (
            <center>
                <div className="Ueberweisung" style={{ padding: 30 }}>
                    <h2>Haben Sie eine Zuweisung?</h2>
                </div>
                <div style={{ padding: 10 }}>
                    <Button variant="dark" action href={'/MedicalDepartment'}>Ja</Button>
                </div>
                <div style={{ padding: 10 }}>
                    <Button variant="dark" action href={'/NoTransfer'}>Nein</Button>
                </div>
                <div style={{ padding: 10 }}>
                    <Button variant="dark" action href={'/WhatTransfer'}>Was ist eine Zuweisung?</Button>
                </div>
            </center>
        );
    }
}

export default Transfer;