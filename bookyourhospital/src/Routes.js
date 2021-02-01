import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";
import About from "./About/About";
import Contact from "./Contact/Contact";
import Ueberweisung from "./Ueberweisung/Ueberweisung";
import Home from "./Home/Home";
import history from './history';
import Auswahl from "./Auswahl/MedicalDepartment";
import TanServiceSms from "./TanService/TanServiceSMS";
import TanServiceEmail from "./TanService/TanServiceEmail";
import TanCheck from "./TanService/TanCheck";
import TanError from "./TanService/TanError";
import TanNotOK from "./TanService/TanNotOK";

export default class Routes extends Component {
    render() {
        return (
            <Router history={history}>
                <Switch>
                    <Route path="/" exact component={Home} />
                    <Route path="/About" component={About} />
                    <Route path="/Contact" component={Contact} />
                    <Route path="/Ueberweisung" component={Ueberweisung} />
                    <Route path="/MedicalDepartment" component={Auswahl}/>
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
