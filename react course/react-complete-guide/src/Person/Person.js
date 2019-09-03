import React from 'react';
import './Person.css';

const person = props => {
  const { name, age, click, changed } = props;

  return (
    <div className="Person">
      <p onClick={click}>
        I'm a {name} I am {age} years old!
      </p>
      <p>{props.children}</p>
      <input type="text" onChange={changed} value={name} />
    </div>
  );
};

export default person;
