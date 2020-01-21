import React from "react";

import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

import { NavLink } from 'react-router-dom';

import logo from '../../images/logo-az-ship-white.svg';

function Header() {
	return (
		<Navbar collapseOnSelect variant="dark" bg="dark" expand="lg" sticky="top">
			<Navbar.Brand as={NavLink} to="/">
				<img
					alt=""
					src={logo}
					width="100"
				/>
			</Navbar.Brand>
			<Navbar.Toggle aria-controls="responsive-navbar-nav" />
			<Nav>
				<NavDropdown title="Motoristas">
					<NavDropdown.Item as={NavLink} to="/motoristas">Listar</NavDropdown.Item>
					<NavDropdown.Item as={NavLink} to="/motoristas/cadastrar">Cadastrar</NavDropdown.Item>
				</NavDropdown>
				<NavDropdown title="Veículos">
					<NavDropdown.Item as={NavLink} to="/veiculos">Listar</NavDropdown.Item>
					<NavDropdown.Item as={NavLink} to="/veiculos/cadastrar">Cadastrar</NavDropdown.Item>
				</NavDropdown>
				<NavDropdown title="Viagens">
					<NavDropdown.Item as={NavLink} to="/viagens">Listar</NavDropdown.Item>
					<NavDropdown.Item as={NavLink} to="/viagens/cadastrar">Cadastrar</NavDropdown.Item>
				</NavDropdown>
				{/* <NavItem>
					<Nav.Link as={NavLink} to="/motoristas">Motoristas</Nav.Link>
				</NavItem>
				<NavItem>
					<Nav.Link as={NavLink} to="/veiculos">Veículos</Nav.Link>
				</NavItem>
				<NavItem>
					<Nav.Link as={NavLink} to="/viagens">Viagens</Nav.Link>
				</NavItem> */}
			</Nav>
		</Navbar>
	);
}

export default Header;