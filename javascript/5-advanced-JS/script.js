// Function constructor

var john = {
  name: "John",
  yearOfBirth: 1990,
  job: "teacher"
};

var Person = function(name, yearOfBirth, job) {
  this.name = name;
  this.yearOfBirth = yearOfBirth;
  this.job = job;
  //    this.calculateAge = function(){
  //        console.log(2016 - this.yearOfBirth);
  //    }
};

Person.prototype.calculageAge = function() {
  console.log(2016 - this.yearOfBirth);
};

Person.prototype.lastName = "Smith";

// new creates empty object
var john = new Person("John", 1990, "teacher");

john.calculageAge();

// array has a prototype chain
// prototype chain method likes push unshift

var arr = [1, 2, 3];

john.hasOwnProperty("job"); // true
john.hasOwnProperty("lastName"); // false
john instanceof Person; // true

var x = [2, 4, 6];

//console.info(x); // use chrome developer
