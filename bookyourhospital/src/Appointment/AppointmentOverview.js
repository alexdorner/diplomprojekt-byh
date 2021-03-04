import React, { Component } from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";

class AppointmentOverview extends Component{
    state = {data: []}
    serviceUnit = this.props.match.params.serviceUnit
    async componentWillMount() {
        const url = "http://localhost:8080/api/appointment/GetAll";
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
       // console.log(this.state.data);
    }

    /*async componentDidMount(){
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

    }*/

    render() {
        return (
            <Container>
                <h1>Ausgewählter Bereich: {this.serviceUnit}</h1>
                <Col>
                   <ListGroup>
                       {this.state.data.map(el => <ListGroup.Item action href={"/AppointmentView/"+el.id}>{el.Date} {el.start}</ListGroup.Item>)}
                   </ListGroup>
               </Col>
            </Container>
        );
    }
}
export default AppointmentOverview;