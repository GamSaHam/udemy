/*
    Functions
*/
// functiion [naming] (argument)
function calculateAge(birthYear){
    return 2019 - birthYear;  
}

var ageJohn = calculateAge(1991);
var ageMike = calculateAge(1964);
var ageJane = calculateAge(1961);

console.log(ageJohn, ageMike, ageJane);

/*
    Function Statements and Expressions
*/
var whatDoYouDo = function(job, firstName){
  
    console.log(firstName+" job is "+ job);
}


whatDoYouDo("teacher", "John");















