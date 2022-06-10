function verifyPassword() {
	var pwd1 = document.getElementById("password").value;
	var pwd2 = document.getElementById("passwordRepeat").value;
	
	if(pwd1 == ""){
		document.getElementById("message").innerHTML ="Bitte Passwort eingeben!";
		return false;
	}
	if(pwd1.length <5){
		document.getElementById("message").innerHTML ="Passwort muss 5 Zeichen haben!";
		return false;
	}
	
	if (pwd1 != pwd2) {
	alert ("Passwörter nicht identisch!");
	
	
	}
}