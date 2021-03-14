import React, {Component} from 'react';
import {Button, Table, Container, Row, Col, Dropdown, ListGroup, ListGroupItem} from 'react-bootstrap';
import {MapContainer, TileLayer, Marker, Popup} from 'react-leaflet'
import history from "../history";
import ServiceUnit from "../Selection/ServiceUnit";
import 'leaflet/dist/leaflet.css';
import 'leaflet/dist/leaflet';

class AppointmentView extends Component {

    constructor(props) {
        super(props);
        this.state = {data: [], hospital: "", address: "", date: "", time: ""};

        if(this.props.match != null) {
            this.appointmentOverView = this.props.match.params.appointmentOverView;
        } else {
            this.appointmentOverView = "appointmentOverView";
        }
    }

    async componentDidMount() {
        const url = "/api/appointment/" + this.appointmentOverView;
        const response = await fetch(url).then(response => response.json()).then(recievedData => this.setState({data: recievedData}));
        this.state.data.participant.filter((e) => e.id === "Location").map(el => this.setState({hospital: el.actor.id.split('-')[0]}))
        this.state.data.participant.filter((e) => e.id === "Location").map(el => this.setState({address:  el.actor.id.split('-')[1]}))
        this.setState({date: this.state.data.Date})
        this.setState({time: this.state.data.start})
    }

    render() {
        return (
            <Container>
                <h1>Ausgewählter Termin: {this.appointmentOverView}</h1>
                <Row>
                    <Col>
                        <p>Krankenhaus: {this.state.hospital}</p>
                        <p>Adresse: {this.state.address}</p>
                        <p>Datum: {this.state.date}</p>
                        <p>Uhrzeit: {this.state.time}</p>
                    </Col>
                    <Col>
                        <MapContainer center={[48.196417,16.390882]} zoom={10} style={{ width: '18rem' }}>
                            <TileLayer
                                attribution='&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
                                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
                            />
                            <Marker position={[48.196417,16.390882]}/>
                        </MapContainer>

                    </Col>
                </Row>
                <Button size="lg" variant="dark" action
                        href={'/TanServiceSMS/' + this.appointmentOverView + '/' + this.state.hospital + '/' + this.state.address + '/' + this.state.date + '/' + this.state.time + '/AppointmentView/'}>TAN per SMS
                    senden</Button>
            </Container>
        );
    }
}

export default AppointmentView;