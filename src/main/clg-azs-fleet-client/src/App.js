import React, { Component } from 'react';
import './App.css';
import "bootswatch/dist/darkly/bootstrap.css";
import { Nav, Navbar, Row, Col, Container } from "react-bootstrap";
import MotoristasComponent from './components/MotoristasComponent';
import VeiculosComponent from './components/VeiculosComponent';
import ViagensComponent from './components/ViagensComponent';

const motoristasURL = "http://localhost:8080/api/v1/motoristas/";
const veiculosURL = "http://localhost:8080/api/v1/veiculos/";
const viagensURL = "http://localhost:8080/api/v1/viagens/";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      motoristas: null,
      veiculos: null,
      viagens: null,
      selectedMotorista: 0
    };
  }
  componentDidMount() {
    fetch(motoristasURL).then(res => res.json()).then(json => {
      this.setState({ motoristas: json });
    });
    fetch(veiculosURL).then(res => res.json()).then(json => {
      this.setState({ veiculos: json });
    });
    fetch(viagensURL).then(res => res.json()).then(json => {
      this.setState({ viagens: json });
    });
  }
  render() {
    const motoristas = this.state.motoristas;
    const veiculos = this.state.veiculos;
    const viagens = this.state.viagens;
    const selectedMotorista = this.state.selectedMotorista;
    return (
      <div>
        <Navbar bg="light" expand="lg" sticky="top">
          <Navbar.Brand href="/">az</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Link href="#/motoristas">Motoristas</Nav.Link>
              <Nav.Link href="#/veiculos">Veiculos</Nav.Link>
              <Nav.Link href="#/viagens">Viagens</Nav.Link>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
        <Container>
          <Row>
            <Col md={12} sm={12}>
              <br />
              <MotoristasComponent motoristas={motoristas} />
              <br />
              <VeiculosComponent veiculos={veiculos} />
              <br />
              <ViagensComponent viagens={viagens} />
            </Col>
          </Row>
        </Container>
      </div>
    );
  }
}

export default App;