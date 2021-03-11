import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";
import About from "./components/About";
import Contact from "./components/Contact";
import Transfer from "./Transfer/Transfer";
import NoTransfer from "./Transfer/NoTransfer";
import Home from "./components/Home";
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
import AppointmentCancelConfirm from "./Appointment/AppointmentCancelConfirm";
import AppointmentCancel from "./Appointment/AppointmentCancel";
import AppointmentInformation from "./Appointment/AppointmentInformation";
import DSGVO from "./components/DSGVO";
import Impressum from "./components/Impressum";

export default class Routes extends Component {
    render() {
        return (
            <Router history={history}>
                <Switch>
                    <Route path="/" exact component={Home} />
                    <Route path="/About" component={About} />
                    <Route path="/Contact" component={Contact} />
                    <Route path="/DSGVO" component={DSGVO}/>
                    <Route path="/Impressum" component={Impressum}/>

                    <Route path="/Transfer" component={Transfer} />
                    <Route path="/NoTransfer" component={NoTransfer}/>
                    <Route path="/WhatTransfer" component={WhatTransfer}/>

                    <Route path="/MedicalDepartment" component={Auswahl}/>
                    <Route path="/ServiceUnit/:department" component={ServiceUnit}/>

                    <Route path="/AppointmentOverview/:serviceUnit" component={AppointmentOverview}/>
                    <Route path="/AppointmentView/:appointmentOverView" component={AppointmentView}/>
                    <Route path="/AppointmentConfirm/:appointmentView" component={AppointmentConfirm}/>
                    <Route path="/AppointmentCancel" component={AppointmentCancel}/>
                    <Route path="/AppointmentInformation/:appointmentView/:parent/:type/:to" component={AppointmentInformation}/>
                    <Route path="/AppointmentCancelConfirm" component={AppointmentCancelConfirm}/>

                    <Route path="/TanServiceSMS/:appointmentOverView/:parent" component={TanServiceSms}/>
                    <Route path="/TanServiceEmail/:appointmentOverView/:parent" component={TanServiceEmail}/>
                    <Route path="/TanCheck/:appointmentOverView/:parent/:type/:to" component={TanCheck}/>
                    <Route path="/TanError/:appointmentOverView/:parent" component={TanError}/>
                    <Route path="/TanNotOK/:appointmentOverView/:parent/:type/:to" component={TanNotOK}/>
                    <Route path="/TanOK/:appointmentOverView/:parent/:type/:to" component={TanOK}/>
                </Switch>
            </Router>
        )
    }
}
