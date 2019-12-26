// Closure definition
// An inner function has always access to the variables and parameters of
// its outer function, even after the outer function has returned.

function retirement(retirementAge) {
  var a = " years left until retirement.";

  return function(yearOfBirth) {
    var age = 2019 - yearOfBirth;
    console.log(retirementAge - age + a);
  };
}

var retirementUS = retirement(66);
retirementUS(1990);

// Scope Chain has the variable pointer
// Scope retirementUS function has retirementAge, a, yearOfBirth, age variable

function interviewQuestion(job) {
  return function(name) {
    if (job === "designer") {
      console.log(name + ", can you please explanin what UX design is?");
    } else if (job === "teacher") {
      console.log("What subject do you teach, " + name + "?");
    } else {
      console.log("Hello " + name + ", what do you do?");
    }
  };
}

interviewQuestion("teacher")("John");
