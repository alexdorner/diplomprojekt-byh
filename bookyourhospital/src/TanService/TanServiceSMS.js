import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanServiceSMS extends Component {

    constructor(props) {
        super(props);
        this.state = {sms: ''};

        this.changeSMS = this.changeSMS.bind(this);
        this.sendSMS = this.sendSMS.bind(this);
    }

    changeSMS(event) {
        this.setState({sms: event.target.value});
    }

    sendSMS(event) {
        event.preventDefault();
        //console.log('clicked sendSMS: ' + this.state.sms);

        //Change URL localhost to Server URL
        fetch("http://localhost:3000/api/sendSms?to=" + this.state.sms)
        .then(response => response.json())
        .then((jsonData) => {
            //console.log(jsonData);

            if(jsonData.returnCode == "ok") {
                this.props.history.push('/TanCheck');
                this.props.history.go();
            } else {
                this.props.history.push('/TanError');
                this.props.history.go();
            }
        })
        .catch((error) => {
            console.error(error);
            this.props.history.push('/TanError');
            this.props.history.go();
        })
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col></Col>
                    <Col>
                        <br></br>
                        <Form onSubmit={this.sendSMS}>
                            <Form.Group>
                                <Form.Label className="d-flex justify-content-center"><h1>Tan per SMS</h1></Form.Label>
                                <Form.Control value={this.state.sms} onChange={this.changeSMS} type="sms" placeholder="Telefonnummer (+431234567)" id="to" name="to" required autoFocus/>
                            </Form.Group>
                            <div className="d-flex justify-content-center">
                                <Button size="lg" variant="dark" type="submit">Senden</Button>
                            </div>
                        </Form>
                    </Col>
                    <Col></Col>
                </Row>
            </Container>
        );
    }
}

export default TanServiceSMS;

/*
    render() {
        return (
            <Container>
                <Row>
                    <Col></Col>
                    <Col>
                        <br></br>
                        <div className="d-flex justify-content-center">
                            <h1>Tan per SMS</h1>
                        </div>
                        <Form onSubmit={this.sendSMS} method='POST'>
                            <div className="d-flex justify-content-center">
                                <input value={this.state.sms} onChange={this.changeSMS} type="tel" id="to" name="to" className="form-control" placeholder="Telefonnummer (+431234567)" required autoFocus></input>
                            </div>
                            <br></br>
                            <div className="d-flex justify-content-center">
                                <Button size="lg" variant="dark" type="submit">Senden</Button>
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

