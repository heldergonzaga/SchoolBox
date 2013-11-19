<%@page import="br.com.sb.entidade.Localizacao"%>
<%@page import="br.com.sb.entidade.Usuario"%>
<%@page import="br.com.sb.entidade.Instituicao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.sb.entidade.Cargo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	ArrayList<Instituicao> listaInstituicoes	= (ArrayList<Instituicao>)request.getAttribute("listaInstituicoes"); 
	Localizacao localizacao 					= (Localizacao)request.getAttribute("localizacao");
	
	if(localizacao == null){
		localizacao = new Localizacao();
	}
%>





<script type="text/javascript">

	function cadastrarLocalizacao(){
		document.frmLocalizacao.action = "<%= request.getContextPath() %>/LocalizacaoController";
		document.frmLocalizacao.pagina.value = "cadastrarLocalizacao";
		document.frmLocalizacao.submit();
	}
	
	function alterarLocalizacao(){
		document.frmLocalizacao.action = "<%= request.getContextPath() %>/LocalizacaoController";
		document.frmLocalizacao.pagina.value = "alterarLocalizacao";
		document.frmLocalizacao.submit();
	}

</script>

<h1>Localizacao - Add/Edit</h1>
	<form name="frmLocalizacao">
		<input type="hidden" name="pagina" value=""/>
		<input type="hidden" name="idLocalizacao" 			value="<%= localizacao.getIdLocalizacao() %>"/>
		<input type="hidden" name="idLocalizacaoExclusao"	value=""/>
		
		<table>
			<tr>
				<td> Nome: </td>
				<td> <input type="text" name="nome" value="<%= localizacao.getNome() %>"/>
			</tr>

			<tr>
				<td>Instituição: </td> 
				<td> 
					<select name="idInstituicao">
						<option>Selecione</option> 
					<%
						Integer idInstituicao = (Integer)request.getAttribute("idInstituicaoEscolhida");
					
						if(idInstituicao == null){
							idInstituicao = new Integer(0);
						}
						
						for(int i=0; i < listaInstituicoes.size(); i ++){
							Instituicao instituicao = listaInstituicoes.get(i);
							
							if(!instituicao.getIdInstituicao().equals(idInstituicao)){
								%>
									<option value="<%= instituicao.getIdInstituicao() %>"> <%= instituicao.getNome() %> </option>
								<%
							}else{
								%>
									<option value="<%= instituicao.getIdInstituicao() %>" selected="selected"> <%= instituicao.getNome() %> </option>
								<%
							}
						}
					%>
					</select>
					
				</td>
			</tr>

			<tr>
				<% if(localizacao.getIdLocalizacao() == null){ %>
					<td> <input type="submit" value="Cadastrar" onclick="cadastrarLocalizacao();"> </td>
				<%}else{ %>
					<td> <input type="submit" value="Alterar" onclick="alterarLocalizacao();"></td>
				<%} %>
				
			</tr>
		</table>
	</form>
