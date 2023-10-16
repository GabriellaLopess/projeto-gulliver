<%@ page language="java" 
     contentType="text/html; charset=UTF-8" 
       pageEncoding="UTF-8"%>
       

<jsp:useBean id="Mensagem" type="java.lang.String" 
              scope="request" />
              
<!DOCTYPE html>
<html>
<head>
	<title>.: Erro :.</title>
</head>
<body>
	<h1>Erro!</h1>
	<hr>
	Mensagem de Erro: <c:out value="${Mensagem}" />
	<br>
	<a href="./index.jsp">Voltar ao Inicio</a>
</body>
</html>