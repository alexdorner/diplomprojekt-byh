import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanServiceEmail extends Component {

    constructor(props) {
        super(props);
        this.state = {email: ''};

        this.changeEmail = this.changeEmail.bind(this);
        this.sendEmail = this.sendEmail.bind(this);
    }

    changeEmail(event) {
        this.setState({email: event.target.value});
    }

    sendEmail(event) {
        event.preventDefault();
        console.log('clicked sendEmail: ' + this.state.email);

        //TODO: Change URL localhost to Server URL
        fetch("http://localhost:3000/api/sendMail?to=" + this.state.email)
        .then(response => response.json())
        .then((jsonData) => {
            console.log(jsonData);

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
                        <div class="d-flex justify-content-center">
                            <h1>Tan per E-Mail</h1>
                        </div>
                        <Form onSubmit={this.sendEmail} method='POST'>
                            <div class="d-flex justify-content-center">
                                <input value={this.state.email} onChange={this.changeEmail} type="email" id="to" name="to" className="form-control" placeholder="E-Mail Adresse" required autoFocus></input>
                            </div>
                            <br></br>
                            <div class="d-flex justify-content-center">
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

export default TanServiceEmail;