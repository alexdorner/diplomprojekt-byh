import React, {Component} from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem, ButtonGroup, ToggleButton, ToggleButtonGroup, ToggleButtonRadioProps} from 'react-bootstrap';

class AppointmentOverview extends Component {

    constructor(props) {
        super(props);
        this.state = {data: []}

        if (this.props.match != null) {
            this.serviceUnit = this.props.match.params.serviceUnit;
            this.department = this.props.match.params.medicalDepartment;
        } else {
            this.serviceUnit = "serviceUnit";
            this.department = "medicalDepartment";
        }
    }

    async componentWillMount() {
        const url = "http://localhost:8080/api/appointment/GetAll";
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
    }

    render() {
        return (
            <Container>
                <h1>Termine für: {this.department} - {this.serviceUnit}</h1>
                <Row>
                    <Col>
                        <h4>Sortieren nach: </h4>
                        <div>
                            <input type="radio" value="DatumAufsteigend" name="sorted" /> Datum aufsteigend
                            <br/>
                            <input type="radio" value="DatumAbsteigend" name="sorted" /> Datum absteigend
                            <br/>
                            <input type="radio" value="KrankenhausAufsteigend" name="sorted" /> Krankenhaus aufsteigend
                            <br/>
                            <input type="radio" value="KrankenhausAbsteigend" name="sorted"/> Krankenhaus absteigend
                        </div>
                    </Col>
                    <Col>
                        <ListGroup>
                            {this.state.data.length > 0 &&
                            this.state.data.map(el => <ListGroup.Item action
                                                                      href={"/AppointmentView/" + el.id}>
                                {el.Date} {el.start} || {el.participant.filter((e) => e.id === "Location").map(el => el.actor.id)}</ListGroup.Item>)}
                        </ListGroup>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default AppointmentOverview;