

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .alinharDireita {
                text-align: right;
            }
        </style>
    </head>
    <body>
        <div>
        <h1>Dados Obtidos</h1>
        
        <table>
          <tr>
               <td class="alinharDireita">Nome:</td>
               <td>${requestScope.dadosObtido.nome}</td>
               </tr>
           <tr>
               <td class="alinharDireita">Sobrenome:</td>
               <td>${requestScope.dadosObtido.sobrenome}</td>
               </tr>
           <tr>
               <td class="alinharDireita">CPF:</td>
               <td>${requestScope.dadosObtido.cpf}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Data de Nascimento:</td>
               <td>${requestScope.dadosObtido.data}</td>
               </tr>
            <tr>
               <td class="alinharDireita">E-mail:</td>
               <td>${requestScope.dadosObtido.email}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Logradouro:</td>
               <td>${requestScope.dadosObtido.logradouro}</td>
               </tr>  
            <tr>
               <td class="alinharDireita">Numero:</td>
               <td>${requestScope.dadosObtido.numero}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Complemento:</td>
               <td>${requestScope.dadosObtido.complemento}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Cidade:</td>
               <td>${requestScope.dadosObtido.cidade}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Estado:</td>
               <td>${requestScope.dadosObtido.estado}</td>
               </tr>
            <tr>
               <td class="alinharDireita">CEP:</td>
               <td>${requestScope.dadosObtido.cep}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Sexo:</td>
               <td>${requestScope.dadosObtido.sexo}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Possui Filho:</td>
               <td>${requestScope.dadosObtido.filho}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Observacoes:</td>
               <td>${requestScope.dadosObtido.observacoes}</td>
               </tr>  
           
    </body>
</html>
