import React, { Component } from 'react';

import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Alert from 'react-bootstrap/Alert';

import { Redirect } from 'react-router-dom';

const endpoint = "/api/v1/motoristas";

class CadastrarMotorista extends Component {

	emptyMotorista = {
		id: '',
		nome: '',
		cpf: '',
		dataNascimento: '',
		sexo: '',
		categoriaCnh: '',
		numeroCnh: '',
		expedicaoCnh: '',
		validadeCnh: ''
	}

	constructor(props) {
		super(props);
		this.state = {
			isLoading: true,
			redirect: false,
			motorista: this.emptyMotorista
		}
		this.inputRef = React.createRef();
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	componentDidMount() {
		this.setState({ isLoading: false });
		if (this.props.location.state) this.setState({ motorista: this.props.location.state });
	}

	handleChange(event) {
		const target = event.target;
		const value = target.value;
		const name = target.name;
		let motorista = { ...this.state.motorista };
		motorista[name] = value;
		this.setState({ motorista: motorista });
	}

	async handleSubmit(event) {
		event.preventDefault();
		const motorista = this.state.motorista;
		await fetch(endpoint + (motorista.id ? `/${motorista.id}` : ''), {
			method: (motorista.id ? 'PUT' : 'POST'),
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(motorista)
		}).then(response => {
			const status = response.status;
			if (status === 200 || status === 201) {
				this.setState({ redirect: true });
			}
		});
	}

	render() {
		const { isLoading, redirect, motorista } = this.state;
		const text = motorista.id ? "Alterar Motorista": "Cadastrar Motorista";
		const title = <h3 style={{ fontWeight: "bold" }}>{text}</h3>;

		if (isLoading) return (<div><Alert variant="primary">Carregando...</Alert></div>);
		if (redirect) return <Redirect to="/motoristas" />

		return (
			<div>
				<Container>
					{title}<br />
					<Form onSubmit={this.handleSubmit}>
						<Form.Group as={Row} controlId="nome">
							<Form.Label column sm={2}>Nome</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="nome" value={motorista.nome} ref={this.inputRef} placeholder="Nome completo" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="cpf">
							<Form.Label column sm={2}>CPF</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="cpf" value={motorista.cpf} placeholder="CPF" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="dataNascimento">
							<Form.Label column sm={2}>Nascimento</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="date" name="dataNascimento" value={motorista.dataNascimento} required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="sexo">
							<Form.Label column sm={2}>Sexo</Form.Label>
							<Col sm={10}>
								<Form.Control as="select" name="sexo" value={motorista.sexo} required onChange={this.handleChange}>
									<option></option>
									<option>MASCULINO</option>
									<option>FEMININO</option>
								</Form.Control>
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="categoriaCnh">
							<Form.Label column sm={2}>Categoria CNH</Form.Label>
							<Col sm={10}>
								<Form.Control as="select" name="categoriaCnh" value={motorista.categoriaCnh} required onChange={this.handleChange}>
									<option></option>
									<option>C</option>
									<option>D</option>
									<option>E</option>
								</Form.Control>
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="numeroCnh">
							<Form.Label column sm={2}>Número CNH</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="numeroCnh" value={motorista.numeroCnh} placeholder="Número da carteira" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="expedicaoCnh">
							<Form.Label column sm={2}>Expedição CNH</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="date" name="expedicaoCnh" value={motorista.expedicaoCnh} required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="validadeCnh">
							<Form.Label column sm={2}>Validade CNH</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="date" name="validadeCnh" value={motorista.validadeCnh} required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row}>
							<Col sm={{ offset: 8 }}>
								<div align="right">
									<Button variant="primary" type="submit">Salvar</Button>{' '}
									<Button variant="secondary" type="reset" onClick={() => this.setState({ motorista: this.emptyMotorista, redirect: true })}>Cancelar</Button>
								</div>
							</Col>
						</Form.Group>
					</Form>
				</Container>
			</div>
		);
	}

}

export default CadastrarMotorista;