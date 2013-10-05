<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="inc/dependencia.jsp" %>
<!doctype html>
<html lang="pt-Br">
<head>
	<%@include file="inc/incHead.jsp" %>
</head>
<body>
<div class="geral">
	<div class="colunaTopo">
		Sistema Schook Box, Seja bem vindo Fulano de tal.  
	</div>
	
	<div class="colunaEsquerda">
		<%@include file="inc/incMenu.jsp" %>
	</div>
	
	<div class="colunaCentro">
		<jsp:include page="<%=urlPagina%>" >
			<jsp:param name="mensagem"  value="teste" />
		</jsp:include>
	</div>
	
	<div class="colunaDieita">
		Mensagens do sistema
	</div>
	
	
	<div class="colunaBase">
		
	</div>
</div>
<%@include file="inc/incEndBody.jsp" %>
</body>
</html>
