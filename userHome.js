function getNews(){
	var jsonString='{"type":["technical","local"],"area":["india","uttar pradesh","meerut","mawana"],"from":"start","status":"15"}';
		console.log(jsonString);
		var xhttp=new XMLHttpRequest();
		xhttp.open("POST","getNews",true);
		console.log(xhttp.send(jsonString));
		xhttp.onreadystatechange=function(){
		if (xhttp.readyState == 4){
				 	if(xhttp.status == 200) {
				 		console.log(xhttp.responseText);
				 		var obj = JSON.parse(xhttp.responseText);
				 		
					}else if(xhttp.status == 500){
						console.log("server fat gaya h");
					}
				}
		};
}
var from="start";
var show=JSON.parse("{}");
function news(type){
	var jsonString='{"type":["'+type+'"],"area":[],"from":"'+from+'","status":"15"}';
		console.log(jsonString);
		var xhttp=new XMLHttpRequest();
		xhttp.open("POST","getNews",true);
		console.log(xhttp.send(jsonString));
		xhttp.onreadystatechange=function(){
		if (xhttp.readyState == 4){
				 	if(xhttp.status == 200) {
				 		console.log(String(xhttp.responseText));
				 		var obj = JSON.parse(xhttp.responseText);
				 		length=obj.createTime.length;
				 		if(length>0){
				 		from=obj.createTime[length-1];}
				 		else
				 			form="";

				 		show=obj;
				 		displayNews(length,type);
					}else if(xhttp.status == 500){
						console.log("server fat gaya h");
					}
				}
		};
	}

function displayNews(length,type){
	var i=0;
	var element = document.getElementById("showNews");
	var button=document.createElement("button");
	var buttonText=document.createTextNode("Load More");
	button.appendChild(buttonText);
	while(i<length){

	var div=document.createElement('div');
	var p=document.createElement("p");
	var h=document.createElement("h3");
	var ct=document.createElement("p");
	var postedBy=document.createElement("p");
	
	var para=document.createTextNode(show.description[i]);
	var add=show.address[i];
	var postedByText=document.createTextNode("By "+show.merchantName[i]+" In "+add);
	if(add=="null"){
		postedByText=document.createTextNode("By "+show.merchantName[i]);
	}


	postedBy.appendChild(postedByText);	
	p.appendChild(para);
	var head=document.createTextNode(show.heading[i]);
	h.appendChild(head);
	

	var ctime=document.createTextNode("Posted on: "+show.createTime[i]+"  News : "+show.newsType[i]);

	ct.appendChild(ctime);
	div.appendChild(h);
	div.appendChild(ct);
	div.appendChild(p);
	div.appendChild(postedBy);
	element.appendChild(div);
	div.setAttribute("class","col-12 news");
	ct.setAttribute("class","newsType");
	postedBy.setAttribute("id","postedBy");
	i++;
}	
	if (length>=5) {
	element.appendChild(button);
	var fetch=type+"News()";
	button.setAttribute("onclick",fetch);
	button.setAttribute("class","col-12 nfButton");
	button.setAttribute("id","showMore");

	}
	}
var all=0;
function allNews(){
	if (all==0) {from="start";all++;local=0;tech=0;bus=0;hel=0;
	var element = document.getElementById("showNews");
	var j=element.childNodes.length;
	console.log(j);
	while(j>0){j--;
	element.removeChild(element.childNodes[j]);}
	}
	news("all");
	$("#showMore").hide();
	}
var local=0;
function localNews(){
	if(local==0){form="start";local++;from="start";tech=0;bus=0;hel=0;all=0;
var element = document.getElementById("showNews");
	var j=element.childNodes.length;
	console.log(j);
	while(j>0){j--;
	element.removeChild(element.childNodes[j]);}}
	news("local");
	$("#showMore").hide();
	}
var tech=0;
function technicalNews(){
	if (tech==0) {from="start";tech++;from="start";local=0;bus=0;hel=0;all=0;
var element = document.getElementById("showNews");
	var j=element.childNodes.length;
	console.log(j);
	while(j>0){j--;
	element.removeChild(element.childNodes[j]);}}
	news("technical");
	$("#showMore").hide();
	}
var bus=0;
function businessNews(){
	if (bus==0) {from="start";bus++;from="start";local=0;tech=0;hel=0;all=0;
var element = document.getElementById("showNews");
	var j=element.childNodes.length;
	console.log(j);
	while(j>0){j--;
	element.removeChild(element.childNodes[j]);}}
	news("business");
	$("#showMore").hide();
	}
var hel=0;
function healthNews(){
	if (hel==0) {from="start";hel++;from="start";local=0;tech=0;hel=0;all=0;
var element = document.getElementById("showNews");
	var j=element.childNodes.length;
	console.log(j);
	while(j>0){j--;
	element.removeChild(element.childNodes[j]);}}
	news("health");
	$("#showMore").hide();
	}