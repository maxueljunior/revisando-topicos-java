<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, br.com.leuxam.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
	
	<c:import url="logout-parcial.jsp"/>
	
	Usuario logado: ${usuarioLogado.login}
	
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>
				${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura}" pattern="dd/MM/yyyy"/>
				<a href="/gerenciador/entrada?acao=MostraEmpresa&id=${empresa.id}">Atualiza</a>
				<a href="/gerenciador/entrada?acao=RemovaEmpresa&id=${empresa.id}">Remove</a>
			</li>	
		</c:forEach>
	</ul>
</body>
</html>