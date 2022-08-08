function search() {
  var searchText = document.getElementById("answertext").value;
  var e = document.getElementById("genre-select");
  var genreS = e.options[e.selectedIndex].value;

  const xhttp = new XMLHttpRequest();
  xhttp.onload = function () {
    document.getElementById("card-to-swap").innerHTML = this.responseText;
    openModal();
  }
  xhttp.open("GET", "search?q=" + searchText+ "&g=" + genreS, true);
  xhttp.send();
}

var inputs = document.getElementById("answer").getElementsByTagName("input");
for (var i = 0; i < inputs.length; i++) {
  if (inputs[i].getAttribute("type") == "text") {
    inputs[i].onkeydown = function (e) {
      // If enter key
      if (e.key === 'Enter') {
        e.preventDefault(); // Ensure it is only this code that runs
        search(this.value);
      }
    }
  } else if (inputs[i].getAttribute("type") == "submit") {
    inputs[i].onclick = function (e) {
      e.preventDefault();
      search(document.getElementById("answertext").value);
    }
  }
}