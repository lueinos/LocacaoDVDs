<%-- 
    Document   : novo
    Created on : 29/09/2022, 19:33:36
    Author     : Octavio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
  <head>
    <title>Novo Ator</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

    <h1>Novo Ator</h1>

    <form method="post" action="${cp}/processaAtor">

      <input name="acao" type="hidden" value="inserir"/>

      <table>
        <tr>
          <td class="alinharDireita">Nome:</td>
          <td>
            <input name="nome"
                   type="text"
                   size="30"
                   maxlength="45"
                   required/>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">Sobrenome:</td>
          <td>
            <input name="sobrenome"
                   type="text"
                   size="30"
                   maxlength="45"
                   required>
          </td>
        </tr>
        <tr>
          <td class="alinharDireita">Data de Estreia:</td>
          <td>
            <input name="dataEstreia"
                   type="date"
                   size="8"
                   placeholder="yyyy-MM-dddd"
                   required/>
          </td>
        </tr>
        <tr>
          <td>
            <a href="${cp}/formularios/ator/listagem.jsp">
              Voltar
            </a>
          </td>
          <td class="alinharDireita">
            <input type="submit" value="Salvar"/>
          </td>
        </tr>
      </table>

    </form>

  </body>

</html>
