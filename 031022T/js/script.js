$(function(){
    var operacoes = "A" // "A" => Adição "E" => Edição
    var indice_selecionado = -1;
    tbClientes = localStorage.getItem("tbClientes");//Recupera os dados armazenados
    
    tbClientes = JSON.parse(tbClientes); //Convertos  a String para Objeto

    if(tbClientes == null) //Caso não haja conteudo, inicia-se um vetor vazio
        tbClientes = [];

    //Função de Adição de Informações
    function Adicionar(){
        var cli = GetCliente("Codigo", $("#txtCodigo").val());
        if(cli !=null){
            alert("Código já cadastrado!");
            return;
        }

        var cliente = JSON.stringify({ 
            Codigo   : $("#txtCodigo").val(),
            Nome     : $("#txtNome").val(),
            Telefone : $("#txtFone").val(),
            Email    : $("#txtEmail").val()
        });

        tbClientes.push(cliente);
        localStorage.setItem("tbClientes", JSON.stringify(tbClientes));
        alert("Cadastro Efetuado com sucesso!");
        return true;
    }

    //Função de edição de Registros
    function Editar(){
        tbClientes[indice_selecionado] = JSON.stringify({
            Codigo   : $("#txtCodigo").val(),
            Nome     : $("#txtNome").val(),
			Telefone : $("#txtFone").val(),
			Email    : $("#txtEmail").val()
        });
        localStorage.setItem("tbClientes", JSON.stringify(tbClientes));
        alert("Informações alteradas com sucesso!")
        operacoes = "A";
        return true;
    }

    //Função que lista os registros 
    function Listar(){
        $("#tblListar").html("");
		$("#tblListar").html(
			"<thead>"+
			"	<tr>"+
			"<th></th>"+
			"	<th>Código</th>"+
			"	<th>Nome</th>"+
			"	<th>Telefone</th>"+
			"	<th>Email</th>"+
			"	</tr>"+
			"</thead>"+
			"<tbody>"+
			"</tbody>"
			);

            for (var i in tbClientes){
                var cli = JSON.parse(tbClientes[i]);
                $("#tblListar tbody").append("<tr>"+ //Append = Acrescentar
									 	 "	<td><img src='img/edit.png' alt='"+i+"' class='btnEditar'/><img src='img/delete.png' alt='"+i+
                                         "' class='btnExcluir'/></td>" + 
										 "	<td>"+cli.Codigo+"</td>" + 
										 "	<td>"+cli.Nome+"</td>" + 
										 "	<td>"+cli.Telefone+"</td>" + 
										 "	<td>"+cli.Email+"</td>" + 
		  								 "</tr>");

            }
     }
     //Função Excluir
     function Excluir(){
        indice_selecionado = parseInt($(this).attr("alt"));
        tbClientes.splice(indice_selecionado, 1); //O método splice() altera o conteúdo de uma lista, adicionando novos elementos enquanto remove elementos antigos
        localStorage.setItem("tbClientes", JSON.stringify(tbClientes));
        alert("Registro Excluido com Sucesso!")
     }
     function GetCliente(propriedade, valor){
		var cli = null;
        for (var item in tbClientes) {
            var i = JSON.parse(tbClientes[item]);
            if (i[propriedade] == valor)
                cli = i;
        }
        return cli;
	}

	Listar();
    //O método bind() cria uma nova função, quando invocado, tem o this configurado para o valor fornecido
    $("#frmCadastro").bind("submit",function(){
		if(operacoes == "A")
			return Adicionar();
		else
			return Editar();		
	});

	$(".btnEditar").bind("click", function(){
		operacoes = "E";
		indice_selecionado = parseInt($(this).attr("alt"));
		var cli = JSON.parse(tbClientes[indice_selecionado]);
		$("#txtCodigo").val(cli.Codigo);
		$("#txtNome").val(cli.Nome);
		$("#txtFone").val(cli.Telefone);
		$("#txtEmail").val(cli.Email);
		$("#txtCodigo").attr("readonly","readonly");
		$("#txtNome").focus();
	});

	$(".btnExcluir").bind("click", function(){
		indice_selecionado = parseInt($(this).attr("alt"));
		Excluir();
		Listar();
	});
});