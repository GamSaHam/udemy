/*

    Objects and properties

*/

var john = {
    firstName: 'John',
    lastName: 'Smith',
    birthYear: 1990,
    family: ['Jane', 'Mark', "Bob", "Emily"],
    job: "teacher",
    isMarried: false,
    calcAge: function(){
        this.age =  2018- this.birthYear;
    }
    
}

console.log(john.firstName);
console.log(john['lastName']);

var x = 'birthYear';
console.log(john[x]);

john.job = "designer";
john['isMarried'] = true;
console.log(john);


//new Object syntax
var jane = new Object();
jane.firstName = "Jane";
jane.birthYear = 1969;
jane['lastName'] = "Smith";
console.log(jane);

/*
 Object and methods
*/

john.calcAge();
console.log(john);
















