//DEclaração de variaveis Globais de contagem de tempo
let countdown;
//Selecionar a div onde o tempo será mostrado
const timerDisplay = document.querySelector('.display__time-left');
//Selecionar a div aonde o horário após otimer será mostrado
const endTime = document.querySelector('.display__end-time');
//seleciona os botões que determinam o tempo
const buttons = document.querySelectorAll('[data-time]');

//Função de Contagemde tempo
function timer(seconds){
    //quando iniciar o timer limpar qualquer outro timer que exista
    clearInterval(countdown);

    //verificar inicio da contagem de tempo
    const now = Date.now();
    //a cada segundo mostra tempo restante
    const then = now + seconds * 1000;

    //exibe a contagem antes do interval, pra mostrar o tempo total
    displayTimeLeft(seconds);
    //exibir a hora pós contagem
    displayEndTime(then);

    //contagem do Tempo decrescente
    countdown = setInterval(() => {     
        //ao usar a função abaixo, pode ver no console que ao diminuir e passar do zero ele começa a contar negativo, 
        //por isso é necessario parar a função quando chegar em um valor menos que zero
        const secondsLeft = Math.round((then - Date.now()) / 1000);
        if(secondsLeft < 0) {
            clearInterval(countdown);  
            return;
        }
        //exibir o contador no console
        displayTimeLeft(secondsLeft);
    }, 1000); 
}

//ao usar apenas o interval, ele começa a rodar a partir do tempo que foi colocado, no caso, 1 segundo, 
//por isso caso tenha 10 segundos ele vai começar a contar a partir do 9, por isso precisamos criar uma função para exibir o tempo que falta
function displayTimeLeft(seconds){
    const minutes = Math.floor(seconds/60);
    const remainderSeconds = seconds % 60;
    const display = `${minutes}:${remainderSeconds < 10 ? '0': ''} ${remainderSeconds}`;
    //Adicionar o timer ao Title da pagina
    document.title = display;
    timerDisplay.textContent = display;
}

//Exibir a hora  exata que o timer findará
function displayEndTime(timestamp){
    const end = new Date(timestamp);
    const hour = end.getHours();
    const minutes = end.getMinutes();
    endTime.textContent = `Seu timer findará ${hour}:${minutes < 10 ? '0' : ''}${minutes}`;
}
//Função para iniciar o Timer ao clicar no botão
function startTimer(){
    //Pegar o valor do data-time do botão que foi clicado e transformar em inteiro
    const seconds = parseInt(this.dataset.time);
    timer(seconds);
}

//identificar o evento do click no botao e atribuir a função 
buttons.forEach(button => button.addEventListener('click', startTimer));
document.customForm.addEventListener('submit', function(e) {
    e.preventDefault();
    //pegar o que foi digitado
    const mins = this.minutes.value;
    //atribuir como parametro da funcao, transformando em segundos
    timer(mins * 60);
    //limpar cada vez que for digitado outro
    this.reset();
});