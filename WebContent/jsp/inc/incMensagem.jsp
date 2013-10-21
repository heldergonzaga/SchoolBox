<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String mensagemErro = (String) request.getAttribute("mensagemErro");
String mensagemSucesso = (String) request.getAttribute("mensagemSucesso");

if(mensagemErro != null && !mensagemErro.equals("")){ %>
	<span class="mensagemErro">mensagem de erro</span>
<%} 
if(mensagemSucesso != null && !mensagemSucesso.equals("")){ %>
	<span class="mensagemSucesso">mensagem de sucesso</span>
<%} %>