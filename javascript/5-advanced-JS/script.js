// Function constructor

var john = {
    name: 'John',
    yearOfBirth: 1990,
    job:'teacher'
};

var Person = function(name, yearOfBirth, job){
    this.name = name;
    this.yearOfBirth = yearOfBirth;
    this.job = job;
//    this.calculateAge = function(){
//        console.log(2016 - this.yearOfBirth);
//    }
}

Person.prototype.calculageAge = function() {
    console.log(2016 - this.yearOfBirth);
    
}

// new creates empty object
var john = new Person('John', 1990, 'teacher');

john.calculageAge();

// array has a prototype chain
// prototype chain method likes push unshift

var arr = [1,2,3];

console.log(arr.hasOwnProperty('length')); // true
console.log(john instanceof(Person)) // true




