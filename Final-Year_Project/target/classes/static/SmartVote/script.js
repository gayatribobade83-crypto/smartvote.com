// LOGIN FUNCTION
let loginForm = document.getElementById("loginForm");

if(loginForm){
loginForm.addEventListener("submit", function(e){

e.preventDefault();

let email = document.getElementById("email").value;
let role = document.getElementById("role").value;

// Save logged-in user
let user = {
    email: email
};

localStorage.setItem("voterLoggedIn", JSON.stringify(user));

// Redirect
if(role === "admin"){
    window.location.href = "admin.html";
}else{
    window.location.href = "home.html";
}

});
}