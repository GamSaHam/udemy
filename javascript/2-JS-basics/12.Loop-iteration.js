/*
    Loops and iteration
*/


// for loop
var john = ["John", "Smith", 1990, "designer", false];

for(var i=0;i<john.length;i++){
    console.log(john[i]);
}

var i =0;
while(i < john.length){
      
    if(typeof john[i] !== 'string') continue;
    console.log(john[i]);      
      
    i++; 
}


var i =0;
while(i < john.length){
      
    if(typeof john[i] !== 'string') break;
    console.log(john[i]);      
      
    i++; 
}







