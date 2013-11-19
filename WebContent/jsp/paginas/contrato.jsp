<%@page import="br.com.sb.entidade.Contrato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>




<script type="text/javascript">

function cadastrarContrato(){
	
	document.frmContrato.action = "<%= request.getContextPath() %>/ContratoController";
	document.frmContrato.pagina.value = "carregarCadastroContrato";
	document.frmContrato.submit();
	
}

</script>


<%
	ArrayList<Contrato> listaContratos = (ArrayList<Contrato>)request.getAttribute("listaContratos");
%>
<h1>Contratos</h1>

<form name="frmContrato" method="post">
	<input type="hidden" id="pagina" name="pagina" value="">

	<p><input type="button" value="Cadastrar" onclick="cadastrarContrato();"></p>
	<table class="bordered" >
	 	<thead>
        	<tr >
				<th width="70%">Cliente</th>
					<th>Renovação Automatica</th>
				<th>Operções</th>
			</tr>
		</thead>
			<%
				if(!listaContratos.isEmpty()){
					for(int i=0; i < listaContratos.size(); i ++){
						Contrato contrato = listaContratos.get(i);
						%>
						<tr>
							<td>  
								<a href="<%= request.getContextPath() %>/ContratoController?pagina=carregarAlterarContrato&idContrato=<%=contrato.getIdContrato()%>"> <%= contrato.getUsuario().getNome()  %>  <%= contrato.getUsuario().getSobrenome()  %> </a>	
							</td>
							<td>  
								<%= contrato.getRenovacaoAuto()%> 	
							</td>
							<td>
								<a href="<%= request.getContextPath() %>/ContratoController?pagina=excluirContrato&idContrato=<%=contrato.getIdContrato()%>"> Encerrar </a> 
							</td>
						</tr>
						<%
					}
					
					
				}else{
					%>
						<tr> 
							<td> Não há registros...</td>
							<td> </td>
						</tr>					
					<%
				}
			%>
	</table>
	
	
				
	
</form>
