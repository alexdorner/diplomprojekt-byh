//Nach dem TAN
//Termincode
//Wird per SMS gesendet --> Beenden Button (Kommt man auf Home)
import React, {Component} from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";
import AppointmentOverview from "./AppointmentOverview";
import {MapContainer, Marker, TileLayer} from "react-leaflet";
import 'leaflet/dist/leaflet.css';
import 'leaflet/dist/leaflet';

class AppointmentInformation extends Component {

    constructor(props) {
        super(props);
        this.state = {data: [], hospital: "", address: "", date: "", time: ""};

        if (this.props.match != null) {
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
        const url = "http://localhost:8080/api/appointment/" + this.appointmentOverView;
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
        this.state.data.participant.filter((e) => e.id === "Location").map(el => this.setState({hospital: el.actor.id.split('-')[0]}))
        this.state.data.participant.filter((e) => e.id === "Location").map(el => this.setState({address: el.actor.id.split('-')[1]}))
        this.setState({date: this.state.data.Date})
        this.setState({time: this.state.data.start})
    }

    render() {
        return (
            <center>
                <h1>Ihr Termin</h1>
                <h2>{this.appointmentOverView}</h2>
                <Row>
                    <Col>
                        <p>Krankenhaus: {this.state.hospital}</p>
                        <p>Adresse: {this.state.address}</p>
                        <p>Datum: {this.state.date}</p>
                        <p>Uhrzeit: {this.state.time}</p>
                    </Col>
                    <Col>
                        <MapContainer center={[48.196417, 16.390882]} zoom={10} style={{width: '18rem'}}>
                            <TileLayer
                                attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                            />
                            <Marker position={[48.196417, 16.390882]}/>
                        </MapContainer>
                    </Col>
                </Row>
                <div> {/*<!-- Termin wird im KIS vorgemerkt -->*/}
                    <Button size="lg" variant="dark" type="submit" action
                            href={'/TanOK/' + this.appointmentView + '/' + this.hospital + '/' + this.address + '/' + this.date + '/' + this.time + '/' + this.parent + '/' + this.type + '/' + this.to}>Termin
                        vormerken beenden</Button>
                </div>
            </center>
        );
    }

}

export default AppointmentInformation;