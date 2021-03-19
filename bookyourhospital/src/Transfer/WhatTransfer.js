import React, { Component } from 'react';
import "./Transfer.css";
import {Image} from "react-bootstrap";
import link from '../link.png';
import ByhLogo from "../byh_logo.svg";


class WhatTransfer extends Component {

    render() {
        return (
            <center>
                <h2>Was ist eine Zuweisung?</h2>
                <p>
                    Eine Überweisung im medizinischen Bereich wird von einer niedergelassenen die praktische Ärztin/der praktische Arzt ausgestellt und
                </p>
                <p>
                    übermittelt die Patientin/den Patienten an eine Fachärztin/einen Facharzt. Grundsätzlich unterscheidet man zwischen drei Arten,
                </p>
                <p>
                    Über- Zu und Einweisung, welche aber ab dem Ausstellungstag nur ein Monat eine Gültigkeit haben. Für die Benutzung unsere Webapplikation
                </p>
                <p>
                    wird eine Zuweisung benötigt, diese weist eine konkrete Untersuchung vor.
                </p>
                <p>
                    „Die Ärztin/der Arzt weist die Patientin/den Patienten mit einem konkreten Untersuchungsauftrag einer anderen Ärztin/einem anderen Arzt zu.“
                </p>
                <div className="d-flex justify-content-center">
                    <Image height="15" width="15" src={link}></Image>
                    <a href={'https://www.gesundheit.gv.at/gesundheitsleistungen/antraege/ueberweisung-facharzt'} target="_blank">Mehr über Zuweisungen</a>
                </div>
            </center>
        );
    }

}
export default WhatTransfer;