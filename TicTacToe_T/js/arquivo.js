const statusDisplay = document.querySelector('.game--status');
let gameActive = true;
let curretPlayer = 'X';
let gameState = ["", "", "", "", "", "", "", ""];
const winningMEnsage=()=> `Jogador ${curretPlayer} Venceu!`;
const curretPlayerTurn=()=> `Vez de ${curretPlayer}`;

statusDisplay.innerHTML = curretPlayerTurn();

const winningConditions =[[0, 1, 2], [3, 4, 5], [6, 7, 8], [0, 3, 6], [1, 4, 7], [2, 5, 8], [0, 4, 8], [2, 4, 6]];