<%@page import="br.com.sb.entidade.Instituicao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<script type="text/javascript">

	function cadastrarInstituicao(){
		
		document.frmInstituicao.action = "<%= request.getContextPath() %>/InstituicaoController";
		document.frmInstituicao.pagina.value = "carregarCadastroInstituicao";
		document.frmInstituicao.submit();
		
	}

</script>

<%
	ArrayList<Instituicao> listaInstituicoes = (ArrayList<Instituicao>)request.getAttribute("listaInstituicoes");
%>

<h1>Instituição</h1>
<form name="frmInstituicao">
	<input type="hidden" id="pagina" name="pagina" value="">
	<p>	<input type="button" value="Cadastrar" 	onclick="cadastrarInstituicao();"></p>
 	<table border="0" class="bordered" >
        <thead>
        	<tr >
				<th width="80%">Nome</th>
				<th>operacões</th>
			</tr>
		</thead>
			<%
				for(int i=0; i < listaInstituicoes.size(); i ++){
					Instituicao instituicao = listaInstituicoes.get(i);
					%>
					<tr>
						<td>  
							<a href="<%= request.getContextPath() %>/InstituicaoController?pagina=carregarAlterarInstituicao&idInstituicao=<%=instituicao.getIdInstituicao()%>"> <%= instituicao.getNome() %> </a>	
						</td>
						<td>
							<a href="<%= request.getContextPath() %>/InstituicaoController?pagina=excluirInstituicao&idInstituicao=<%=instituicao.getIdInstituicao()%>"> Excluir </a> 
						</td>
					</tr>
					<%
				}
			%>
	</table>
	
	
</form>
