function validar(){
		var nome = document.getElementById('nome').value;
		var email = document.getElementById('email').value;
		var telefone = document.getElementById('telefone').value;
		var cpf = document.getElementById('CPF').value;
		var senha = document.getElementById('senha').value;
		var confirmSenha = document.getElementById('confirmSenha').value;
		if (!nome) {
			document.getElementById('erro').style.display = 'block';
			document.getElementById('erro').innerHTML = 'Preencha o campo nome'
			return false;
		}
		if(!email){
			document.getElementById('erro').style.display = 'block';
			document.getElementById('erro').innerHTML = 'Preencha o campo email'
			document.getElementById('email').focus()
			return false;
		}
		if(!telefone){
			document.getElementById('erro').style.display = 'block';
			document.getElementById('erro').innerHTML = 'Preencha o campo telefone'
			return false;
		}
		if(!cpf){
			document.getElementById('erro').style.display = 'block';
			document.getElementById('erro').innerHTML = 'Preencha o campo CPF'
			return false;
		}
		if(!senha){
			document.getElementById('erro').style.display = 'block';
			document.getElementById('erro').innerHTML = 'Preencha o campo senha'
			return false;
		}
		if(!confirmSenha){
			document.getElementById('erro').style.display = 'block';
			document.getElementById('erro').innerHTML = 'Preencha o campo Confirmar Senha'
			return false;
		}
		if(senha != confirmSenha){
			document.getElementById('erro').style.display = 'block';
			document.getElementById('erro').innerHTML = 'Senhas erradas'
			return false;
		}
	}