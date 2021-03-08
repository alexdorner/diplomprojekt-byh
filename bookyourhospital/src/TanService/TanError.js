import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanError extends Component {

    constructor(props) {
        super(props);

        if(this.props.match != null) {
            this.parent = this.props.match.params.parent;
            this.appointmentOverView = this.props.match.params.appointmentOverView;
        } else {
            this.parent = "parent";
            this.appointmentOverView = "appointmentView";
        }
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col>
                        <br></br>
                        <div className="d-flex justify-content-center">
                            <h4>Leider gab es ein Problem beim Versenden</h4>
                        </div>
                        <div className="d-flex justify-content-center">
                            <a href={"/TanServiceEmail/" + this.appointmentOverView + '/' + this.parent}>Tan per Email senden</a>
                        </div>
                        <div className="d-flex justify-content-center">
                            <a href={"/TanServiceSMS/" + this.appointmentOverView + '/' + this.parent}>Tan per SMS senden</a>
                        </div>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default TanError;