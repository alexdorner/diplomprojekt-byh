import React, { Component } from 'react';
import "./TanService.css"

class TanServiceEmail extends Component {

    constructor(props) {
        super(props);
        this.state = {email: ''};

        this.changeEmail = this.changeEmail.bind(this);
        this.sendEmail = this.sendEmail.bind(this);
    }

    changeEmail(event) {
        this.setState({email: event.target.value});
    }

    sendEmail(event) {
        event.preventDefault();
        console.log('clicked sendEmail: ' + this.state.email);

        //TODO: Change URL localhost to Server URL
        fetch("http://localhost:3000/api/sendMail?to=" + this.state.email)
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
                <div className="TanServiceEmail" style={{ padding: 30 }}>
                    <div style={{ width: '400px' }}>
                        <div><h2>Tan per E-Mail</h2></div>
                        <div>
                            <form onSubmit={this.sendEmail} method='POST'>
                                <input value={this.state.email} onChange={this.changeEmail} type="email" id="to" name="to" className="form-control" placeholder="E-Mail Adresse" required autoFocus></input>
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

export default TanServiceEmail;