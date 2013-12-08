<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="../../inc/dependencia.jsp" %>



<!doctype html>
<!--[if lt IE 9]><html class="ie"><![endif]-->
<!--[if gte IE 9]><!--><html><!--<![endif]-->
	
	<head>
		<%@include file="../../inc/incHead.jsp" %>
	</head>
	
	<body lang="pt-br">
	
	<div class="geral">
		<div class="colunaTopo">
			<div class="secao">
				<span class="logo"><img src="<%=ctx%>/docs/images/logo.jpg"/></span>	
			</div>
			<div class="secao">
				<div class="conteudo">
					<div id="carregando" style="display:none;"><img alt=" " src="/SchoolBox/docs/images/Carregando.gif"> Carregando ...</div> 
					<span id="mensagensSistema">
						<%@include file="../../inc/incMensagem.jsp" %>
					</span>
					
					<jsp:include page="<%=pathPagina%>" >
						<jsp:param name="mensagem"  value=" " />
					</jsp:include>
				</div>
			</div>
		</div>
		<div class="colunaBase"> 
			Todos os direitos reservados	
		</div>
	</div>
	<%@include file="../../inc/incEndBody.jsp" %>
	</body>
	
</html>
