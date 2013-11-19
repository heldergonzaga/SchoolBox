<%@page import="br.com.sb.entidade.Box"%>
<%@page import="br.com.sb.entidade.Localizacao"%>
<%@page import="br.com.sb.entidade.Usuario"%>
<%@page import="br.com.sb.entidade.Instituicao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.sb.entidade.Cargo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	ArrayList<Localizacao> listaLocalizacoes	= (ArrayList<Localizacao>)request.getAttribute("listaLocalizacoes"); 
	Box box 									= (Box)request.getAttribute("box");
	
	if(box == null){
		box = new Box();
	}
%>



<script type="text/javascript">

	function cadastrarBox(){
		document.frmBox.action = "<%= request.getContextPath() %>/BoxController";
		document.frmBox.pagina.value = "cadastrarBox";
		document.frmBox.submit();
	}
	
	function alterarBox(){
		document.frmBox.action = "<%= request.getContextPath() %>/BoxController";
		document.frmBox.pagina.value = "alterarBox";
		document.frmBox.submit();
	}

</script>

<h1>Box Cadastro</h1>
	<form name="frmBox">
		<input type="hidden" name="pagina" value=""/>
		<input type="hidden" name="idBox" 			value="<%= box.getIdBox() %>"/>
		<input type="hidden" name="idBoxExclusao"	value=""/>
		<table>
			<tr>
				<td>Localizacao: </td>
				<td> 
					<select name="idLocalizacao">
						<option>Pick one</option>
					<%
						Integer idLocalizacao = (Integer)request.getAttribute("idLocalizacaoEscolhida");
					
						if(idLocalizacao == null){
							idLocalizacao = new Integer(0);
						}
						
						for(int i=0; i < listaLocalizacoes.size(); i ++){
							Localizacao localizacao = listaLocalizacoes.get(i);
							
							if(!localizacao.getIdLocalizacao().equals(idLocalizacao)){
								%>
									<option value="<%= localizacao.getIdLocalizacao() %>"> <%= localizacao.getNome() %> </option>
								<%
							}else{
								%>
									<option value="<%= localizacao.getIdLocalizacao() %>" selected="selected"> <%= localizacao.getNome() %> </option>
								<%
							}
						}
					%>
					</select>
					
				</td>
			</tr>
			
			<tr>
				<td>Numero: </td>
				<td> 
					<input type="text" name="numero" value="<%= box.getNumero()%>">
					 
				</td>
			</tr>
			
			<tr>
				<td>Senha: </td>
				<td> 
					<input type="text" name="senha" value="<%= box.getSenha()%>">
					 
				</td>
			</tr>
			
			<tr>
				<% if(box.getIdBox() == null){ %>
					<td> <input type="submit" value="Cadastrar" onclick="cadastrarBox();"> </td>
				<%}else{ %>
					<td> <input type="submit" value="Alterar" onclick="alterarBox();"></td>
				<%} %>
				
			</tr>
		</table>
	</form>
