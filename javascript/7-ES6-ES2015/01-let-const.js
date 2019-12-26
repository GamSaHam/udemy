// Lecture : let and const

/*
// ES5
var name5 = "Jane Smith";
var age5 = 23;
name5 = "Jane Miller";

console.log(name5);

// ES6
const name6 = "Jane Smith";
let age6 = 23;
//name6 = "Jane Miller";
console.log(name6);
*/

/*
// ES5
function driversLicence5(passedTest) {
  if (passedTest) {
    console.log(firstName);
    var firstName = "John";
    var yearOfBirth = 1990;
  }

  console.log(
    firstName +
      ", born in " +
      yearOfBirth +
      " ,is not officially allowed to drive a car."
  );
}

//function scope
driversLicence5(true);

// ES6
function driversLicence6(passedTest) {
  if (passedTest) {
    console.log(firstName);
    let firstName = "John";
    const yearOfBirth = 1990;
  }

  console.log(
    firstName +
      ", born in " +
      yearOfBirth +
      " ,is not officially allowed to drive a car."
  );
}

//block scope
driversLicence6(true);

*/

/*
let i = 23;

for (let i = 0; i < 5; i++) {
  console.log(i);
}

console.log(i);

var i2 = 23;

for (var i2 = 0; i2 < 5; i2++) {
  console.log(i2);
}

console.log(i2);
*/
