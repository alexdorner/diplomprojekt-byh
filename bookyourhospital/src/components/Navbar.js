import React, { useState } from 'react';
import './Navbar.css';
import { Navbar, Nav, Form, Button, Dropdown  } from 'react-bootstrap';
import { withRouter } from 'react-router-dom';
import FontSizeChanger from 'react-font-size-changer';
import { ThemeProvider } from 'styled-components';
import { lightTheme, darkTheme } from './theme.';
import { GlobalStyles } from './global';
import { useDarkMode } from './useDarkMode';
import Toggle from './Toogle';

const Navigation = (props) => {
    console.log(props);
    const [theme, toggleTheme, componentMounted] = useDarkMode();

    const themeMode = theme === 'light' ? lightTheme : darkTheme;

    if (!componentMounted) {
        return <div />
    };
    return (
        <>
            <Navbar  variant="dark" sticky="top">
                <Navbar.Brand href="/">BookYourHospital</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link className="textContent" href="/">Home</Nav.Link>
                    </Nav>
                    <Nav>
                        <FontSizeChanger
                            targets={['div']}
                            onChange={(element, newValue, oldValue) => {
                                console.log(element, newValue, oldValue);
                            }}
                            options={{
                                stepSize: 2,
                                range: 3
                            }}
                            customButtons={{
                                down: <span style={{'fontSize': '20px'}}>A</span>,
                                up: <span style={{'fontSize': '36px'}}>A</span>,
                                style: {
                                    backgroundColor: '#7BA79D',
                                    color: 'white',
                                    WebkitBoxSizing: 'border-box',
                                    WebkitBorderRadius: '5px',
                                    width: '60px'
                                },
                                buttonsMargin: 10
                            }}
                        />
                    </Nav>
                    <br/>
                    <Nav>
                        <Dropdown>
                            <Dropdown.Toggle variant="info" id="dropdown-basic">
                                Barrierefreiheit
                            </Dropdown.Toggle>
                            <Dropdown.Menu>
                                <Dropdown.Item href="#/action-1">Dark Mode</Dropdown.Item>
                                <Dropdown.Item href="#/action-2">Kontrast 1</Dropdown.Item>
                                <Dropdown.Item href="#/action-3">Kontrast 2</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>
                    </Nav>
                    <Nav>
                        <ThemeProvider theme={themeMode}>
                            <>
                                <GlobalStyles />
                                <Toggle theme={theme} toggleTheme={toggleTheme}/>
                            </>
                        </ThemeProvider>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        <br />
            <Navbar  variant="dark" fixed="bottom">
                <Navbar.Brand href="/">BookYourHospital</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto">
                        <Nav.Link className="textContent" href="/">Impressum</Nav.Link>
                        <Nav.Link className="textContent" href="/">Über uns</Nav.Link>
                        <Nav.Link className="textContent" href="/">Kontakt</Nav.Link>
                        <Nav.Link className="textContent" href="/">DSGVO</Nav.Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        </>
    )
}


export default withRouter(Navigation);