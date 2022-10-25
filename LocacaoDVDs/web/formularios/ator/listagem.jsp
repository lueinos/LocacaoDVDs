<%-- 
    Document   : listagem
    Created on : 29/09/2022, 19:33:28
    Author     : Octavio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<c:set var="prefixo" value="processaAtor?acao=preparar"/>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
  <head>
    <title>Atores Cadastrados</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

    <h1>Atores Cadastrados</h1>

    <p>
      <a href="${cp}/formularios/ator/novo.jsp">
        Novo Ator
      </a>
    </p>

    <table class="tabelaListagem">
      <thead>
        <tr>
          <th>Id</th>
          <th>Nome</th>
          <th>Sobrenome</th>
          <th>Data Estreia</th>
          <th>Alterar</th>
          <th>Excluir</th>
        </tr>
      </thead>
      <tbody>

        <jsp:useBean 
            id="servicos"
            scope="page"
            class="locacaodvds.servicos.AtorServices"/>

        <c:forEach items="${servicos.todos}" var="ator">
          <tr>
            <td>${ator.id}</td>
            <td>${ator.nome}</td>
            <td>${ator.sobreNome}</td>
            <td>
                <fmt:formatDate
                    pattern="yyyy-MM-dd"
                    value="${ator.dataEstreia}"/>
            </td>
            <td>
              <a href="${cp}/${prefixo}Alteracao&id=${ator.id}">
                Alterar
              </a>
            </td>
            <td>
              <a href="${cp}/${prefixo}Exclusao&id=${ator.id}">
                Excluir
              </a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
      
    </table>

    <p>
      <a href="${cp}/formularios/ator/novo.jsp">
        Novo Ator
      </a>
    </p>

    <p><a href="${cp}/index.jsp">Tela Principal</a></p>

  </body>

</html>
