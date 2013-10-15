<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%! String ctx ; %>
 <%
 	ctx = request.getContextPath();
	String pathPagina = "paginas/index.jsp";

 	if(request.getAttribute("pathPagina")!= null ){
 		pathPagina	= (String)request.getAttribute("pathPagina");
 	}

 %>
