import React, { Component } from 'react';
import { Row, Col, Container, Form, Button } from 'react-bootstrap';
import "./TanService.css"

class TanOK extends Component {

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

        this.sendSMS();
    }

    sendSMS() {
        //Change URL localhost to Server URL
        if(this.type == "email") {
            fetch("http://localhost:3000/api/sendSummaryEmail?to=" + this.to + "&tc=" + this.appointmentOverView + "&kh=" + this.hospital + "&addr=" + this.address + "&termin=" + this.date + " " + this.time)
            .then(response => response.json())
            .then((jsonData) => {
            console.log(jsonData);
            })
        } else {
            fetch("http://localhost:3000/api/sendSummarySms?to=" + this.to + "&tc=" + this.appointmentOverView + "&kh=" + this.hospital + "&addr=" + this.address + "&termin=" + this.date + " " + this.time)
            .then(response => response.json())
            .then((jsonData) => {
            //console.log(jsonData);
            })
        }

        if(this.props.history != null) {
            this.props.history.push('/AppointmentConfirm/' + this.appointmentOverView);
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