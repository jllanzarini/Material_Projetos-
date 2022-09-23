var cvs = document.getElementById("canvas");
var ctx = cvs.getContext("2d");

//caregamento das imagens
var bird = new Image();
var bg =  new Image();
var fg = new Image();
var pipeS = new Image();
var pipeI = new Image();

bird.src = "images/bird.png";
bg.src = "images/bg.png";
fg.src = "images/fg.png";
pipeS.src = "images/pipeNorth.png";
pipeI.src = "images/pipeSouth.png";

// Variaveis Jogabilidade
var gap = 85;
var constant;
var bX = 10;
var bY = 150;
var gravidade = 1.5;
var score = 0;

//carregamento audios
var fly = new Audio();
var scoreAudio = new Audio();

fly.src = "sounds/fly.mp3";
scoreAudio.src = "sounds/score.mp3";

//evento ao Pressionar a tecla
document.addEventListener("keydown", moveUp);

//Função chamadda pelo evento acima(moveUP)
function moveUp(){
    bY -= 25;
    fly.play();
}

//cordenadas tubulações
var pipe = [];
pipe[0]={ x: cvs.width, y: 0 };


//Jogabilidade
function draw(){
    ctx.drawImage(bg, 0, 0);
        for(var i = 0; i < pipe.length; i++){
            constant = pipeS.height + gap;
            ctx.drawImage(pipeS, pipe[i].x, pipe[i].y);
            ctx.drawImage(pipeI, pipe[i].x, pipe[i].y + constant);
            pipe[i].x--; //Pesquisem esse conceito

            if (pipe[i].x == 125){
                pipe.push({x: cvs.width, y: Math.floor(Math.random() * pipeS.height) - pipeS.height});
          
            }
    //Verificando a colisão
            if (bX + bird.width >= pipe[i].x && bX <= pipe[i].x + pipeS.width && (bY <= pipe[i].y + pipeS.height ||
            bY + bird.height >= pipe[i].y + constant) || bY + bird.height >= cvs.height - fg.height){
                location.reload(); // Recarregar a Pagina
            }
            if(pipe[i].x == 5){
                score++;
                scoreAudio.play();
            }
        }
            ctx.drawImage(fg, 0, cvs.height - fg.height);
            ctx.drawImage(bird, bX, bY);
            bY += gravidade;

            ctx.fillStyle = "#000";
            ctx.font = "20px Verdana";
            ctx.fillText("Score: " + score, 10, cvs.height - 20);

            requestAnimationFrame(draw);
}


draw();