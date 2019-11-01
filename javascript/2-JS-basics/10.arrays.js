/*
 Arrays

*/

var names = ['John', "Mark", "Jane"];
var years = new Array(1990, 1969, 1948);


console.log(name[2]);
console.log(name.length);

// Mutate array data
names[1] = "Ben";
names[names.length] = "Mary";

console.log(names);

// Different data types

var john = ['John', 'Smith', 1990, "teacher", false];

john.push("blue");
john.unshift("Mr."); // Add new elements at the beginning of an array

john.pop(); // remove last element


john.shift(); //remove first element at the beginneing of an array

console.log(john.indexOf(1990)); // find the index of the first occurance of the search element provided

/*
    coding challenge
*/ 


function tipCalculator(bill){
    
    var percentage;
    if(bill < 50){
        percentage = .2;
        
    }else if(bill >= 50 && bill < 200){
        percentage = .15;
        
    }else{
        percentage = .1;
        
    }
    
    return percentage * bill;
    
}

var tip = tipCalculator(100);

console.log(tip);




















