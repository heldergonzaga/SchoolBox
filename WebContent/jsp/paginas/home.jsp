<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li> <a href="<%= request.getContextPath() %>/CargoController?pagina=carregarCargo"> Cargo</a> </li>
		<li> <a href="<%= request.getContextPath() %>/ContratoController?pagina=carregarContrato"> Contrato</a> </li>
		<li> <a href="<%= request.getContextPath() %>/InstituicaoController?pagina=carregarInstituicao"> Instituicao</a> </li>
		<li> <a href="<%= request.getContextPath() %>/LocalizacaoController?pagina=carregarLocalizacao"> Localizacao</a> </li>
		<li> <a href="<%= request.getContextPath() %>/BoxController?pagina=carregarBox"> Box</a> </li>
	</ul>
</body>
</html>