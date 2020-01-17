import React, { Component } from "react";
import { Table } from "react-bootstrap";

class VeiculosComponent extends Component {
	render() {
		const veiculos = this.props.veiculos;
		if (!veiculos) return <div>Carregando...</div>;
		return (
			<div>
				<h1>Veículos</h1>
				<Table striped bordered hover size="sm" responsive>
					<thead>
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
						</tr>
					</thead>
					<tbody>
						{veiculos.map((veiculo) => (
							<tr key={veiculo.id} onClick={() => { alert("Veiculo: " + veiculo.id); }}>
								<td>{veiculo.id}</td>
								<td>{veiculo.placa}</td>
								<td>{veiculo.cidade}</td>
								<td>{veiculo.estado}</td>
								<td>{veiculo.renavam}</td>
								<td>{veiculo.chassi}</td>
								<td>{veiculo.fabricante}</td>
								<td>{veiculo.modelo}</td>
								<td>{veiculo.anoFabricacao}</td>
								<td>{veiculo.tipoVeiculo}</td>
							</tr>
						))}
					</tbody>
				</Table>
			</div>
		);
	}
}

export default VeiculosComponent;