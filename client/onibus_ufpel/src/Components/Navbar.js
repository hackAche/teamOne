import React from "react";
import * as ReactBootStrap from "react-bootstrap";

function Navbar () {
  return (
    <ReactBootStrap.Navbar fixed="top" bg="light" variant="light" className="navbar">
        <ReactBootStrap.Container>
          <ReactBootStrap.Navbar.Brand href="/">
            UFPel
          </ReactBootStrap.Navbar.Brand>
          <ReactBootStrap.Nav className="me-auto">
            <ReactBootStrap.Nav.Link className="navlink" href="/">Home</ReactBootStrap.Nav.Link>
            <ReactBootStrap.Nav.Link className="navlink" href="/institucional">Institucional</ReactBootStrap.Nav.Link>
            <ReactBootStrap.Nav.Link className="navlink" href="/suporte">Suporte</ReactBootStrap.Nav.Link>
          </ReactBootStrap.Nav>
        </ReactBootStrap.Container>
      </ReactBootStrap.Navbar>
  )
}

export default Navbar;

  