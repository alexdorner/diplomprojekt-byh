import React, {Component} from 'react';
import {Image, Row, Col, Container} from "react-bootstrap";
import accenture from "../accenture_logo.PNG";
import ByhLogo from '../byh_logo.svg';
import spengergasse from '../spengergasse_logo.png';

class Contact extends Component {
    render() {
        return (
            <center>
                <Container>
                    <Row>
                        <Col></Col>
                        <Col>
                            <h2>Kontakt</h2>
                        </Col>
                        <Col></Col>
                    </Row>
                    <Row>
                        <Col></Col>
                        <Col>
                            <p>Name: BookYourHospital</p>
                            <p>Organisation: HTL Spengergasse</p>
                            <p>Partner: Accenture GmbH</p>
                            <p>Art: Diplomprojekt</p>
                        </Col>
                        <Col></Col>
                    </Row>
                    <Row>
                        <Col>
                            <Image height="100" width="400" src={accenture}></Image>
                        </Col>
                        <Col>
                            <Image height="100" width="300" src={ByhLogo}></Image>
                        </Col>
                        <Col>
                            <Image height="100" width="300" src={spengergasse}></Image>
                        </Col>
                    </Row>
                </Container>
            </center>
        );
    }
}

export default Contact;