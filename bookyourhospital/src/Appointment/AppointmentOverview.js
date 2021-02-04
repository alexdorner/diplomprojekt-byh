import React, { Component } from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Auswahl/ServiceUnit";

class AppointmentOverview extends Component{
    serviceUnit = this.props.match.params.serviceUnit

    async componentDidMount(){
        try {
            let result = await fetch("http://localhost:8080/api", {
                method: 'post',
                mode: "cors",
                headers: {
                    'Accept': 'application/json',
                    'Content-type': 'application/json',
                },
                body: JSON.stringify({
                    serviceUnit: this.serviceUnit
                })
            })
        }
        catch (e){
            console.log(e);
        }

    }

    render() {
        return (
            <Container>
                <h1>Ausgewählter Bereich: {this.serviceUnit}</h1>
                <Col>
                   <ListGroup>
                       <ListGroup.Item onClick={() => this.postData("Test1")} href="/AppointmentView/Test1">Tes1</ListGroup.Item>
                       <ListGroup.Item onClick={() => this.postData("Test2")} href="/AppointmentView/Test2">Tes2</ListGroup.Item>
                       <ListGroup.Item onClick={() => this.postData("Test3")} href="/AppointmentView/Test3">Test3</ListGroup.Item>
                       <ListGroup.Item onClick={() => this.postData("Test4")} href="/AppointmentView/ZTest4">Test4</ListGroup.Item>
                       <ListGroup.Item onClick={() => this.postData("Test5")} href="/AppointmentView/Test5">Test5</ListGroup.Item>
                   </ListGroup>
               </Col>
            </Container>
        );
    }
}
export default AppointmentOverview;