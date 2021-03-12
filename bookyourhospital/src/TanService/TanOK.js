import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanOK extends Component {

    constructor(props) {
        super(props);

        if(this.props.match != null) {
            this.parent = this.props.match.params.parent
            this.type = this.props.match.params.type
            this.to = this.props.match.params.to
            this.appointmentOverView = this.props.match.params.appointmentOverView;
        } else {
            this.parent = "parent"
            this.type = "type"
            this.to = "to"
            this.appointmentOverView = "appointmentView";
        }

        this.sendSMS();
    }

    sendSMS() {
        //Change URL localhost to Server URL
        fetch("http://localhost:3000/api/sendSummarySms?to=" + this.to + "&tc=15&kh=AKH&str=Gürtel 5&ort=1090 Wien&termin=07.10.2020 12:30&fb=Orthopädie, Mittelfuß&ebene=7D&tel=+4369911345176")
        .then(response => response.json())
        .then((jsonData) => {
        //console.log(jsonData);
        })

        if(this.props.history != null) {
            this.props.history.push('/AppointmentInformation/' + this.appointmentOverView);
            this.props.history.go();
        }
    }

    render() {
        return (
            <Container>
            </Container>
        );
    }
}

export default TanOK;