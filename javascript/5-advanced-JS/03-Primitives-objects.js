//Primitives
var a = 23;
var b = a;

a = 46;

console.log(a);
console.log(b);

// Objects
var obj1 = { name: "john", name: 26 };
var obj2 = obj1;

obj2.age = 28;
console.log(obj1.age);
console.log(obj2.age);

// Functions
var age = 27;
var obj = {
  name: "Jones",
  city: "Lisbon"
};

function change(a, b) {
  a = 38;
  b.city = "San Francisco";
}

change(age, obj);

console.log(age);
console.log(obj.city);
