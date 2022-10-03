$(function(){
    var operacao = "A"; //"A" = Adição 
    var indice_selecionado = -1;
    var tbClientes = localStorage.getItem("tbClientes"); //Recuperar os dados Armazenados
    tbClientes = JSON.parse(tbClientes); //converte a String para objeto

    if(tbClientes == null) // Caso não exista conteudo, iniciamos umvetor vazio!
        tbClientes = [];
        
        //Adiciona novo registro
        function adicionar(){
            var cli = GetCliente("Codigo", $("#txtCodigo").val());
            if(cli != null){ //Verifica se o codigo já está cadastrado
                alert("Código já cadastrado!");
                return;
            }
            var cliente = JSON.stringify({
                Codigo   : $("#txtCodigo").val(),
                Nome     : $("#txtNome").val(),
                Telefone : $("#txtTelefone").val(),
                Email    : $("#txtEmail").val()

            });

            tbClientes.push(cliente);
            localStorage.setItem("tbClientes", JSON.stringify(tbClientes));

            alert("Registro cadastrado com sucesso!");
            return true;

        }

        //Edita registro cadastrado
        function Editar(){
            tbClientes[indice_selecionado] = JSON.stringify({
                Codigo   : $("#txtCodigo").val(),
				Nome     : $("#txtNome").val(),
				Telefone : $("#txtTelefone").val(),
				Email    : $("#txtEmail").val()
            });
            localStorage.setItem("tbClientes", JSON.stringify(tbClientes));
            alert("Informações editadas com sucesso!")
            operacao = "A";
            return true;
        }

        //Listar conteudo
        function Listar(){
            $("#tblListar").html("");
            $("#tblListar").html(
                "<thead>" + "<tr>" + "<th></th>" + 
                "<th>Código</th>" +
                "<th>Nome</th>" +
                "<th>Telefone</th>" +
                "<th>Email</th>" +
                "</tr>" +
                "</thead>" +
                "<tbody>" +
                "</tbody>"
            );

            //Percorre a tabela adicionando um a um
            for(var i in tbClientes){
                var cli = JSON.parse(tbClientes[i]);
                        $("#tblListar tbody").append("<tr>"+ //The Element.append() method inserts a set of Node objects or string
                        "	<td><img src='img/edit.png' alt='"+i+"' class='btnEditar'/><img src='img/delete.png' alt='"+i+"' class='btnExcluir'/></td>" + 
                        "	<td>"+cli.Codigo+"</td>" + 
                        "	<td>"+cli.Nome+"</td>" + 
                        "	<td>"+cli.Telefone+"</td>" + 
                        "	<td>"+cli.Email+"</td>" + 
                        "</tr>");
            }
        }

        //Função que exclui o registro
        function Excluir(){
            indice_selecionado = parseInt($(this).attr("alt"));
            tbClientes.splice(indice_selecionado, 1);
            localStorage.setItem("tbClientes", JSON.stringify(tbClientes));
            alert("Registro excluído.");
        }

        function GetCliente(propriedade, valor){
            var cli = null;
            for(var item in tbClientes){
                var i = JSON.parse(tbClientes[item]);
                if(i[propriedade]== valor)
                cli = i;
            }
            return cli;
        }
        Listar();

        $("#frmCadastro").bind("submit", function(){
            if (operacao =="A")
                return adicionar();
            else
                return Editar();
        });

        $(".btnEditar").bind("click", function(){
            operacao = "E";
            indice_selecionado = parseInt($(this).attr("alt"));
            var cli = JSON.parse(tbClientes[indice_selecionado]);
                $("#txtCodigo").val(cli.Codigo);
                $("#txtNome").val(cli.Nome);
                $("#txtTelefone").val(cli.Telefone);
                $("#txtEmail").val(cli.Email);
                $("#txtCodigo").attr("readonly", "readonly");
                $("#txtNome").focus();            
        });

        $(".btnExcluir").bind("click", function(){
            indice_selecionado = parseInt($(this).attr("alt"));
            Excluir();
            Listar();
        });
});