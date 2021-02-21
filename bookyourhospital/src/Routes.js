import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";
import About from "./About/About";
import Contact from "./Contact/Contact";
import Transfer from "./Transfer/Transfer";
import NoTransfer from "./Transfer/NoTransfer";
import Home from "./Home/Home";
import history from './history';
import Auswahl from "./Selection/MedicalDepartment";
import ServiceUnit from "./Selection/ServiceUnit";
import TanServiceSms from "./TanService/TanServiceSMS";
import TanServiceEmail from "./TanService/TanServiceEmail";
import TanCheck from "./TanService/TanCheck";
import TanError from "./TanService/TanError";
import TanNotOK from "./TanService/TanNotOK";
import TanOK from "./TanService/TanOK";
import AppointmentOverview from "./Appointment/AppointmentOverview";
import WhatTransfer from "./Transfer/WhatTransfer";
import AppointmentView from "./Appointment/AppointmentView";
import AppointmentConfirm from "./Appointment/AppointmentConfirm";
import AppointmentCancel from "./Appointment/AppointmentCancel";

export default class Routes extends Component {
    render() {
        return (
            <Router history={history}>
                <Switch>
                    <Route path="/" exact component={Home} />
                    <Route path="/About" component={About} />
                    <Route path="/Contact" component={Contact} />

                    <Route path="/Transfer" component={Transfer} />
                    <Route path="/NoTransfer" component={NoTransfer}/>
                    <Route path="/WhatTransfer" component={WhatTransfer}/>

                    <Route path="/MedicalDepartment" component={Auswahl}/>
                    <Route path="/ServiceUnit/:department" component={ServiceUnit}/>

                    <Route path="/AppointmentOverview/:serviceUnit" component={AppointmentOverview}/>
                    <Route path="/AppointmentView/:appointmentOverView" component={AppointmentView}/>
                    <Route path="/AppointmentConfirm/:appointmentView" component={AppointmentConfirm}/>
                    <Route path="/AppointmentCancle" component={AppointmentCancel}/>

                    <Route path="/TanServiceSMS" component={TanServiceSms}/>
                    <Route path="/TanServiceEmail" component={TanServiceEmail}/>
                    <Route path="/TanCheck" component={TanCheck}/>
                    <Route path="/TanError" component={TanError}/>
                    <Route path="/TanNotOK" component={TanNotOK}/>
                    <Route path="/TanOK" component={TanOK}/>
                </Switch>
            </Router>
        )
    }
}
