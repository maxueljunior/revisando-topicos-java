<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String nomeEmpresa = (String) request.getAttribute("empresa");
%>	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>Empresa <%=nomeEmpresa %></p>
	
</body>
</html>