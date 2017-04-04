function getNewsType() {
	var type=document.getElementById('merchant_type').value;
	if(type!="local"){
		//document.getElementById("state").style.visibility="hidden";
		document.getElementById("state").value="";
		document.getElementById("district").value="";
	//	document.getElementById("city").value="";
		$("#state").hide();
		$("#district").hide();
		$("#city").hide();
		
		
	}
	else{
		$("#state").show();
		$("#district").show();
		$("#city").show();

	//	document.getElementById("state").style.visibility="visible";
	//	document.getElementById("district").style.visibility="visible";
	//	document.getElementById("city").style.visibility="visible";
		getState();


	}

}