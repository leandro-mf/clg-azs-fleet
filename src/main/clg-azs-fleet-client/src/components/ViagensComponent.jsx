import React, { Component } from "react";
import { Table } from "react-bootstrap";

class ViagensComponent extends Component {
	render() {
		const viagens = this.props.viagens;
		if (!viagens) return <div>Carregando...</div>;
		return (
			<div>
				<h1>Viagens</h1>
				<Table striped bordered hover size="sm" responsive>
					<thead>
						<tr>
							<th>#</th>
							<th>Veiculo</th>
							<th>Motorista</th>
							<th>Data de Início</th>
							<th>Data de Término</th>
							<th>Produto Transportado</th>
							<th>Valor do Frete</th>
						</tr>
					</thead>
					<tbody>
						{viagens.map((viagem) => (
							<tr key={viagem.id} onClick={() => { alert("Viagem: " + viagem.id); }}>
								<td>{viagem.id}</td>
								<td>{viagem.veiculo.placa}</td>
								<td>{viagem.motorista.nome}</td>
								<td>{viagem.dataInicio}</td>
								<td>{viagem.dataFim}</td>
								<td>{viagem.produtoTransportado}</td>
								<td>{viagem.valorFrete}</td>
							</tr>
						))}
					</tbody>
				</Table>
			</div>
		);
	}
}

export default ViagensComponent;