import React, { Component } from 'react';
import "./TanService.css"

class TanServiceSMS extends Component {

    constructor(props) {
        super(props);
        this.state = {sms: ''};

        this.changeSMS = this.changeSMS.bind(this);
        this.sendSMS = this.sendSMS.bind(this);
    }

    changeSMS(event) {
        this.setState({sms: event.target.value});
    }

    sendSMS(event) {
        event.preventDefault();
        console.log('clicked sendSMS: ' + this.state.sms);

        //Change URL localhost to Server URL
        fetch("http://localhost:3000/api/sendSms?to=" + this.state.sms)
        .then(response => response.json())
        .then((jsonData) => {
            console.log(jsonData);

            if(jsonData.returnCode == "ok") {
                this.props.history.push('/TanCheck');
                this.props.history.go();
            } else {
                this.props.history.push('/TanError');
                this.props.history.go();
            }
        })
        .catch((error) => {
            console.error(error);
            this.props.history.push('/TanError');
            this.props.history.go();
        })
    }

    render() {
        return (
            <center>
                <div className="TanServiceSMS" style={{ padding: 30 }}>
                    <div style={{ width: '400px' }}>
                        <div><h2>Tan per SMS</h2></div>
                        <div>
                            <form onSubmit={this.sendSMS} method='POST'>
                                <input value={this.state.sms} onChange={this.changeSMS} type="tel" id="to" name="to" className="form-control" placeholder="Telefonnummer (+431234567)" required autoFocus></input>
                                <br></br>
                                <button type="submit">Senden</button>
                            </form>
                        </div>
                    </div>
                </div>
            </center>
        );
    }
}

export default TanServiceSMS;