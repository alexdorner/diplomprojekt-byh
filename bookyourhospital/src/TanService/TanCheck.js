import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanCheck extends Component {

    constructor(props) {
        super(props);
        this.state = {tan: ''};

        this.changeTan = this.changeTan.bind(this);
        this.sendTan = this.sendTan.bind(this);
    }

    changeTan(event) {
        this.setState({tan: event.target.value});
    }

    sendTan(event) {
        event.preventDefault();
        //console.log('clicked sendTan: ' + this.state.tan);

        //TODO: Change URL localhost to Server URL
        fetch("http://localhost:3000/api/getTan")
        .then(response => response.json())
        .then((jsonData) => {
            //console.log(jsonData);

            if(jsonData.tan == this.state.tan) {
                //TODO: Redirect to Url for Tan OK
                this.props.history.push('/TanOK');
                this.props.history.go();
            } else {
                //console.log("nok");
                this.props.history.push('/TanNotOK');
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
                        <Form onSubmit={this.sendTan}>
                            <Form.Group>
                                <Form.Label className="d-flex justify-content-center"><h2>Tan Prüfung</h2></Form.Label>
                                <Form.Control value={this.state.tan} onChange={this.changeTan} type="number" placeholder="Tan" id="tan" name="tan" required autoFocus/>
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
