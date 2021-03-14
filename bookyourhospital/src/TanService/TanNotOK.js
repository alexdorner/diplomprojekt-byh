import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanNotOK extends Component {

    constructor(props) {
        super(props);

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
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col>
                        <br></br>
                        <div className="d-flex justify-content-center">
                            <h4>Der Tan stimmt mit dem gesendeten Tan nicht überein</h4>
                        </div>
                        <div className="d-flex justify-content-center">
                            <a href={"/TanCheck/" + this.appointmentOverView + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent + "/" + this.type + "/" + this.to}>Tan nochmal eingeben</a>
                        </div>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default TanNotOK;