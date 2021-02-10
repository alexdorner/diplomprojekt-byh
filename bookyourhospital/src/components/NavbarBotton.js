import React from 'react';
import './Navbar.css';
import { Navbar, Nav } from 'react-bootstrap';
import { withRouter } from 'react-router-dom';

const Navigation = (props) => {
    console.log(props);
    return (
        <Navbar  variant="dark" fixed="bottom">
            <Navbar.Brand href="/">BookYourHospital</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto">
                    <Nav.Link href="/Contact">Impressum</Nav.Link>
                    <Nav.Link href="/Contact">Kontakt</Nav.Link>
                </Nav>
            </Navbar.Collapse>
        </Navbar>
    )
}


export default withRouter(Navigation);