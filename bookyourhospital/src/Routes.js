import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";
import About from "./About/About";
import Contact from "./Contact/Contact";
import Ueberweisung from "./Ueberweisung/Ueberweisung";
import KeineUeberweisung from "./Ueberweisung/KeineUeberweisung";
import Home from "./Home/Home";
import history from './history';
import Auswahl from "./Auswahl/MedicalDepartment";
import ServiceUnit from "./Auswahl/ServiceUnit";
import TanServiceSms from "./TanService/TanServiceSMS";
import TanServiceEmail from "./TanService/TanServiceEmail";
import TanCheck from "./TanService/TanCheck";
import TanError from "./TanService/TanError";
import TanNotOK from "./TanService/TanNotOK";
import AppointmentOverview from "./Appointment/AppointmentOverview";
import WasUeberweisung from "./Ueberweisung/WasUeberweisung";
import AppointmentView from "./Appointment/AppointmentView";
import AppointmentConfirm from "./Appointment/AppointmentConfirm";

export default class Routes extends Component {
    render() {
        return (
            <Router history={history}>
                <Switch>
                    <Route path="/" exact component={Home} />
                    <Route path="/About" component={About} />
                    <Route path="/Contact" component={Contact} />

                    <Route path="/Ueberweisung" component={Ueberweisung} />
                    <Route path="/KeineUeberweisung" component={KeineUeberweisung}/>
                    <Route path="/WasUeberweisung" component={WasUeberweisung}/>

                    <Route path="/MedicalDepartment" component={Auswahl}/>
                    <Route path="/ServiceUnit/:department" component={ServiceUnit}/>

                    <Route path="/AppointmentOverview/:serviceUnit" component={AppointmentOverview}/>
                    <Route path="/AppointmentView/:appointmentOverView" component={AppointmentView}/>
                    <Route path="/AppointmentConfirm/:appointmentView" component={AppointmentConfirm}/>

                    <Route path="/TanServiceSMS" component={TanServiceSms}/>
                    <Route path="/TanServiceEmail" component={TanServiceEmail}/>
                    <Route path="/TanCheck" component={TanCheck}/>
                    <Route path="/TanError" component={TanError}/>
                    <Route path="/TanNotOK" component={TanNotOK}/>
                </Switch>
            </Router>
        )
    }
}
