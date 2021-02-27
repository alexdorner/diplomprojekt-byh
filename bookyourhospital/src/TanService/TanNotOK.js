import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanNotOK extends Component {

    constructor(props) {
        super(props);

        if(this.props.match != null) {
            this.parent = this.props.match.params.parent
            this.type = this.props.match.params.type
            this.to = this.props.match.params.to
        } else {
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
                            <a href={"/TanCheck/" + this.parent + "/" + this.type + "/" + this.to}>Tan nochmal eingeben</a>
                        </div>
                    </Col>
                </Row>
            </Container>
        );
    }
}

export default TanNotOK;