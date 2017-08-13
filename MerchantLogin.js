
function login() {

	var status='0';

	var email=document.getElementById('email').value;
	var password=document.getElementById('pass').value;
	var loginDetails='{"email":"'+email+'","password":"'+password+'"}';
	console.log(loginDetails);
	var xhttp=new XMLHttpRequest();
	xhttp.open("POST","merchantLogin",true);
	console.log(loginDetails);
	xhttp.send(loginDetails);
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4){
			if(xhttp.status==200){
				console.log(xhttp.responseText);
				var response=JSON.parse(xhttp.responseText);
				status=response.status;
				if(status=='1'){
					$("#login").hide();
					$("#login1").hide();
					$("#login2").hide();
					$("#posting").show();
					$("#postedNews").show();
					
					$('#name').html("Name: "+response.name);
					$('#gender').html('Gender: '+response.gender);
					$('#phone').html('Phone: '+response.phone);
					$('#merchantType').html('News: '+response.merchantType);
					$('#address').html('Address: '+response.address);
					$('#check').html('Email: '+response.email);
				}
				else{
					$("#posting").hide();
					$("#postedNews").hide();
					
					//unsuccessfull  login
					
				}
			}
		}
	};
	return status;
}

function newsPost(){
	var status='0';
	var heading=document.getElementById('newsHeading').value;
	var description=document.getElementById('newsDescription').value;
	var news='{"heading":"'+heading+'","description":"'+description+'"}';
	console.log(news);
	var xhttp=new XMLHttpRequest();
	xhttp.open("POST","newsPost",true);
	xhttp.send(news);
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4){
			if(xhttp.status==200){
				console.log(xhttp.responseText);
				try {
					var response=JSON.parse(xhttp.responseText);
				status=response.status;
				} 
      
     			 catch ( e ) {
        			 var msg="something went wrong!!";
        			var res=msg.fontcolor("green");
					document.getElementById("status").innerHTML= res;
      					}
				
				if (status=='3') {
					document.getElementById("status").innerHTML="successfully posted";

				}
				else
				{
					document.getElementById("status").innerHTML="something went wrong!!";
				}
				
			}
		}
	};
	return status;
}

function logout(){
	var status='0';
	
	var logout='{"status":"0"}';
	console.log(logout);
	var xhttp=new XMLHttpRequest();
	xhttp.open("POST","merchantLogout",true);
	xhttp.send(logout);
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4){
			if(xhttp.status==200){
				console.log(xhttp.responseText);
				window.location.href = 'http://localhost:9000/collegeproj/freshheap.html';
				
			}
		}
	};
	return status;
}