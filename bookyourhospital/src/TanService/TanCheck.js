import React, { Component } from 'react';

class TanCheck extends Component {

    constructor(props) {
        super(props);
        this.state = {tan: ''};

        this.changeTan = this.changeTan.bind(this);
        this.sendTan = this.sendTan.bind(this);
    }

    changeTan(event) {
        this.setState({tan: event.target.value});
    }

    sendTan(event) {
        event.preventDefault();
        console.log('clicked sendTan: ' + this.state.tan);

        //TODO: Change URL localhost to Server URL
        fetch("http://localhost:3000/api/getTan")
        .then(response => response.json())
        .then((jsonData) => {
            //console.log(jsonData);

            if(jsonData.tan == this.state.tan) {
                //TODO: Redirect to Url for Tan OK
                //this.props.history.push('/');
                //this.props.history.go();
            } else {
                //console.log("nok");
                this.props.history.push('/TanNotOK');
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
                <div className="TanCheck" style={{ padding: 30 }}>
                    <div style={{ width: '400px' }}>
                        <div><h2>Tan Prüfung</h2></div>
                        <div>
                            <form onSubmit={this.sendTan} method='POST'>
                                <input value={this.state.tan} onChange={this.changeTan} type="number" id="tan" name="tan" className="form-control" placeholder="Tan" required autoFocus min="10000" max="99999"></input>
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

export default TanCheck;