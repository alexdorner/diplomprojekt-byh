import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import "./Transfer.css";


class WhatTransfer extends Component {

    render() {
        return (
            <center>
                <h2>Was ist eine Überweisung?</h2>
            </center>
        );
    }

}
export default withRouter(WhatTransfer);