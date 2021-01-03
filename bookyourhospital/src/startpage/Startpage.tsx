import React from 'react';
import '/.startpage.css';
import logo from "../byh_logo.svg";

function Startpage(){
    return (
        <div className="Startpage">
            <header className="Startpage-header">
                <img src={logo} className="App-logo" alt="logo" />
            </header>
        </div>
    );
}