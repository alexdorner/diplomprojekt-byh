import React, { Component } from 'react';

class Contact extends Component {
    render() {
        return (
            <div style={{ display: 'flex', justifyContent: 'center', padding: 30 }}>
                <div>
                    <h2>Kontakt</h2>
                </div>
                <div>
                    <a>Name: BookYourHospital</a>
                    <a>Organisation: HTL Spengergasse</a>
                    <a>Partner: Accenture GmbH</a>
                    <a>Art: Diplomprojekt</a>
                </div>
            </div>
        );
    }
}

export default Contact;