<%-- 
    Document   : exibeDados
    Created on : 28/08/2022, 19:03:09
    Author     : User
--%>

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
               <td class="alinharDireita">Numero:</td>
               <td>${requestScope.dadosObtido.numero}</td>
               </tr>
           <tr>
               <td class="alinharDireita">Titulo:</td>
               <td>${requestScope.dadosObtido.titulo}</td>
               </tr>
           <tr>
               <td class="alinharDireita">Ator/Atriz Principal:</td>
               <td>${requestScope.dadosObtido.atorP}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Ator/Atriz Coadjuvante:</td>
               <td>${requestScope.dadosObtido.atorC}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Diretor/Diretora:</td>
               <td>${requestScope.dadosObtido.diretor}</td>
               </tr>
            <tr>
               <td class="alinharDireita">Ano de Lançamento:</td>
               <td>${requestScope.dadosObtido.ano}</td>
               </tr>  
            <tr>
               
    </body>
</html>