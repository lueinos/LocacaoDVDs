<%-- 
    Document   : novo
    Created on : 29/09/2022, 19:34:23
    Author     : Octavio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
  <head>
    <title>Novo Cliente</title>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
          
          href="${cp}/css/estilos.css"/>
  </head>

  <body>

    <h1>Novo Cliente</h1>

    <form method="post" action="${cp}/processaDvd">

      <input name="acao" type="hidden" value="inserir"/>

      <table>
        <tr>
          <td class="alinharDireita">Titulo:</td>
          <td>
            <input name="titulo"
                   type="text"
                   size="70"
                   maxlength="100"
                   required/>
          </td>
        </tr>
        
         <tr>
          <td class="alinharDireita">Ano de Lançamento:</td>
          <td>
            <input name="anoLancamento"
                   type="number"
                    min="0" 
                    max="9999"
                   required/>
          </td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Ator Principal:</td>
          <td>

            <jsp:useBean 
                id="servicos" 
                scope="page" 
                class="locacaodvds.servicos.AtorServices"/>

            <select name="idAtorPrincipal" required>
              <c:forEach items="${servicos.todos}" var="ator">
                <option value="${ator.id}">
                  ${ator.nome} ${#160} ${ator.sobreNome}
                </option>
              </c:forEach>
            </select>

          </td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Ator Coadjuvante:</td>
          <td>

            <jsp:useBean 
                id="servicos2" 
                scope="page" 
                class="locacaodvds.servicos.AtorServices"/>

            <select name="idAtorCoadjuvante" required>
              <c:forEach items="${servicos.todos}" var="atorC">
                <option value="${atorC.id}">
                  ${atorC.nome} ${#160} ${atorC.sobreNome}
                </option>
              </c:forEach>
            </select>

          </td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Data de Lancamento:</td>
          <td>
            <input name="dataLancamento"
                   type="date"
                   size="8"
                   placeholder="yyyy/MM/dd"
                   required/>
          </td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Duração em Minutos:</td>
          <td>
            <input name="duracaoMinutos"
                    type="number"
                    min="0" 
                    max="999"
                   required/>
          </td>
        </tr>
        
        <tr>
          <td class="alinharDireita">Classificação Etária:</td>
          <td>

            <jsp:useBean 
                id="servicos3" 
                scope="page" 
                class="locacaodvds.servicos.ClassificacaoEtariaServices"/>

            <select name="idClassificacaoEtaria" required>
              <c:forEach items="${servicos3.todos}" var="classificacaoEtaria">
                <option value="${classificacaoEtaria.id}">
                  ${classificacaoEtaria.descricao}
                </option>
              </c:forEach>
            </select>

          </td>
        </tr>
        <tr>
          <td class="alinharDireita">Genero:</td>
          <td>

            <jsp:useBean 
                id="servicos4" 
                scope="page" 
                class="locacaodvds.servicos.GeneroServices"/>

            <select name="idGenero" required>
              <c:forEach items="${servicos4.todos}" var="genero">
                <option value="${genero.id}">
                  ${genero.descricao}
                </option>
              </c:forEach>
            </select>

          </td>
        </tr>
        
        <tr>
          <td>
            <a href="${cp}/formularios/dvd/listagem.jsp">
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
