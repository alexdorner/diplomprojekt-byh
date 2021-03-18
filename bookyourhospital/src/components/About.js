import React, {Component} from 'react';
import {Image} from "react-bootstrap";
import byh from "../byh.png";

class About extends Component {

    render() {
        return (
            <center>
                <div style={{display: 'flex', justifyContent: 'center', padding: 30}}>
                    <h2>Über BookYourHospital!</h2>
                </div>
                <p>
                    "BookYourHospital" ist ein Diplomprojekt von vier Schülerinnen aus der HTL Spengergasse.
                </p>
                <p>
                    Dies wurde in einer Zusammenarbeit mit Accenture GmbH geplant und entwickelt.
                </p>
                <Image height="200" width="300" src={byh}></Image>
            </center>
        );
    }
}

export default About;
