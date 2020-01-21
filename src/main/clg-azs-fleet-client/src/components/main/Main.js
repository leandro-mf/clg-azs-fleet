import React from "react";

import { Route, Switch } from 'react-router-dom';

import { Container } from 'react-bootstrap';

import Home from '../home/Home';
import Motorista from '../motorista/Motorista';
import CadastrarMotorista from '../motorista/CadastrarMotorista';
import Veiculo from '../veiculo/Veiculo';
import CadastrarVeiculo from '../veiculo/CadastrarVeiculo';
import Viagem from '../viagem/Viagem';
import CadastrarViagem from '../viagem/CadastrarViagem';

function Main() {
	return (
		<main>
			<Container>
				<Switch>
					<Route path='/' exact={true} component={Home} />
					<Route path='/motoristas' exact={true} component={Motorista} />
					<Route path='/motoristas/cadastrar' exact={true} component={CadastrarMotorista} />
					<Route path='/veiculos' exact={true} component={Veiculo} />
					<Route path='/veiculos/cadastrar' exact={true} component={CadastrarVeiculo} />
					<Route path='/viagens' exact={true} component={Viagem} />
					<Route path='/viagens/cadastrar' exact={true} component={CadastrarViagem} />
				</Switch>
			</Container>
		</main>
	);
}

export default Main;