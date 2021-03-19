import React, { Component } from 'react';
import {Button, Col, Container, Form} from "react-bootstrap";


class AppointmentCancel extends Component {

    constructor(props) {
        super(props);
        this.state = {code: ''};

        this.changeCode = this.changeCode.bind(this);
        this.getTan = this.getTan.bind(this);
    }
    changeCode(event) {
        this.setState({code: event.target.value});
    }
    getTan(event) {
        event.preventDefault();

        if(this.props.history != null) {
            this.props.history.push('/TanServiceSMS/' + this.state.code + '/0/0/0/0/AppointmentCancel/');
            this.props.history.go();
        }
    }
    render() {
        return (
            <center>
                <h1>Termin stornieren </h1>
                <Form onSubmit={this.getTan}>
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label>Hier bitte Ihren individuellen Termincode eingeben</Form.Label>
                        <Form.Control value={this.state.code} onChange={this.changeCode} type="text" placeholder="individuellen Termincode" required autoFocus/>
                    </Form.Group>
                    <Button size="lg" variant="dark" type="submit">TAN per SMS senden</Button>
                </Form>
            </center>
        );
    }
}
export default AppointmentCancel;