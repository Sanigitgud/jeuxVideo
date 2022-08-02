var modal = document.getElementsByClassName("modal");

// Get the button that opens the modal
var btn = document.getElementsByClassName("modalButton");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close");

// When the user clicks the button, open the modal 
for (var i = 0; i < btn.length; i++) {
    btn[i].onclick = function () {
        this.nextElementSibling.style.display = "block";
        //   modal.style.display = "block";
    }
}
for (var i = 0; i < span.length; i++) {
    span[i].onclick = function () {
        this.closest(".modal").style.display = "none";
    }
}

// When the user clicks on <span> (x), close the modal
// span.onclick = function () {
//     modal.style.display = "none";
// }

//When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    for (var i = 0; i < modal.length; i++) {
        if (event.target == modal[i]) {
            modal[i].style.display = "none";
        }
      }
    }