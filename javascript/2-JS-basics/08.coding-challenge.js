/*
    CODING CHALLENGE 2

*/
var scoreJohn = (89 + 120 + 103) / 3;
var scoreMike = (116 + 94 + 123) / 3;
var scoreMary = (97 + 134 + 185) / 3;

console.log(scoreJohn, scoreMike, scoreMary);

// a > b > c
// b > a > c
// c > b > a
if(scoreJohn > scoreMike && scoreJohn > scoreMary){
    console.log("John's team wins with " + scoreJohn + " points");
        
}else if(scoreMike > scoreJohn && scoreMike > scoreMary){
         
  console.log("Mike's team wins with " + scoreJohn + " points");   
         
}else if(scoreMary > scoreJohn && scoreMary > scoreMike){
         
  console.log("Mary's team wins with " + scoreJohn + " points");   
         
}else{
         
  console.log("There is a draw");   
         
}















































