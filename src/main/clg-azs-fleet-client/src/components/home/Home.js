import React, { Component } from 'react';

import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Alert from 'react-bootstrap/Alert';

import { Redirect } from 'react-router-dom';

class Home extends Component {

	constructor(props) {
		super(props);
		this.state = {
			isLoading: true,
			redirect: false,
			pathName: ""
		}
	}

	componentDidMount() {
		this.setState({ isLoading: false });
	}

	render() {
		const { isLoading, redirect, pathName } = this.state;

		if (isLoading) return (<div><Alert variant="primary">Carregando...</Alert></div>);
		if (redirect) return (<Redirect to={{ pathname: pathName }} />);

		return (
			<div>
				<Container>
					<Row>
						<Col>
							<div align="center">
								<Button variant="primary" onClick={() => this.setState({ redirect: true, pathName: "/motoristas/cadastrar" })}>Cadastrar Motorista</Button>
							</div>
						</Col>
					</Row>
					<br />
					<Row>
						<Col>
							<div align="center">
								<Button variant="primary" onClick={() => this.setState({ redirect: true, pathName: "/veiculos/cadastrar" })}>Cadastrar Veículo</Button>
							</div>
						</Col>
					</Row>
					<br />
					<Row>
						<Col>
							<div align="center">
								<Button variant="primary" onClick={() => this.setState({ redirect: true, pathName: "/viagens/cadastrar"})}>Cadastrar Viagem</Button>
							</div>
						</Col>
					</Row>
				</Container>
			</div>
		);
	}
}

export default Home;