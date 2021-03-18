import React, {Component} from 'react';
import {Image, InputGroup} from "react-bootstrap";
import {text} from './AboutBYH.txt';
import ByhLogo from "../byh_logo.svg";

class About extends Component {

    render() {
        return (
            <center>
                <div style={{display: 'flex', justifyContent: 'center', padding: 30}}>
                    <h2>Über BookYourHospital!</h2>
                </div>
                <div>
                    <a>
                        "BookYourHospital" ist ein Diplomprojekt von vier Schülerinnen aus der HTL Spengergasse.
                    </a>
                    <a>
                        Dies wurde in einer Zusammenarbeit mit Accenture GmbH geplant und entwickelt.
                    </a>
                    <Image height="200" width="500" src={ByhLogo}></Image>
                </div>
            </center>
        );
    }
}

export default About;
