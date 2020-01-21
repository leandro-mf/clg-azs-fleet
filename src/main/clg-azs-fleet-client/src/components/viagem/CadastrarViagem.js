import React, { Component } from 'react';

import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Alert from 'react-bootstrap/Alert';

import { Redirect } from 'react-router-dom';

const endpoint = '/api/v1/viagens';
const motoristasEndpoint = '/api/v1/motoristas';
const veiculosEndpoint = '/api/v1/veiculos';

class CadastrarViagem extends Component {

	emptyViagem = {
		id: '',
		veiculo: {
			id: ''
		},
		motorista: {
			id: ''
		},
		dataInicio: '',
		dataFim: '',
		produtoTransportado: '',
		valorFrete: '',
	}

	constructor(props) {
		super(props);
		this.state = {
			isLoading: true,
			redirect: false,
			viagem: this.emptyViagem,
			veiculos: [],
			viagens: []
		}
		this.inputRef = React.createRef();
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	async componentDidMount() {
		if (this.props.location.state) this.setState({ viagem: this.props.location.state });
		const motoristasResponse = await fetch(motoristasEndpoint);
		const veiculosResponse = await fetch(veiculosEndpoint);
		const motoristasBody = await motoristasResponse.json();
		const veiculosBody = await veiculosResponse.json();
		this.setState({ isLoading: false, motoristas: motoristasBody, veiculos: veiculosBody });
	}

	handleChange(event) {
		const target = event.target;
		const value = target.value;
		const name = target.name;
		let viagem = { ...this.state.viagem };
		if (name === 'veiculo') viagem[name] = this.state.veiculos[this.state.veiculos.findIndex(v => v.id == value)];
		else if (name === 'motorista') viagem[name] = this.state.motoristas[this.state.motoristas.findIndex(m => m.id == value)];
		else viagem[name] = value;
		this.setState({ viagem: viagem });
	}

	async handleSubmit(event) {
		event.preventDefault();
		const viagem = this.state.viagem;
		await fetch(endpoint + (viagem.id ? `/${viagem.id}` : ''), {
			method: (viagem.id ? 'PUT' : 'POST'),
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(viagem)
		}).then(response => {
			const status = response.status;
			if (status === 200 || status === 201) {
				this.setState({ redirect: true });
			}
		});
	}

	render() {
		const { isLoading, redirect, motoristas, veiculos, viagem } = this.state;
		const text = viagem.id ? "Alterar Viagem": "Cadastrar Viagem";
		const title = <h3 style={{ fontWeight: "bold" }}>{text}</h3>;

		if (isLoading) return (<div><Alert variant="primary">Carregando...</Alert></div>);
		if (redirect) return <Redirect to="/viagens" />

		return (
			<div>
				<Container>
					{title}<br />
					<Form onSubmit={this.handleSubmit}>
						<Form.Group as={Row} controlId="veiculo">
							<Form.Label column sm={3}>Veículo</Form.Label>
							<Col sm={9}>
								<Form.Control as="select" name="veiculo" value={viagem.veiculo ? viagem.veiculo.id : ""} ref={this.inputRef} required autoFocus onChange={this.handleChange}>
									<option></option>
									{
										veiculos.map((veiculo) => (
											<option key={veiculo.id} value={veiculo.id}>{veiculo.placa}</option>
										))
									}
								</Form.Control>
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="motorista">
							<Form.Label column sm={3}>Motorista</Form.Label>
							<Col sm={9}>
								<Form.Control as="select" name="motorista" value={viagem.motorista ? viagem.motorista.id : ""} required onChange={this.handleChange}>
									<option></option>
									{
										motoristas.map((motorista) => (
											<option key={motorista.id} value={motorista.id}>{`${motorista.nome} (${motorista.cpf})`}</option>
										))
									}
								</Form.Control>
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="dataInicio">
							<Form.Label column sm={3}>Data de Início</Form.Label>
							<Col sm={9}>
								<Form.Control as="input" type="date" name="dataInicio" value={viagem.dataInicio} required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="dataFim">
							<Form.Label column sm={3}>Data de Término</Form.Label>
							<Col sm={9}>
								<Form.Control as="input" type="date" name="dataFim" value={viagem.dataFim} required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="produtoTransportado">
							<Form.Label column sm={3}>Produto Transportado</Form.Label>
							<Col sm={9}>
								<Form.Control as="input" type="text" name="produtoTransportado" value={viagem.produtoTransportado} placeholder="Produto Transportado" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="valorFrete">
							<Form.Label column sm={3}>Valor do Frete</Form.Label>
							<Col sm={9}>
								<Form.Control as="input" type="number" name="valorFrete" value={viagem.valorFrete} placeholder="R$" min="0.00" step="0.01" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row}>
							<Col sm={{ offset: 8 }}>
								<div align="right">
									<Button variant="primary" type="submit">Salvar</Button>{' '}
									<Button variant="secondary" type="reset" onClick={() => this.setState({ viagem: this.emptyViagem, redirect: true})}>Cancelar</Button>
								</div>
							</Col>
						</Form.Group>
					</Form>
				</Container>
			</div>
		);
	}
}
		
export default CadastrarViagem;