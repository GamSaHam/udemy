import React from 'react';

const ValidationComponent = props => {
  const { textLength } = props;

  let validationMessage = 'Text long enough';

  if (textLength < 5) {
    validationMessage = 'Text too short';
  }

  return (
    <div>
      <p>{validationMessage}</p>
    </div>
  );
};

export default ValidationComponent;
