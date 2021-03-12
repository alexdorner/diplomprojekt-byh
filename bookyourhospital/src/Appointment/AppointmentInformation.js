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
    state = {data: [], hospital: "", address: "", date: "", time: ""}
    appointmentOverView = this.props.match.params.appointmentOverView

    async componentDidMount() {
        const url = "/api/appointment/" + this.appointmentOverView;
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
        this.state.data.participant.filter((e) => e.id === "Location").map(el => this.setState({hospital: el.actor.id.split('-')[0]}))
        this.state.data.participant.filter((e) => e.id === "Location").map(el => this.setState({address:  el.actor.id.split('-')[1]}))
        this.setState({date: this.state.data.Date})
        this.setState({time: this.state.data.start})
    }

    constructor(props) {
        super(props);

        if(this.props.match != null) {
            this.parent = this.props.match.params.parent
            this.type = this.props.match.params.type
            this.to = this.props.match.params.to
            this.appointmentView = this.props.match.params.appointmentView;
        } else {
            this.parent = "parent"
            this.type = "type"
            this.to = "to"
            this.appointmentView = "appointmentView";
        }
    }


    render() {
        return (
            <center>
                <h1>Ihr Termin</h1>
                <Row>
                    <Col>
                        <p>Krankenhaus: {this.state.hospital}</p>
                        <p>Adresse: {this.state.address}</p>
                        <p>Datum: {this.state.date}</p>
                        <p>Uhrzeit: {this.state.time}</p>
                    </Col>
                    <Col >
                        <MapContainer center={[48.196417,16.390882]} zoom={26} style={{ width: '18rem' }}>
                            <TileLayer
                                attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                            />
                            <Marker position={[48.196417,16.390882]}/>
                        </MapContainer>

                    </Col>
                </Row>
                <div> {/*<!-- Termin wird im KIS vorgemerkt -->*/}
                    <Button size="lg" variant="dark" type="submit" action href={'/TanOK/' + this.appointmentView + '/' + this.parent + '/' + this.type + '/' + this.to}>Termin vormerken beenden</Button>
                </div>
            </center>
        );
    }

}
export default AppointmentInformation;