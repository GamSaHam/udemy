const person = {
  name: 'Max'
};

const secondPerson = {
  ...person
};

person.name = 'Manu';

console.log(secondPerson);

const numbers = [1, 2, 3];

const doubleNumArray = numbers.map(num => {
  return num * 2;
});

console.log(numbers);
console.log(doubleNumArray);
