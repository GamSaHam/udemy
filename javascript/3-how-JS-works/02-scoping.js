/*
    Scoping
*/

/*
var a = "Hello!";
first();

function first(){

    var b = "HI!";
    second();
    
    function second(){
        var c = "Hey!";
        console.log(a + b + c);
    }
    
}
*/

var a = "Hello!";
first();

function first(){
    var b= "HI!";
    second();
    
    function second(){
        var c = "Hey!";
        third();
    }
}

function third(){
    var d = "John";
    console.log(c);
}




















