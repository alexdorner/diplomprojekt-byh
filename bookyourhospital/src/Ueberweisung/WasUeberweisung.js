import React, { Component } from 'react';
import { Button, Table, Container, Row, Col } from 'react-bootstrap';
import history from "../history";
import { withRouter } from 'react-router-dom';
import "./Ueberweisung.css";


class WasUeberweisung extends Component {

    render() {
        return (
            <center>
                <h2>Was ist eine Überweisung?</h2>
            </center>
        );
    }

}
export default withRouter(WasUeberweisung);