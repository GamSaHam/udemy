import React, { Component } from 'react';

import classes from './Person.css';

class Person extends Component {
  render() {
    const { name, age, click, changed } = this.props;

    console.log('[Person.js] rendering...');

    return (
      <div className={classes.Person}>
        <p onClick={click}>
          I'm a {name} I am {age} years old!
        </p>
        <p>{this.props.children}</p>
        <input type="text" onChange={changed} value={name} />
      </div>
    );
  }
}

export default Person;
