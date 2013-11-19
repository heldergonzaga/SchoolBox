<%@page import="java.util.ArrayList"%>
<%@page import="br.com.sb.entidade.Cargo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% 
	Cargo cargo = (Cargo)request.getAttribute("cargo"); 
	
	if(cargo == null){
		cargo = new Cargo();
	}
%>


<script type="text/javascript">

	function cadastrarCargo(){
		document.frmCargo.action = "<%= request.getContextPath() %>/CargoController";
		document.frmCargo.pagina.value = "cadastrarCargo";
		document.frmCargo.submit();
	}
	
	function alterarCargo(){
		document.frmCargo.action = "<%= request.getContextPath() %>/CargoController";
		document.frmCargo.pagina.value = "alterarCargo";
		document.frmCargo.submit();
	}
</script>
<h1>Cargo - AddEdit </h1>

	<form name="frmCargo">
		<input type="hidden" name="pagina" value=""/>
		<input type="hidden" name="idCargo" value="<%=cargo.getIdCargo() %>"/>
		<input type="hidden" name="idCargoExclusao"	value=""/>
		<table>
			<tr>
				<td> Titulo: </td>
				<td> <input type="text" name="titulo" value="<%= cargo.getTitulo() %>"/>
			</tr>
		
			<tr>
				<% if(cargo.getIdCargo() == null){ %>
					<td> <input type="submit" value="Cadastrar" onclick="cadastrarCargo();"> </td>
				<%}else{ %>
					<td> <input type="submit" value="Alterar" onclick="alterarCargo();"></td>
				<%} %>
				
			</tr>
		</table>
	</form>
