<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="br.com.sb.entidade.Localizacao"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<option value="" >Selecione...  </option>
<c:forEach items="${localizacoes}" var="localizacao">
	<option value="<c:out value="${localizacao.idLocalizacao}"/>"><c:out value="${localizacao.nome}"/></option> 
</c:forEach>
