
/*
    Truthy and Falsy values and equality operators
*/

// falsy values : undefined, null, 0, '', NaN
// truthy values : NOT falsy values


var height = 23;

if(height){
    console.log("Variable is defined");
}else{
    console.log("Variable has NOT been defined");
}

// Equality operators
if(height == '23'){
    console.log("The == operator does type coercion!");    
}

// 23 == '23' // true
// strick equilty
// 23 === '23' // false



