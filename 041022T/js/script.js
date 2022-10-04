//variavel globais para contagem de tempo
let countdown;

//seleciona a div onde o timer será mostrado
const timerDisplay = document.querySelector('.display__time-left');

//selecionar a div onde o horario após o timer irá ser exibido
const endTime = document.querySelector('.display__end-time');

//selecionar os botoes que vao determinar o tempo do timer
const buttons = document.querySelectorAll('[data-time]');

//carregar os audios
var ini_a = new Audio();
var fim_a = new Audio();
//informa o source dos audios
ini_a.src='som/Jump.mp3';
fim_a.src='som/Bike.mp3';

//Função de contagem do tempo
function timer(seconds){
    //abaixo quando iniciarmos o timer ele limpara qualquer outro que exista
    clearInterval(countdown);

    //verificar o momento inicial da contagem de tempo
    const now = Date.now();
    //abaixo atuliza segundo a segundo o tempo restante
    const then = now + seconds * 1000;

    //exibe a contagem antes do interval, que mostratá o tempo total
    displayTimeLeft(seconds);
    //exibe a horaaapós a contagem
    displayEndTime(then);

    //Contagem do tempo decrescente
    countdown = setInterval(() => {     
        //ao usar a função abaixo, pode ver no console que ao diminuir e passar do zero ele começa a contar negativo, 
        //por isso é necessario parar a função quando chegar em um valor menos que zero
        const secondsLeft = Math.round((then - Date.now()) / 1000);
        if(secondsLeft < 0) {
            fim_a.play();
            clearInterval(countdown);  
            return;
        }
        //exibir o contador no console
        displayTimeLeft(secondsLeft);
    }, 1000); 
}