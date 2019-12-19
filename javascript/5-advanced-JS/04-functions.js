// functions

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

var age = arrayCalc(years, calculateAge);

console.log(age);

function isFullAge(el) {
  return el >= 18;
}

var fullAges = arrayCalc(age, isFullAge);

console.log(fullAges);
