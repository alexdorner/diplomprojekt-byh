/*import React, { Component } from 'react';
import {Col, Container} from "react-bootstrap";
import { withRouter } from 'react-router-dom';


class AppointmentCancel extends Component {

    appointmentView = this.props.match.params.appointmentView

    async componentDidMount(){
        try {
            let result = await fetch("http://localhost:8080/api", {
                method: 'post',
                mode: "cors",
                headers: {
                    'Accept': 'application/json',
                    'Content-type': 'application/json',
                },
                body: JSON.stringify({
                    appointmentView: this.appointmentView
                })
            })
        }
        catch (e){
            console.log(e);
        }

    }

    render() {
        return (
            <center>
                <h1>Termin stornieren </h1>
                <div>
                    <form onSubmit={} method='DELETE'>
                        <input value={} onChange={} type="email" id="to" name="to" className="form-control" placeholder="Termincode" required autoFocus></input>
                        <br></br>
                        <button type="submit">Weiter</button>
                    </form>
                </div>

            </center>
        );
    }
}*/
//export default withRouter(AppointmentCancel);