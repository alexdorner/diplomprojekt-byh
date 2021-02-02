import React, { Component } from 'react';

class TanNotOK extends Component {
    render() {
        return (
            <center>
                <div style={{ padding: 30 }}>
                    <div><h4>Der Tan stimmt mit dem gesendeten Tan nicht überein</h4></div>
                    <div><a href="./TanCheck">Tan nochmal eingeben</a></div>
                </div>
            </center>
        );
    }
}

export default TanNotOK;