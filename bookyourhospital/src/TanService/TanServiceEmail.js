import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanServiceEmail extends Component {
    constructor(props) {
        super(props);
        this.state = {email: ''};

        if(this.props.match != null) {
            this.appointmentOverView = this.props.match.params.appointmentOverView;
            this.hospital = this.props.match.params.hospital;
            this.address = this.props.match.params.address;
            this.date = this.props.match.params.date;
            this.time = this.props.match.params.time;
            this.parent = this.props.match.params.parent;
        } else {
            this.appointmentOverView = "appointmentView";
            this.hospital = "hospital";
            this.address = "address";
            this.date = "date";
            this.time = "time";
            this.parent = "parent";
        }

        this.changeEmail = this.changeEmail.bind(this);
        this.sendEmail = this.sendEmail.bind(this);
    }

    changeEmail(event) {
        this.setState({email: event.target.value});
    }

    sendEmail(event) {
        event.preventDefault();
        //console.log('clicked sendEmail: ' + this.state.email);

        //TODO: Change URL localhost to Server URL
        fetch("http://localhost:3000/api/sendMail?to=" + this.state.email)
            .then(response => response.json())
            .then((jsonData) => {
                //console.log(jsonData);

                if (jsonData.returnCode == "ok") {
                    this.props.history.push('/TanCheck/' + this.appointmentOverView  + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent + "/email/" + this.state.email);
                    this.props.history.go();
                } else {
                    this.props.history.push('/TanError/' + this.appointmentOverView  + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent);
                    this.props.history.go();
                }
            })
            .catch((error) => {
                console.error(error);
                this.props.history.push('/TanError/' + this.appointmentOverView  + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent);
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
            <Form onSubmit={this.sendEmail}>
                <Form.Group>
                    <Form.Label className="d-flex justify-content-center"><h3>Bitte geben Sie Ihre E-Mail an</h3></Form.Label>
                    <Form.Control value={this.state.email} onChange={this.changeEmail} type="email" placeholder="E-Mail Adresse" id="to" name="to" required autoFocus/>
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

export default TanServiceEmail;

/*

    render() {
        return (
            <Container>
                <Row>
                    <Col></Col>
                    <Col>
                        <br></br>
                        <div className="d-flex justify-content-center">
                            <h1>Tan per E-Mail</h1>
                        </div>
                        <Form onSubmit={this.sendEmail} method='POST'>
                            <div className="d-flex justify-content-center">
                                <input value={this.state.email} onChange={this.changeEmail} type="email" id="to" name="to" className="form-control" placeholder="E-Mail Adresse" required autoFocus></input>
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

 */


