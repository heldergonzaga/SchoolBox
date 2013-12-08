<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="inc/dependencia.jsp" %>



<!doctype html>
<!--[if lt IE 9]><html class="ie"><![endif]-->
<!--[if gte IE 9]><!--><html><!--<![endif]-->
	
	<head>
		
		<%@include file="inc/incHead.jsp" %>
	</head>
	
	<body lang="pt-br">
	<div id="carregando" style="display:none;" > <img alt=" " src="/SchoolBox/docs/images/Carregando.gif"> Carregando ...</div> 
	<div class="geral">
		<div class="colunaTopo">
			<div class="secao">
					<span class="logo"><img src="<%=ctx%>/docs/images/logo.jpg"/></span>	
					<span class="logado">Sistema Schook Box, Seja bem vindo , <b>Fulano de tal</b> . </span>
			</div>
		</div>
		<div class="colunaEsquerda">
			<%@include file="inc/incMenu.jsp" %>
			
			<!--  div class="secao">
				<h1>Mensagens do sistema</h1>
					<div class="conteudo">
					teste 
					</div>
			</div-->
		</div>
		<div class="colunaCentro">
		
			<div class="secao">
				<div class="conteudo">
						<jsp:include page="<%=pathPagina%>" >
						<jsp:param name="mensagem"  value="teste" />
					</jsp:include>
				</div>
			</div>
			
		
			
		</div>
		
		
		
		
		<div class="colunaBase"> 
		
			Todos os direitos reservados	
				
		</div>
	</div>
		
	<%@include file="inc/incEndBody.jsp" %>
	</body>
	
</html>
