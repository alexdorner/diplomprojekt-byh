import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";
import About from "./About/About";
import Contact from "./Contact/Contact";
import Ueberweisung from "./Ueberweisung/Ueberweisung";
import Home from "./Home/Home";
import history from './history';
import Auswahl from "./Auswahl/MedicalDepartment";
import TanService from "./TanService/TanServiceSMS";

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
                    <Route path="/TanServiceSMS" component={TanService}/>
                </Switch>
            </Router>
        )
    }
}
