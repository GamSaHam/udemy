import React from 'react';

const ValidationComponent = props => {
  const { textLength } = props;

  let output = null;

  if (textLength < 5) {
    output = <p>Text too short</p>;
  } else if (textLength >= 10) {
    output = <p>Text too much long</p>;
  }

  return output;
};

export default ValidationComponent;
