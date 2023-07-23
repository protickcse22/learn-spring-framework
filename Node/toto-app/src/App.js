import React, { Component } from 'react';
import './App.css';
import Counter from './components/counter/Counter';

class App extends Component {
  render() {
    return (
      <div className="App">
          <Counter />
          <Counter by={2}/>
          <Counter by={5}/>
      </div>
    );
  }
}


export default App;
