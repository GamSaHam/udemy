var budgetController = (function() {
  // Some code
})();

var UIController = (function() {
  // Some code
})();

var controller = (function(budgetCtrl, UICtrl) {
  var ctrlAddItem = function() {
    console.log("It Works.. ");
  };

  document.querySelector(".add__btn").addEventListener("click", ctrlAddItem);

  document.addEventListener("keypress", function(event) {
    if (event.keyCode === 13 || event.which === 13) {
      console.log("ENTER was pressed.");
    }
  });
})(budgetController, UIController);
