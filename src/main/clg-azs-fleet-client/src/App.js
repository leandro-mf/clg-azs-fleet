import React from 'react';

import './App.css';
import 'bootstrap/dist/css/bootstrap.css';

import Header from './components/header/Header';
import Main from './components/main/Main';

function App() {
	return (
		<div>
			<Header />
			<br />
			<Main />
		</div>
	);
}

export default App;