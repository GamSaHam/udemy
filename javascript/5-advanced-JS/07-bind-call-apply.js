var john = {
  name: "John",
  age: 26,
  job: "teacher",
  presentation: function(style, timeOfDay) {
    if (style === "formal") {
      console.log(
        "Good " +
          timeOfDay +
          ", Ladies and gentleman!" +
          "I'm " +
          this.name +
          ", I'm a " +
          this.job +
          " and I'm " +
          this.age +
          " years old."
      );
    } else if (style === "friendly") {
      console.log(
        "Hey! What's up? I'm " +
          this.name +
          ", I'm a " +
          this.job +
          " and I'm " +
          this.age +
          " years old. Have a nice " +
          timeOfDay +
          "."
      );
    }
  }
};

john.presentation("formal", "morning");
john.presentation("friendly", "morning");

var emily = {
  name: "Emily",
  age: 35,
  job: "designer"
};

john.presentation.call(emily, "friendly", "afternoon");

var johnFriendly = john.presentation.bind(john, "friendly");
johnFriendly("morning");

//example 2
var years = [1990, 1965, 1937, 2005, 1998];

function arrayCalc(arr, fn) {
  var arrRes = [];

  for (var i = 0; i < arr.length; i++) {
    arrRes.push(fn(arr[i]));
  }

  return arrRes;
}

function calculateAge(el) {
  return 2019 - el + 1;
}

function isFullAge(limit, el) {
  return el >= limit;
}

var ages = arrayCalc(years, calculateAge);
var fullJapan = arrayCalc(ages, isFullAge.bind(this, 20));

//bind('객체', 첫번째 argument)

console.log(ages);
console.log(fullJapan);
