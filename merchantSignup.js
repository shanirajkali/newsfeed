function merchantSignup() {
	var name=document.getElementById('name').value;
	var gender=document.getElementById('gender').value;
	var email=document.getElementById('email').value;
	var phone=document.getElementById('phone').value;
	var type=document.getElementById("merchant_type").value;
	var country=document.getElementById("country").value;
	var state=document.getElementById('state').value;
	var district=document.getElementById('district').value;
	var city=document.getElementById('city').value;
	var address=document.getElementById('address').value;
	var dob=document.getElementById('dob').value;
	var password=document.getElementById('password').value;
	var merchant='{"name":"'+name+'","gender":"'+gender+'","email":"'
					+email+'","phone":"'+phone+'","type":"'+type+'","country":"'
					+country+'","state":"'+state+'","district":"'+district+'","city":"'
					+city+'","address":"'+address+'","dob":"'+dob+'","password":"'+password+'"}';

	console.log(merchant);
	var xhttp=new XMLHttpRequest();
	xhttp.open("POST","merchantSignup",true);
    xhttp.send(merchant);
	xhttp.onreadystatechange=function(){
	if(xhttp.readyState==4){
		if(xhttp.status == 200){
			console.log(xhttp.responseText);
			var response=JSON.parse(xhttp.responseText);
			var flag=parseInt(response.flag);
			if(flag==1){

			window.location.href = "http://localhost:9000/collegeproj/freshheap.html";
			console.log(response.password);
			signupSuccessfull();
			}
			else{
				document.getElementById('error').innerHTML=response.status;
			}		
		}
		else if(xhttp.status == 500){
		console.log("server problem");	
		}

	}
};

}