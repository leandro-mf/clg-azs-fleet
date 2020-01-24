import React, { Component } from 'react';

import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Alert from 'react-bootstrap/Alert';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import Moment from 'react-moment';

import { Redirect } from 'react-router-dom';

const endpoint = "/api/v1/motoristas";

class Motorista extends Component {

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
			change: false,
			motoristas: [],
			filteredMotoristas: [],
			motorista: this.emptyMotorista
		}
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.search = this.search.bind(this);
	}

	async componentDidMount() {
		const response = await fetch(endpoint);
		const body = await response.json();
		this.setState({ isLoading: false, motoristas: body, filteredMotoristas: body });
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
		const response = await fetch(endpoint + (motorista.id ? `/${motorista.id}` : ''), {
			method: (motorista.id ? 'PUT' : 'POST'),
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(motorista)
		});
		const body = await response.json();
		let updatedMotoristas = this.state.motoristas.map(v => {
			return (v.id === body.id) ? body : v;
		});
		if (!motorista.id) updatedMotoristas.push(body);
		this.setState({ motoristas: updatedMotoristas, motorista: this.emptyMotorista });
	}

	async delete(id) {
		await fetch(`${endpoint}/${id}`, {
			method: 'DELETE',
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			}
		}).then((response) => {
			if (response.status === 204) {
				let updatedMotoristas = [...this.state.motoristas].filter(i => i.id !== id);
				let updatedFilteredMotoristas = [...this.state.filteredMotoristas].filter(i => i.id !== id);
				this.setState({ motoristas: updatedMotoristas, filteredMotoristas: updatedFilteredMotoristas });
			} else if (response.status === 403) {
				alert('Você não possui permissão para realizar esta ação!')	
			} else if (response.status === 500) {
				alert('Erro ao excluir motorista!');
			}
		});
	}

	search(event) {
		const target = event.target;
		const value = target.value.toLowerCase();
		if (value) {
			let filteredMotoristas = this.state.motoristas.filter(m => {
				return m.cpf.toLowerCase().includes(value) ||
					m.nome.toLowerCase().includes(value);
			});
			this.setState({ filteredMotoristas: filteredMotoristas });
		} else {
			this.setState({ filteredMotoristas: this.state.motoristas });
		}
	}

	change(motorista) {
		this.setState({ change: true, motorista: motorista });
	}

	render() {
		const { isLoading, change, motorista, filteredMotoristas } = this.state;
		const title = <h3 style={{ fontWeight: "bold" }}>Motoristas</h3>

		if (isLoading) return (<div><Alert variant="primary">Carregando...</Alert></div>);
		if (change) return (<Redirect to={{ pathname: "/motoristas/cadastrar", state: motorista }} />);

		let rows = filteredMotoristas.sort((m1, m2) => m1.id - m2.id).map((motorista) => (
			<tr key={motorista.id}>
				<td>{motorista.id}</td>
				<td>{motorista.nome}</td>
				<td>{motorista.cpf}</td>
				<td><Moment date={motorista.dataNascimento} format="DD/MM/YYYY" /></td>
				<td>{motorista.sexo}</td>
				<td>{motorista.categoriaCnh}</td>
				<td>{motorista.numeroCnh}</td>
				<td><Moment date={motorista.expedicaoCnh} format="DD/MM/YYYY" /></td>
				<td><Moment date={motorista.validadeCnh} format="DD/MM/YYYY" /></td>
				<td><Button variant="warning" onClick={() => this.change(motorista)}>Alterar</Button></td>
				<td><Button variant="danger" onClick={() => this.delete(motorista.id)}>Excluir</Button></td>
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
						<Col sm={2}>
							<input type="text" name="search" placeholder="CPF ou nome" onChange={this.search} />
						</Col>
						<Col sm={{ offset: 8, sm: 2 }}>
							<div align="right">
								<Button variant="primary" onClick={() => this.setState({ motorista: this.emptyMotorista, change: true })}>Cadastrar</Button>
							</div>
						</Col>
					</Row>
					<br />
					<Table hover size="sm" responsive>
						<thead align="center">
							<tr>
								<th>#</th>
								<th>Nome</th>
								<th>CPF</th>
								<th>Nascimento</th>
								<th>Sexo</th>
								<th>Categoria CNH</th>
								<th>Número CNH</th>
								<th>Expedição CNH</th>
								<th>Validade CNH</th>
								<th colSpan="2"></th>
							</tr>
						</thead>
						<tbody align="center">
							{rows}
						</tbody>
					</Table>
				</Container>
			</div >
		);
	}

}

export default Motorista;