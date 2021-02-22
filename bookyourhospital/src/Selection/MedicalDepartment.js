import React, {Component} from 'react';
import {Button, Table, Container, Row, Col, Dropdown} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "./ServiceUnit";
import "./Selection.css";

class MedicalDepartment extends Component {
    state = {data: []}

    async componentDidMount() {
        const url = "http://localhost:8080/api/healthcareservice/Get";
        const response = await fetch(url).then(response => response.json()).then(data => this.state.data = data);
        console.log(this.state.data);
        this.state.data.map(entry => console.log(entry.name));
        var feld = document.getElementById("meineID")
        feld.innerText = this.state.data;
    }

    render() {
        return (
            <center>
                <div className="MedicalDepartment" style={{padding: 30}}>
                    <h2>Bitte wählen Sie einen Fachbereich aus!</h2>
                </div>
                <div id="data">
                    <p id="meineID"></p>
                    Ende
                </div>
                <div>
                    <Dropdown id="drop">
                        <Dropdown.Toggle variant="info" id="dropdown-basic">
                            Fachbereich auswählen
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            {this.state.data.map(el => <Dropdown.Item onClick={() => this.postData("Augenambulanz")}
                                                                      href="/ServiceUnit/Augenambulanz">{el.name}</Dropdown.Item>)}
                        </Dropdown.Menu>
                    </Dropdown>
                </div>
            </center>
        );
    }
}

export default MedicalDepartment;