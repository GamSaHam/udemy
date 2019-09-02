const person = {
  name: 'Max'
};

const newPerson = {
  ...person,
  age: 28
};

console.log(newPerson);

const filter = (...args) => {
  return args.filter(el => el === 1);
};

console.log(filter(1, 2, 3, 4));
