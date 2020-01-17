import React, { Component } from "react";
import { Table } from "react-bootstrap";

class MotoristasComponent extends Component {
  render() {
    const motoristas = this.props.motoristas;
    if (!motoristas) return <div>Carregando...</div>;
    return (
      <div>
        <h1>Motoristas</h1>
        <Table striped bordered hover size="sm" responsive>
          <thead>
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
            </tr>
          </thead>
          <tbody>
            {motoristas.map((motorista) => (
              <tr key={motorista.id} onClick={() => { alert("Motorista: " + motorista.id); }}>
                <td>{motorista.id}</td>
                <td>{motorista.nome}</td>
                <td>{motorista.cpf}</td>
                <td>{motorista.dataNascimento}</td>
                <td>{motorista.sexo}</td>
                <td>{motorista.categoriaCnh}</td>
                <td>{motorista.numeroCnh}</td>
                <td>{motorista.expedicaoCnh}</td>
                <td>{motorista.validadeCnh}</td>
              </tr>
            ))}
          </tbody>
        </Table>
      </div>
    );
  }
}

export default MotoristasComponent;