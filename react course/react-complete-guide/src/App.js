import React, { useState } from 'react';
import Person from './Person/Person';
import './App.css';

const app = props => {
  const [personState, setPersonState] = useState({
    persons: [
      { name: 'Max', age: 28 },
      { name: 'Manu', age: 29 },
      { name: 'Stephanie', age: 26 }
    ]
  });

  const [otherState, setOtherState] = useState('some other value');

  // manage in component
  // reserve word
  // change state react dom update and changing

  console.log(personState, otherState);

  //Arrow function
  const switchNameHandler = () => {
    //console.log('Was clicked!');
    // react not recognize
    // Don't do this = personState.persons[0].name = 'Maximilian';
    // Componenet has setState function
    // DOM recognize state is changed
    setPersonState({
      persons: [
        { name: 'Maximilian', age: 28 },
        { name: 'Manu', age: 29 },
        { name: 'Stephanie', age: 27 }
      ]
    });
  };

  return (
    <div className="App">
      <h1>Hi, I'm a React App</h1>
      <p>This is really working!</p>

      {
        // jsx onClick , HTML onclick
      }
      <button onClick={switchNameHandler}>Switch Name</button>

      <Person
        name={personState.persons[0].name}
        age={personState.persons[0].age}
      />
      <Person
        name={personState.persons[1].name}
        age={personState.persons[1].age}
      >
        My Hobbies: Racing
      </Person>
      <Person
        name={personState.persons[2].name}
        age={personState.persons[2].age}
      />
    </div>
  );

  // return React.createElement(
  //   'div',
  //   { className: 'App' },
  //   React.createElement('h1', null, 'Does this work now')
  // );
};

export default app;
