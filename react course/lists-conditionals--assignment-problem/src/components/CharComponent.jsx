import React from 'react';

const charComponent = props => {
  const { textValue, click } = props;

  let style = {
    display: 'inline-block',
    padding: '16px',
    textAlign: 'center',
    margin: '16px',
    border: '1px solid black'
  };

  return (
    <div style={style} onClick={click}>
      {textValue}
    </div>
  );
};

export default charComponent;
