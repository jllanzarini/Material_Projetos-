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
            Telefone : $("txtFone").val(),
            Email    : $("txtEmail").val()
        });

        tbClientes.push(cliente);
        localStorage.setItem("tbClientes", JSON.stringify(tbClientes));
        alert("Cadastro Efetuado com sucesso!");
        return true;
    }
});