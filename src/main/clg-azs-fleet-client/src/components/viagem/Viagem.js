import React, { Component } from 'react';

import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Alert from 'react-bootstrap/Alert';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import Moment from 'react-moment';

import { Redirect } from 'react-router-dom';

const motoristasEndpoint = '/api/v1/motoristas';
const veiculosEndpoint = '/api/v1/veiculos';
const viagensEndpoint = '/api/v1/viagens';

class Viagem extends Component {

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
			change: false,
			redirect: false,
			motoristas: [],
			veiculos: [],
			viagens: [],
			filteredViagens: [],
			viagem: this.emptyViagem
		}
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.search = this.search.bind(this);
	}

	async componentDidMount() {
		const motoristasResponse = await fetch(motoristasEndpoint);
		const veiculosResponse = await fetch(veiculosEndpoint);
		const viagensResponse = await fetch(viagensEndpoint);
		const motoristasBody = await motoristasResponse.json();
		const veiculosBody = await veiculosResponse.json();
		const viagensBody = await viagensResponse.json();
		this.setState({ isLoading: false, motoristas: motoristasBody, veiculos: veiculosBody, viagens: viagensBody, filteredViagens: viagensBody });
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
		const response = await fetch(viagensEndpoint + (viagem.id ? `/${viagem.id}` : ''), {
			method: (viagem.id ? 'PUT' : 'POST'),
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(viagem)
		});
		const body = await response.json();
		let updatedViagens = this.state.viagens.map(v => {
			return (v.id === body.id) ? body : v;
		});
		if (!viagem.id) updatedViagens.push(body);
		this.setState({ viagens: updatedViagens, viagem: this.emptyViagem });
	}

	async delete(id) {
		await fetch(`${viagensEndpoint}/${id}`, {
			method: 'DELETE',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			}
		}).then((response) => {
			if (response.status === 204) {
				let updatedViagens = [...this.state.viagens].filter(i => i.id !== id);
				let updatedFilteredViagens = [...this.state.filteredViagens].filter(i => i.id !== id);
				this.setState({ viagens: updatedViagens, filteredViagens: updatedFilteredViagens });
			} else if (response.status === 500) {
				alert('Erro ao excluir viagem!');
			}
		});
	}

	async updateStatusViagem(viagem, status) {
		viagem.statusViagem = status;
		await fetch(`${viagensEndpoint}/${viagem.id}`, {
			method: 'PUT',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(viagem)
		}).then(response => {
			if (response.status === 200) {
				const body = response.json();
				let updatedViagens = this.state.viagens.map(v => {
					return (v.id === body.id) ? body : v;
				});
				this.setState({ viagens: updatedViagens, viagem: this.emptyViagem });
			} else if (response.status === 500) {
				alert('Erro ao iniciar viagem!');
			}
		});
	}

	search(event) {
		const target = event.target;
		const value = target.value.toLowerCase();
		if (value) {
			let filteredViagens = this.state.viagens.filter(v => {
				return (
					// v.id === value ||
					v.veiculo.placa.toLowerCase().includes(value) ||
					v.motorista.nome.toLowerCase().includes(value) ||
					v.dataInicio.toString().split("-").reverse().join("/").includes(value) ||
					v.dataFim.toString().split("-").reverse().join("/").includes(value)
					// v.produtoTransportado.toLowerCase().includes(value) ||
					// v.valorFrete.toString().includes(value) ||
					// v.statusViagem.toLowerCase().includes(value)
				);
			});
			this.setState({ filteredViagens: filteredViagens });
		} else {
			this.setState({ filteredViagens: this.state.viagens });
		}
	}

	change(viagem) {
		this.setState({ change: true, viagem: viagem });
	}

	render() {
		const { isLoading, change, viagem, filteredViagens } = this.state;
		const title = <h3 style={{ fontWeight: "bold" }}>Viagens</h3>

		if (isLoading) return (<div><Alert variant="primary">Carregando...</Alert></div>);
		if (change) return (<Redirect to={{ pathname: "/viagens/cadastrar", state: viagem }} />);

		let rows = filteredViagens.sort((v1, v2) => v1.id - v2.id).map((viagem) => (
			<tr key={viagem.id}>
				<td>{viagem.id}</td>
				<td>{viagem.veiculo.placa}</td>
				<td>{viagem.motorista.nome}</td>
				<td><Moment date={viagem.dataInicio} format="DD/MM/YYYY" /></td>
				<td><Moment date={viagem.dataFim} format="DD/MM/YYYY" /></td>
				<td>{viagem.produtoTransportado}</td>
				<td>{viagem.valorFrete}</td>
				<td>{viagem.statusViagem}</td>
				<td>
					{
						viagem.statusViagem === 'CRIADA' ?
							<Button variant="success" onClick={() => this.updateStatusViagem(viagem, 'INICIADA')}>Iniciar</Button>
							: <Button variant="success" disabled={viagem.statusViagem === 'FINALIZADA'} onClick={() => this.updateStatusViagem(viagem, 'FINALIZADA')}>Finalizar</Button>
					}
				</td>
				<td><Button variant="warning" disabled={viagem.statusViagem === 'FINALIZADA'} onClick={() => this.change(viagem)}>Alterar</Button></td>
				<td><Button variant="danger" onClick={() => this.delete(viagem.id)}>Excluir</Button></td>
			</tr>
		));

		return (
			<div>
				<Container>
					<Row>
						<Col>{title}</Col>
					</Row>
					<Row>
						<Col sm={1}>
							Filtrar
						</Col>
					</Row>
					<Row>
						<Col>
							<input type="text" name="search" placeholder="Data, veículo ou motorista" onChange={this.search} />
						</Col>
						<Col sm={{ offset: 8 }}>
							<div align="right">
								<Button variant="primary" onClick={() => this.setState({ viagem: this.emptyViagem, change: true })}>Cadastrar</Button>
							</div>
						</Col>
					</Row>
					<br />
					<Table hover size="sm" responsive>
						<thead align="center">
							<tr>
								<th>#</th>
								<th>Veiculo</th>
								<th>Motorista</th>
								<th>Data de Início</th>
								<th>Data de Término</th>
								<th>Produto Transportado</th>
								<th>Valor do Frete</th>
								<th>Status</th>
								<th colSpan="3"></th>
							</tr>
						</thead>
						<tbody align="center">
							{rows}
						</tbody>
					</Table>
				</Container>
			</div>
		);
	}
}

export default Viagem;