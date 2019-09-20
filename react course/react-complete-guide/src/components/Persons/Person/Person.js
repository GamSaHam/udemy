import React, { Component, Fragment } from 'react';

import PropTypes from 'prop-types';
import Aux from '../../../hoc/Auxiliary';
import withClass from '../../../hoc/withClass';
import classes from './Person.css';

import AuthContext from '../../../context/auth-context';

class Person extends Component {
  constructor(props) {
    super(props);

    this.inputElementRef = React.createRef();
  }

  static contextType = AuthContext;

  componentDidMount() {
    //document.querySelector('input').focus();
    //this.inputElement.focus();
    this.inputElementRef.current.focus();

    console.log(this.context.authenticated);
  }

  render() {
    const { name, age, click, changed } = this.props;
    console.log('[Person.js] rendering...');

    return (
      <Aux>
        {this.context.authenticated ? (
          <p>Authenticated!</p>
        ) : (
          <p>Please log in</p>
        )}

        <p onClick={click}>
          I'm a {name} I am {age} years old!
        </p>
        <p>{this.props.children}</p>
        <input
          type="text"
          ref={this.inputElementRef}
          onChange={changed}
          value={name}
        />
      </Aux>
    );
  }
}

Person.propTypes = {
  click: PropTypes.func,
  name: PropTypes.string,
  age: PropTypes.number,
  changed: PropTypes.func
};

export default withClass(Person, classes.Person);
