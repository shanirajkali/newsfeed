function merchantSignupVal() {
	var password=document.getElementById("password").value;
	var retype_password=document.getElementById("retype_password").value;

	if(password!=retype_password){
		alert('both password must be matched');
		return false;
	}
	merchantSignup();

}