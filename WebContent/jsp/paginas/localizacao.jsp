<%@page import="br.com.sb.entidade.Localizacao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<script type="text/javascript">

	function cadastrarLocalizacao(){
		
		document.frmLocalizacao.action = "/SchoolBoc/LocalizacaoController";
		document.frmLocalizacao.pagina.value = "carregarCadastroLocalizacao";
		document.frmLocalizacao.submit();
		
	}

</script>


<%
	ArrayList<Localizacao> listaLocalizacoes = (ArrayList<Localizacao>)request.getAttribute("listaLocalizacoes");
%>

<h1>Localizações</h1>
<form name="frmLocalizacao">
	<input type="hidden" id="pagina" name="pagina" value="">
	<p>	<input type="button" value="Cadastrar" 	onclick="cadastrarLocalizacao();"></p>
	<table border="0"class="bordered" >
        <thead>
        	<tr >
				<th width="80%">Nome</th>
				<th>Operções</th>
			</tr>
		</thead>
		
			<%
				if(!listaLocalizacoes.isEmpty()){
					for(int i=0; i < listaLocalizacoes.size(); i ++){
						Localizacao localizacao = listaLocalizacoes.get(i);
						%>
						<tr>
							<td>  
								<a href="<%= request.getContextPath() %>/LocalizacaoController?pagina=carregarAlterarLocalizacao&idLocalizacao=<%=localizacao.getIdLocalizacao()%>"> <%= localizacao.getNome() %> </a>	
							</td>
							<td>
								<a href="<%= request.getContextPath() %>/LocalizacaoController?pagina=excluirLocalizacao&idLocalizacao=<%=localizacao.getIdLocalizacao()%>"> Excluir </a> 
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
