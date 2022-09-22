var score="";
function addBola(){
	var bola = document.createElement("div");
	bola.setAttribute("class","bola");

	var p1 = Math.floor(Math.random() * 720);
	var p2 = Math.floor(Math.random() * 720);
	console.log(p1);

	bola.setAttribute("style", "left:" + p1 + "px; top: " + p2 + "px;");
	bola.setAttribute("onclick", "estourar(this)");

	document.body.appendChild(bola);
}
function estourar(el){
	var del = document.body.removeChild(el);
	if(del){
		score++;
		document.getElementById("score").innerHTML='<h3>Pontos ='+ score +'</h3>';
	}
}
function iniciar(){
	setInterval(addBola, 1000);
}