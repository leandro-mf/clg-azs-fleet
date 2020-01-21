import React, { Component } from 'react';

import Table from 'react-bootstrap/Table';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/Button';
import Alert from 'react-bootstrap/Alert';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

import Moment from 'react-moment';

import { Redirect } from 'react-router-dom';

const endpoint = "/api/v1/veiculos";

class Veiculo extends Component {

	emptyVeiculo = {
		id: '',
		placa: '',
		cidade: '',
		estado: '',
		renavam: '',
		chassi: '',
		fabricante: '',
		modelo: '',
		anoFabricacao: '',
		tipoVeiculo: ''
	}

	constructor(props) {
		super(props);
		this.state = {
			isLoading: true,
			change: false,
			veiculos: [],
			filteredVeiculos: [],
			veiculo: this.emptyVeiculo
		}
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
		this.search = this.search.bind(this);
	}

	async componentDidMount() {
		const response = await fetch(endpoint);
		const body = await response.json();
		this.setState({ isLoading: false, veiculos: body, filteredVeiculos: body });
	}

	handleChange(event) {
		const target = event.target;
		const value = target.value;
		const name = target.name;
		let veiculo = { ...this.state.veiculo };
		veiculo[name] = value;
		this.setState({ veiculo: veiculo });
	}

	async handleSubmit(event) {
		event.preventDefault();
		const veiculo = this.state.veiculo;
		const response = await fetch(endpoint + (veiculo.id ? `/${veiculo.id}` : ''), {
			method: (veiculo.id ? 'PUT' : 'POST'),
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(veiculo)
		});
		const body = await response.json();
		let updatedVeiculos = this.state.veiculos.map(v => {
			return (v.id === body.id) ? body : v;
		});
		if (!veiculo.id) updatedVeiculos.push(body);
		this.setState({ veiculos: updatedVeiculos, veiculo: this.emptyVeiculo });
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
				let updatedVeiculos = [...this.state.veiculos].filter(i => i.id !== id);
				let updatedFilteredVeiculos = [...this.state.filteredVeiculos].filter(i => i.id !== id);
				this.setState({ veiculos: updatedVeiculos, filteredVeiculos: updatedFilteredVeiculos });
			} else if (response.status === 500) {
				alert('Erro ao excluir veículo!');
			}
		});
	}

	search(event) {
		const target = event.target;
		const value = target.value.toLowerCase();
		if (value) {
			let filteredVeiculos = this.state.veiculos.filter(v => {
				return v.placa.toLowerCase().includes(value);
			});
			this.setState({ filteredVeiculos: filteredVeiculos });
		} else {
			this.setState({ filteredVeiculos: this.state.veiculos });
		}
	}

	change(veiculo) {
		this.setState({ change: true, veiculo: veiculo });
	}

	render() {
		const { isLoading, change, veiculo, filteredVeiculos } = this.state;
		const title = <h3 style={{ fontWeight: "bold" }}>Veículos</h3>

		if (isLoading) return (<div><Alert variant="primary">Carregando...</Alert></div>);
		if (change) return (<Redirect to={{ pathname: "/veiculos/cadastrar", state: veiculo }} />);

		let rows = filteredVeiculos.sort((v1, v2) => v1.id - v2.id).map((veiculo) => (
			<tr key={veiculo.id}>
				<td>{veiculo.id}</td>
				<td>{veiculo.placa}</td>
				<td>{veiculo.cidade}</td>
				<td>{veiculo.estado}</td>
				<td>{veiculo.renavam}</td>
				<td>{veiculo.chassi}</td>
				<td>{veiculo.fabricante}</td>
				<td>{veiculo.modelo}</td>
				<td><Moment date={veiculo.anoFabricacao} format="DD/MM/YYYY" /></td>
				<td>{veiculo.tipoVeiculo}</td>
				<td><Button variant="warning" onClick={() => this.change(veiculo)}>Alterar</Button></td>
				<td><Button variant="danger" onClick={() => this.delete(veiculo.id)}>Excluir</Button></td>
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
							<input type="text" name="search" placeholder="Placa" onChange={this.search} />
						</Col>
						<Col sm={{ offset: 8, sm: 2 }}>
							<div align="right">
								<Button variant="primary" onClick={() => this.setState({ veiculo: this.emptyVeiculo, change: true })}>Cadastrar</Button>
							</div>
						</Col>
					</Row>
					<br />
					<Table hover size="sm" responsive>
						<thead align="center">
							<tr>
								<th>#</th>
								<th>Placa</th>
								<th>Cidade</th>
								<th>Estado</th>
								<th>Renavam</th>
								<th>Chassi</th>
								<th>Fabricante</th>
								<th>Modelo</th>
								<th>Ano Fabricação</th>
								<th>Tipo</th>
								<th colSpan="2"></th>
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

export default Veiculo;