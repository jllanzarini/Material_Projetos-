var cvs = document.getElementById("canvas");
var ctx = cvs.getContext("2d");

//Carregar as imagens
var bird = new Image();
var bg = new Image();
var fg = new Image();
var pipeNorth = new Image();
var pipeSouth = new Image();

bird.src = "img/bird.png";
bg.src = "img/bg.png";
fg.src = "img/fg.png";
pipeNorth.src = "img/pipeNorth.png";
pipeSouth.src = "img/pipeSouth.png";

//Variaveis de Jogabilidade
var gap = 85;
var constant;
var bX = 10;
var bY = 150;
var gravidade = 1.5;
var score = 0;

//Carragas os audios
var fly = new Audio();
var ponto = new Audio();

fly.src = "sounds/fly.mp3";
ponto.src = "sounds/score.mp3";

//Evento do Voo - Precionar a tecla
document.addEventListener("keydown", moveUP);

function moveUP(){
    bY -= 25;
    fly.play();
}

//Montanto coordenadas dos tubos
var pipe = [];
pipe[0] = {
    x: cvs.width, 
    y:0
};

//Funcões de Jogabilidade
function draw(){
    ctx.drawImage(bg, 0,0);

    for (var i = 0; i < pipe.length; i++) {

        constant = pipeNorth.height + gap;
        ctx.drawImage(pipeNorth, pipe[i].x, pipe[i].y);
        ctx.drawImage(pipeSouth, pipe[i].x, pipe[i].y + constant);
   
        pipe[i].x--;
   
        if (pipe[i].x == 10) {//reduzindo aumenta a distancia dos tubos
          pipe.push({
            x: cvs.width,
            y: Math.floor(Math.random() * pipeNorth.height) - pipeNorth.height
          });
        }
        
        //Detectando a colisão com o Objeto
        if (bX + bird.width >= pipe[i].x && bX <= pipe[i].x + pipeNorth.width && (bY <= pipe[i].y + pipeNorth.height || bY + bird.height >= pipe[i].y + constant) || bY + bird.height >= cvs.height - fg.height){
            location.reload();  //Recarregar a Pagina
        }
          //Obstaculo superado e pponto somado
          if (pipe[i].x ==5){
            score++;// soma ponto ao score
            ponto.play();//Executa audio ponto
          }
    }
    ctx.drawImage(fg, 0, cvs.height - fg.height); //Propriedades do cenário
    ctx.drawImage(bird, bX, bY); //Propriedades inserção passaro
    bY += gravidade; //Queda do Passaro

    ctx.fillStyle = "#000";
    ctx.font = "20px Verdana";
    ctx.fillText("Score : " + score, 10, cvs.height - 20);

    requestAnimationFrame(draw);
}
draw();


