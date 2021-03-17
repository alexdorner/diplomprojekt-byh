import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanCheck extends Component {

    constructor(props) {
        super(props);
        this.state = {tan: ''};

        if(this.props.match != null) {
            this.appointmentOverView = this.props.match.params.appointmentOverView;
            this.hospital = this.props.match.params.hospital;
            this.address = this.props.match.params.address;
            this.date = this.props.match.params.date;
            this.time = this.props.match.params.time;
            this.parent = this.props.match.params.parent
            this.type = this.props.match.params.type
            this.to = this.props.match.params.to
        } else {
            this.appointmentOverView = "appointmentView";
            this.hospital = "hospital";
            this.address = "address";
            this.date = "date";
            this.time = "time";
            this.parent = "parent"
            this.type = "type"
            this.to = "to"
        }

        this.changeTan = this.changeTan.bind(this);
        this.sendTan = this.sendTan.bind(this);
    }

    changeTan(event) {
        this.setState({tan: event.target.value});
    }

    sendSMSVormerken() {
        fetch("http://localhost:3000/api/appointment/vormerken?IdAppointment=" + this.appointmentOverView + "&phonenumber=" + this.to)
            .then(response => response.json())
            .then((jsonData) => {
                //console.log(jsonData);

            })
            .catch((error) => {
                console.error(error);
            })
    }

    sendEmailVormerken() {
        fetch("http://localhost:3000/api/appointment/vormerken?IdAppointment=" + this.appointmentOverView + "&mail=" + this.to)
            .then(response => response.json())
            .then((jsonData) => {
                //console.log(jsonData);

            })
            .catch((error) => {
                console.error(error);
            })
    }

    sendStorno() {
        fetch("http://localhost:3000/api/appointment/stornieren?termincode=" + this.appointmentOverView)
            .then(response => response.json())
            .then((jsonData) => {
                //console.log(jsonData);

            })
            .catch((error) => {
                console.error(error);
            })
    }

    sendTan(event) {
        event.preventDefault();
        //console.log('clicked sendTan: ' + this.state.tan);

        fetch("http://localhost:3000/api/getTan")
        .then(response => response.json())
        .then((jsonData) => {
            //console.log(jsonData);

            if(jsonData.tan == this.state.tan) {
                if(this.parent == "AppointmentCancel") {
                    this.sendStorno();
                    this.props.history.push('/AppointmentCancelConfirm/' + this.appointmentOverView);
                    this.props.history.go();
                } else {
                    if(this.type == "email") {
                        this.sendEmailVormerken();
                    } else {
                        this.sendSMSVormerken();
                    }
                    this.props.history.push('/AppointmentInformation/' + this.appointmentOverView + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent + "/" + this.type + "/" + this.to);
                    this.props.history.go();
                }
            } else {
                //console.log("nok");
                this.props.history.push('/TanNotOK/' + this.appointmentOverView + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent + "/" + this.type + "/" + this.to);
                this.props.history.go();
            }
        })
        .catch((error) => {
            console.error(error);
            this.props.history.push('/TanError/' + this.appointmentOverView + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent);
            this.props.history.go();
        })
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col xs="3"></Col>
                    <Col>
                        <br></br>
                        <Form onSubmit={this.sendTan}>
                            <Form.Group>
                                <Form.Label className="d-flex justify-content-center"><h2>Bitte geben Sie Ihre TAN an</h2></Form.Label>
                                <Form.Control value={this.state.tan} onChange={this.changeTan} type="number" placeholder="Tan" id="tan" name="tan" required autoFocus/>
                            </Form.Group>
                            <div className="d-flex justify-content-center">
                                <Button size="lg" variant="dark" type="submit">Senden</Button>
                            </div>
                        </Form>
                    </Col>
                    <Col xs="3"></Col>
                </Row>
            </Container>
        );
    }
}

export default TanCheck;

/*
    render() {
        return (
            <Container>
                <Row>
                    <Col></Col>
                    <Col>
                        <br></br>
                        <div className="d-flex justify-content-center">
                            <h2>Tan Prüfung</h2>
                        </div>
                        <Form onSubmit={this.sendTan} method='POST'>
                            <div className="d-flex justify-content-center">
                                <input value={this.state.tan} onChange={this.changeTan} type="number" id="tan" name="tan" className="form-control" placeholder="Tan" required autoFocus min="10000" max="99999"></input>
                            </div>
                            <br></br>
                            <div className="d-flex justify-content-center">
                                <Button type="submit">Senden</Button>
                            </div>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </Container>
        );
    }
}
*/
