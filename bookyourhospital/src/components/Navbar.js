import React from "react";
import { Nav, Navbar } from "react-bootstrap";
import FontSizeChanger from "react-font-size-changer";
import { LinkContainer } from "react-router-bootstrap";
import "./Navbar.css";

const Navigation = (props) => {
  console.log(props);
  return (
    <Navbar variant="dark" sticky="top">
      <Navbar.Brand href="/">BookYourHospital</Navbar.Brand>
      <Navbar.Toggle aria-controls="basic-navbar-nav" />
      <Navbar.Collapse id="basic-navbar-nav">
        <Nav className="mr-auto">
          <LinkContainer to="/">
            <Nav.Link>Home</Nav.Link>
          </LinkContainer>
          <LinkContainer to="/About">
            <Nav.Link>About</Nav.Link>
          </LinkContainer>
          <FontSizeChanger
            targets={["#target .content"]}
            onChange={(element, newValue, oldValue) => {
              console.log(element, newValue, oldValue);
            }}
            options={{
              stepSize: 2,
              range: 3,
            }}
            customButtons={{
              down: <span style={{ fontSize: "20px" }}>A</span>,
              up: <span style={{ fontSize: "36px" }}>A</span>,
              style: {
                backgroundColor: "#7BA79D",
                color: "white",
                WebkitBoxSizing: "border-box",
                WebkitBorderRadius: "5px",
                width: "60px",
              },
              buttonsMargin: 10,
            }}
          />
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
};

export default Navigation;
