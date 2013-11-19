<%@page import="br.com.sb.entidade.Usuario"%>
<%@page import="br.com.sb.entidade.Instituicao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.sb.entidade.Cargo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	ArrayList<Usuario> listaUsuarios	= (ArrayList<Usuario>)request.getAttribute("listaUsuarios"); 
	Instituicao instituicao 			= (Instituicao)request.getAttribute("instituicao");
	
	if(instituicao == null){
		instituicao = new Instituicao();
	}
%>

<script>

	function cadastrarInstituicao(){
		document.frmInstituicao.action = "<%= request.getContextPath() %>/InstituicaoController";
		document.frmInstituicao.pagina.value = "cadastrarInstituicao";
		document.frmInstituicao.submit();
	}
	
	function alterarInstituicao(){
		document.frmInstituicao.action = "<%= request.getContextPath() %>/InstituicaoController";
		document.frmInstituicao.pagina.value = "alterarInstituicao";
		document.frmInstituicao.submit();
	}

</script>


	<h1>Instituição - Add/Edit</h1>
	<form name="frmInstituicao">
		<input type="hidden" name="pagina" value=""/>
		<input type="hidden" name="idInstituicao" 			value="<%= instituicao.getIdInstituicao() %>"/>
		<input type="hidden" name="idInstituicaoExclusao"	value=""/>
		<table>
			<tr>
				<td> Nome: </td>
				<td> <input type="text" name="nome" value="<%= instituicao.getNome() %>"/>
			</tr>

			<tr>
				<td>Usuario: </td>
				<td> 
					<select name="idUsuario">
						<option>Pick one</option>
					<%
						Integer idUsuario = (Integer)request.getAttribute("idUsuarioEscolhido");
						if(idUsuario == null){
							idUsuario = new Integer(0);
						}
						
						for(int i=0; i < listaUsuarios.size(); i ++){
							Usuario u = listaUsuarios.get(i);
							
							if(!u.getIdUsuario().equals(idUsuario)){
								%>
									<option value="<%= u.getIdUsuario() %>"> <%= u.getNome() %> </option>
								<%
							}else{
								%>
									<option value="<%= u.getIdUsuario() %>" selected="selected"> <%= u.getNome() %> </option>
								<%
							}
						}
					%>
					</select>
					
				</td>
			</tr>

			<tr>
				<td> Estado: </td>
				<td> <input type="text" name="estado" value="<%= instituicao.getEstado() %>"/>
			</tr>
			
			<tr>
				<td> Endereco: </td>
				<td> <input type="text" name="endereco" value="<%= instituicao.getEndereco() %>"/>
			</tr>
			
			<tr>
				<td> Telefone: </td>
				<td> <input type="text" name="telefone" value="<%= instituicao.getTelefone() %>"/>
			</tr>		
				
			<tr>
				<td> Email: </td>
				<td> <input type="text" name="email" value="<%= instituicao.getEmail() %>"/>
			</tr>
		
			<tr>
				<% if(instituicao.getIdInstituicao() == null){ %>
					<td> <input type="submit" value="Cadastrar" onclick="cadastrarInstituicao();"> </td>
				<%}else{ %>
					<td> <input type="submit" value="Alterar" onclick="alterarInstituicao();"></td>
				<%} %>
				
			</tr>
		</table>
	</form>
