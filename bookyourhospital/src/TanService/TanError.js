import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanError extends Component {

    constructor(props) {
        super(props);

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
                            <a href={"/TanServiceEmail/" + this.appointmentOverView + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent}>Tan per Email senden</a>
                        </div>
                        <div className="d-flex justify-content-center">
                            <a href={"/TanServiceSMS/" + this.appointmentOverView + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent}>Tan per SMS senden</a>
                        </div>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default TanError;