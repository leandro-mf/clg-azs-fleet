import React, { Component } from 'react';

import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Button from 'react-bootstrap/Button';
import Alert from 'react-bootstrap/Alert';

import { Redirect } from 'react-router-dom';

const veiculosEndpoint = "/api/v1/veiculos";
const cavalosEndpoint = "/api/v1/cavalos";
const reboquesEndpoint = "/api/v1/reboques";

class CadastrarVeiculo extends Component {

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
		tipoCavalo: '',
		tipoReboque: ''
	}

	constructor(props) {
		super(props);
		this.state = {
			isLoading: true,
			redirect: false,
			categoriaVeiculo: 0,
			veiculo: this.emptyVeiculo
		}
		this.inputRef = React.createRef();
		this.handleChange = this.handleChange.bind(this);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	componentDidMount() {
		if (this.props.location.state) this.setState(
			{
				veiculo: this.props.location.state.veiculo,
				categoriaVeiculo: this.props.location.state.categoriaVeiculo
			});
		this.setState({ isLoading: false });
	}

	handleChange(event) {
		const target = event.target;
		const value = target.value;
		const name = target.name;
		if (name === "categoriaVeiculo") this.setState({ categoriaVeiculo: value });
		else {
			let veiculo = { ...this.state.veiculo };
			veiculo[name] = value;
			this.setState({ veiculo: veiculo });
		}
	}

	async handleSubmit(event) {
		event.preventDefault();
		const { categoriaVeiculo, veiculo } = this.state;
		let path;
		switch (categoriaVeiculo) {
			case "1":
				path = cavalosEndpoint;
				break;
			case "2":
				path = reboquesEndpoint;
				break;
			default:
				path = veiculosEndpoint;
		}
		await fetch(path + (veiculo.id ? `/${veiculo.id}` : ''), {
			method: (veiculo.id ? 'PUT' : 'POST'),
			headers: {
				'Accept': 'application/json',
				'Content-Type': 'application/json'
			},
			body: JSON.stringify(veiculo)
		}).then(response => {
			const status = response.status;
			if (status === 200 || status === 201) {
				this.setState({ redirect: true });
			} else if (status === 403) {
				alert('Você não possui permissão para realizar esta ação!')	
			} else {
				alert('Erro ao cadastrar veiculo!');
			}
		});
	}

	render() {
		const { isLoading, redirect, veiculo, categoriaVeiculo } = this.state;
		const text = veiculo.id ? "Alterar Veículo" : "Cadastrar Veículo";
		const title = <h3 style={{ fontWeight: "bold" }}>{text}</h3>;

		if (isLoading) return (<div><Alert variant="primary">Carregando...</Alert></div>);
		if (redirect) return <Redirect to="/veiculos" />

		return (
			<div>
				<Container>
					{title}<br />
					<Form onSubmit={this.handleSubmit}>
						<Form.Group as={Row} controlId="placa">
							<Form.Label column sm={2}>Placa</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="placa" value={veiculo.placa} ref={this.inputRef} placeholder="Placa do veículo" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="cidade">
							<Form.Label column sm={2}>Cidade</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="cidade" value={veiculo.cidade} placeholder="Cidade" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="Estado">
							<Form.Label column sm={2}>Estado</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="estado" value={veiculo.estado} placeholder="UF" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="renavam">
							<Form.Label column sm={2}>Renavam</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="renavam" value={veiculo.renavam} placeholder="Renavam" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="chassi">
							<Form.Label column sm={2}>Chassi</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="chassi" value={veiculo.chassi} placeholder="Chassi" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="fabricante">
							<Form.Label column sm={2}>Fabricante</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="fabricante" value={veiculo.fabricante} placeholder="Fabricante" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="modelo">
							<Form.Label column sm={2}>Modelo</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="text" name="modelo" value={veiculo.modelo} placeholder="Modelo" required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="anoFabricacao">
							<Form.Label column sm={2}>Ano de Fabricação</Form.Label>
							<Col sm={10}>
								<Form.Control as="input" type="date" name="anoFabricacao" value={veiculo.anoFabricacao} required onChange={this.handleChange} />
							</Col>
						</Form.Group>
						<Form.Group as={Row} controlId="categoriaVeiculo">
							<Form.Label column sm={2}>Categoria</Form.Label>
							<Col sm={1}>
								<Form.Check type="radio" label="Truck/Bitruck" name="categoriaVeiculo" value="0" checked={categoriaVeiculo === "0"} disabled={veiculo.id} onChange={this.handleChange} />
								<Form.Check type="radio" label="Cavalo" name="categoriaVeiculo" value="1" checked={categoriaVeiculo === "1"} disabled={veiculo.id} onChange={this.handleChange} />
								<Form.Check type="radio" label="Reboque" name="categoriaVeiculo" value="2" checked={categoriaVeiculo === "2"} disabled={veiculo.id} onChange={this.handleChange} />
							</Col>
						</Form.Group>
						{
							categoriaVeiculo === "1" ?
								<Form.Group as={Row} controlId="tipoCavalo">
									<Form.Label column sm={2}>Tipo de Cavalo</Form.Label>
									<Col sm={10}>
										<Form.Control as="select" name="tipoCavalo" value={veiculo.tipoCavalo} required disabled={veiculo.id} onChange={this.handleChange}>
											<option></option>
											<option>TRUCADO</option>
											<option>SIMPLES</option>
										</Form.Control>
									</Col>
								</Form.Group>
								: <></>
						}
						{
							categoriaVeiculo === "2" ?
								<Form.Group as={Row} controlId="tipoReboque">
									<Form.Label column sm={2}>Tipo de Reboque</Form.Label>
									<Col sm={10}>
										<Form.Control as="select" name="tipoReboque" value={veiculo.tipoReboque} required disabled={veiculo.id} onChange={this.handleChange}>
											<option></option>
											<option>BAU</option>
											<option>SIDER</option>
											<option>GRADE_BAIXA</option>
											<option>BAU_FRIGORIFICO</option>
											<option>TANQUE</option>
										</Form.Control>
									</Col>
								</Form.Group>
								: <></>
						}
						<Form.Group as={Row}>
							<Col sm={{ offset: 8 }}>
								<div align="right">
									<Button variant="primary" type="submit">Salvar</Button>{' '}
									<Button variant="secondary" type="reset" onClick={() => this.setState({ veiculo: this.emptyVeiculo, redirect: true })}>Cancelar</Button>
								</div>
							</Col>
						</Form.Group>
					</Form>
				</Container>
			</div>
		);
	}

}

export default CadastrarVeiculo;