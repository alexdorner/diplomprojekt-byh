//Nach dem TAN
//Termincode
//Wird per SMS gesendet --> Beenden Button (Kommt man auf Home)
import React, { Component } from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";
import AppointmentOverview from "./AppointmentOverview";
import {MapContainer, Marker, TileLayer} from "react-leaflet";

class AppointmentInformation extends Component{

    constructor(props) {
        super(props);
        this.state = {data: [], hospital: "", address: "", date: "", time: ""};

        if(this.props.match != null) {
            this.appointmentView = this.props.match.params.appointmentView;
            this.hospital = this.props.match.params.hospital;
            this.address = this.props.match.params.address;
            this.date = this.props.match.params.date;
            this.time = this.props.match.params.time;
            this.parent = this.props.match.params.parent
            this.type = this.props.match.params.type
            this.to = this.props.match.params.to
        } else {
            this.appointmentView = "appointmentView";
            this.hospital = "hospital";
            this.address = "address";
            this.date = "date";
            this.time = "time";
            this.parent = "parent"
            this.type = "type"
            this.to = "to"
        }
    }

    async componentDidMount() {
        const url = "/api/appointment/" + this.appointmentOverView;
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
        this.setState({date: this.state.data.Date})
        this.setState({time: this.state.data.start})
    }

    render() {
        return (
            <center>
                <h1>Ihr Termin</h1>
                <h2>{this.appointmentOverView}</h2>

                <div> {/*<!-- Termin wird im KIS vorgemerkt -->*/}
                    <Button size="lg" variant="dark" type="submit" action href={'/TanOK/' + this.appointmentView + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent + '/' + this.type + '/' + this.to}>Termin vormerken beenden</Button>
                </div>
            </center>
        );
    }

}
export default AppointmentInformation;