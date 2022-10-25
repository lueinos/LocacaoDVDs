<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>

<html>
    <head>
        <title>Sistema para Cadastro de Dvds</title>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet"
              href="${cp}/css/estilos.css"/>
    </head>

    <body>

        <h1>Sistema para Cadastro de Dvds</h1>
        
        <p>
            <a href="${cp}/formularios/genero/listagem.jsp">Genero</a>
        </p>
        <p>
            <a href="${cp}/formularios/ator/listagem.jsp">Ator</a>
        </p>
        <p>
            <a href="${cp}/formularios/classificacaoEtaria/listagem.jsp">Classificação etária</a>
        </p>
        <p>
            <a href="${cp}/formularios/dvd/listagem.jsp">Dvd</a>
        </p>
    </body>
</html>
