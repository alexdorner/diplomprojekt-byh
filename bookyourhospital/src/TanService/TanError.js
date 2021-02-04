import React, { Component } from 'react';

class TanError extends Component {
    render() {
        return (
            <center>
                <div style={{ padding: 30 }}>
                    <div><h4>Leider gab es ein Problem beim Versenden</h4></div>
                    <div><a href="./TanServiceEmail">Tan per Email senden</a></div>
                    <div><a href="./TanServiceSMS">Tan per SMS senden</a></div>
                </div>
            </center>
        );
    }
}

export default TanError;