<%@page import="br.com.sb.entidade.Box"%>
<%@page import="br.com.sb.entidade.Localizacao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<script type="text/javascript"> 

	function cadastrarBox(){
		
		document.frmBox.action = "<%= request.getContextPath() %>/BoxController";
		document.frmBox.pagina.value = "carregarCadastroBox";
		document.frmBox.submit();
		
	}

</script>

<h1>Box</h1>
<%
	ArrayList<Box> listaBoxs = (ArrayList<Box>)request.getAttribute("listaBoxs");
%>

<form name="frmBox">
	<input type="hidden" id="pagina" name="pagina" value="">
	<p><input type="button" value="Cadastrar" 	onclick="cadastrarBox();"></p>
	<table border="0" class="bordered" >
        <thead>
        	<tr >
				<th>Nome</th>
				<th>Operacao</th>
			</tr>
		</thead>
		
			<%
				if(!listaBoxs.isEmpty()){
					for(int i=0; i < listaBoxs.size(); i ++){
						Box box = listaBoxs.get(i);
						%>
						<tr>
							<td>  
								<a href="<%= request.getContextPath() %>/BoxController?pagina=carregarAlterarBox&idBox=<%=box.getIdBox()%>"> <%= box.getNumero() %> </a>	
							</td>
							<td>
								<a href="<%= request.getContextPath() %>/BoxController?pagina=excluirBox&idBox=<%=box.getIdBox()%>"> Excluir </a> 
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
