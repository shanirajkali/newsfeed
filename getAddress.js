function getState(){
	var jsonString='{"get":"state","where":"country","value":"india"}';
		console.log(jsonString);
		var xhttp=new XMLHttpRequest();
		xhttp.open("POST","address",true);
		console.log(xhttp.send(jsonString));
		xhttp.onreadystatechange=function(){
		if (xhttp.readyState == 4){
				 	if(xhttp.status == 200) {
				 		console.log(xhttp.responseText);
				 		var obj = JSON.parse(xhttp.responseText);
				 		var stateList=document.getElementById('state');
				 		j=stateList.length-1;
				 		while(j>=0){
				 			stateList.remove(j);
				 			j--;
				 		}
				 		var cityList=document.getElementById('city');	
				 		l=cityList.length-1;
				 		while(l>=0){
				 			cityList.remove(j);
				 			l--;
				 		}
				 		var i=0;
				 		for(i=0;i<obj.locations.length;i++){
				 			var st=new Option(obj.locations[i],obj.locations[i]);
				 			stateList.options.add(st);
				 		}
				 		getDistrict();
					}else if(xhttp.status == 500){
						console.log("server fat gaya h");
					}
				}
		};
		
}

function getDistrict(){
	var state=document.getElementById("state").value;
	var jsonString='{"get":"district","where":"state","value":"'+state+'"}';
		console.log(jsonString);
		var xhttp=new XMLHttpRequest();
		xhttp.open("POST","address",true);
		console.log(xhttp.send(jsonString));
		xhttp.onreadystatechange=function(){
		if (xhttp.readyState == 4){
				 	if(xhttp.status == 200) {
				 		console.log(xhttp.responseText);
				 		var obj = JSON.parse(xhttp.responseText);				 		
				 		var districtList=document.getElementById('district');
				 		var i=0;
				 		j=districtList.length-1;
				 		while(j>=0){
				 			districtList.remove(j);
				 			j--;
				 		}
				 		var cityList=document.getElementById('city');	
				 		k=cityList.length-1;
				 		while(k>=0){
				 			cityList.remove(k);
				 			k--;
				 		}
				 		for(i=0;i<obj.locations.length;i++){
				 			var st=new Option(obj.locations[i],obj.locations[i]);
				 			districtList.options.add(st);
				 		}
				 		getCity();
					}else if(xhttp.status == 500){
						console.log("server fat gaya h");
					}
				}
		};

}
function getCity(){
	var district=document.getElementById("district").value;
	var jsonString='{"get":"city","where":"district","value":"'+district+'"}';
		var xhttp=new XMLHttpRequest();
		xhttp.open("POST","address",true);
		xhttp.send(jsonString);
		xhttp.onreadystatechange=function(){
		if (xhttp.readyState == 4){
				 	if(xhttp.status == 200) {
				 		console.log(xhttp.responseText);
				  		var obj = JSON.parse(xhttp.responseText);				 		
				 		var cityList=document.getElementById('city');	
				 		j=cityList.length-1;
				 		while(j>=0){
				 			cityList.remove(j);
				 			j--;
				 		}
				 		var i=0;
				 		for(i=0;i<obj.locations.length;i++){
				 			var st=new Option(obj.locations[i],obj.locations[i]);
				 			cityList.options.add(st);
				 		}
					}else if(xhttp.status == 500){
						console.log("server fat gaya h");
					}
				}
		};
}
