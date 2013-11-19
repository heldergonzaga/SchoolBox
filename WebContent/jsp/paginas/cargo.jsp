<%@page import="java.util.ArrayList"%>
<%@page import="br.com.sb.entidade.Cargo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<script type="text/javascript">

function cadastrarCargo(){
	
	document.frmCargo.action = "<%= request.getContextPath() %>/CargoController";
	document.frmCargo.pagina.value = "carregarCadastroCargo";
	document.frmCargo.submit();
	
}

</script>


<%
	ArrayList<Cargo> listaCargos = (ArrayList<Cargo>)request.getAttribute("listaCargos");
%>

<h1>Cargo</h1> 
<form name="frmCargo">
	<input type="hidden" id="pagina" name="pagina" value="">
	
	<p>
		<input type="button" value="Novo Cargo" onclick="cadastrarCargo();">
	</p>
	<table border="0" class="bordered" >
        <thead>
        	<tr >
				<th>Titulo</th>
				<th>op</th>
			</tr>
		</thead>
			<%
				if(!listaCargos.isEmpty()){
					for(int i=0; i < listaCargos.size(); i ++){
						Cargo cargo = listaCargos.get(i);
						%>
						<tr>
							<td>  
								<a href="<%= request.getContextPath() %>/CargoController?pagina=carregarAlterarCargo&idCargo=<%=cargo.getIdCargo()%>"> <%= cargo.getTitulo() %> </a>	
							</td>
							<td>
								<a href="<%= request.getContextPath() %>/CargoController?pagina=excluirCargo&idCargo=<%=cargo.getIdCargo()%>"> Excluir </a> 
							</td>	
						</tr>
						<%
					}
				}else{
					%>
					<tr> 
						<td> Não há registros...</td>
					</tr>					
				<%
				}
			%>
	</table>
	
	
</form>
