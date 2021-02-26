import { default as React } from "react";
import {
  BrowserRouter as Router,
  Route,
  Switch,
  useHistory,
} from "react-router-dom";
import About from "./About/About";
import "./App.css";
import AppointmentCancel from "./Appointment/AppointmentCancel";
import AppointmentConfirm from "./Appointment/AppointmentConfirm";
import AppointmentInformation from "./Appointment/AppointmentInformation";
import AppointmentOverview from "./Appointment/AppointmentOverview";
import AppointmentView from "./Appointment/AppointmentView";
import Navigation from "./components/Navbar";
import Contact from "./Contact/Contact";
import Home from "./Home/Home";
import Auswahl from "./Selection/MedicalDepartment";
import ServiceUnit from "./Selection/ServiceUnit";
import TanCheck from "./TanService/TanCheck";
import TanError from "./TanService/TanError";
import TanNotOK from "./TanService/TanNotOK";
import TanOK from "./TanService/TanOK";
import TanServiceEmail from "./TanService/TanServiceEmail";
import TanServiceSms from "./TanService/TanServiceSMS";
import NoTransfer from "./Transfer/NoTransfer";
import Transfer from "./Transfer/Transfer";
import WhatTransfer from "./Transfer/WhatTransfer";

const App = () => {
  const history = useHistory();

  return (
    <div className="App">
      <Router history={history}>
        <Navigation />
        <Switch>
          <Route path="/" exact component={Home} />
          <Route path="/About" component={About} />
          <Route path="/Contact" component={Contact} />

          <Route path="/Transfer" component={Transfer} />
          <Route path="/NoTransfer" component={NoTransfer} />
          <Route path="/WhatTransfer" component={WhatTransfer} />

          <Route path="/MedicalDepartment" component={Auswahl} />
          <Route path="/ServiceUnit/:department" component={ServiceUnit} />

          <Route
            path="/AppointmentOverview/:serviceUnit"
            component={AppointmentOverview}
          />
          <Route
            path="/AppointmentView/:appointmentOverView"
            component={AppointmentView}
          />
          <Route
            path="/AppointmentConfirm/:appointmentView"
            component={AppointmentConfirm}
          />
          <Route path="/AppointmentCancle" component={AppointmentCancel} />
          <Route
            path="/AppointmentInformation/: appointmentView"
            component={AppointmentInformation}
          />

          <Route path="/TanServiceSMS" component={TanServiceSms} />
          <Route path="/TanServiceEmail" component={TanServiceEmail} />
          <Route path="/TanCheck" component={TanCheck} />
          <Route path="/TanError" component={TanError} />
          <Route path="/TanNotOK" component={TanNotOK} />
          <Route path="/TanOK" component={TanOK} />
        </Switch>
      </Router>
    </div>
  );
};

export default App;
