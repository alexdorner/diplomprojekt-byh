import React, {Component} from 'react';
import {Button, Table, Container, Row, Col, Dropdown} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "./ServiceUnit";
import "./Selection.css";

class MedicalDepartment extends Component {
    state = {data: []}

    async componentWillMount() {
        const url = "http://localhost:8080/api/healthcareservice/Get";
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
        //console.log(this.state.data.name);
        //this.state.data.map(entry => console.log(entry.name));
    }

    render() {
        return (
            <center>
                <div className="MedicalDepartment" style={{padding: 30}}>
                    <h2>Bitte wählen Sie einen Fachbereich aus!</h2>
                </div>
                <div>
                    <Dropdown id="drop">
                        <Dropdown.Toggle variant="info" id="dropdown-basic">
                            Fachbereich auswählen
                        </Dropdown.Toggle>
                        <Dropdown.Menu>
                            {this.state.data.map(el => <Dropdown.Item href={"ServiceUnit/"+el.name}>{el.name}</Dropdown.Item>)}
                        </Dropdown.Menu>
                    </Dropdown>
                </div>
            </center>
        );
    }
}

export default MedicalDepartment;