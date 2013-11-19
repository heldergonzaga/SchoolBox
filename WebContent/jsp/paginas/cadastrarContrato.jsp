<%@page import="br.com.sb.entidade.Box"%>
<%@page import="br.com.sb.entidade.Localizacao"%>
<%@page import="br.com.sb.entidade.Instituicao"%>
<%@page import="br.com.sb.entidade.Usuario"%>
<%@page import="br.com.sb.entidade.Contrato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%
	Contrato contrato = (Contrato)request.getAttribute("contrato"); 

	ArrayList<Usuario> listaUsuarios 			= (ArrayList<Usuario>)request.getSession().getAttribute("listaUsuarios"); 	
	ArrayList<Instituicao> listaInstituicoes 	= (ArrayList<Instituicao>)request.getSession().getAttribute("listaInstituicoes");
	ArrayList<Localizacao> listaLocalizacoes 	= (ArrayList<Localizacao>)request.getSession().getAttribute("listaLocalizacoes");
	ArrayList<Box> listaBoxs 					= (ArrayList<Box>)request.getSession().getAttribute("listaBoxs");
	
	if(listaInstituicoes == null){
		listaInstituicoes = new ArrayList<Instituicao>();
	}
	
	if(listaLocalizacoes == null){
		listaLocalizacoes = new ArrayList<Localizacao>();
	}
	
	if(listaBoxs == null){
		listaBoxs = new ArrayList<Box>();
	}
	
	if(contrato == null){
		contrato = new Contrato();
	}
%>



<script type="text/javascript">

	function cadastrarContrato(){
		document.frmContrato.action = "<%= request.getContextPath() %>/ContratoController";
		document.frmContrato.pagina.value = "cadastrarContrato";
		document.frmContrato.submit();
	}
	
	function alterarContrato(){
		document.frmContrato.action = "<%= request.getContextPath() %>/ContratoController";
		document.frmContrato.pagina.value = "alterarContrato";
		document.frmContrato.submit();
	}

	function carregaComboInstituicao(){
		
		document.frmContrato.action = "<%= request.getContextPath() %>/ContratoController";
		document.frmContrato.pagina.value = "carregaComboInstituicao";
		document.frmContrato.submit();
		
	}

	function carregaComboLocalizacao(){
		
		document.frmContrato.action = "<%= request.getContextPath() %>/ContratoController";
		document.frmContrato.pagina.value = "carregaComboLocalizacao";
		document.frmContrato.submit();
		
	}
	
	function carregaComboBox(){
		
		document.frmContrato.action = "<%= request.getContextPath() %>/ContratoController";
		document.frmContrato.pagina.value = "carregaComboBox";
		document.frmContrato.submit();
	}
	
	function mostrarCampos(){
		document.getElementById("campos").style.display = 'block';
	}
	
	<% if(contrato.getIdContrato() != null){%>
		mostrarCampos();
	<%}%>
</script>

<h1>Modelos de contratos</h1>
	<form name="frmContrato" method="post">
		<input type="hidden" name="pagina" value=""/>
		<input type="hidden" name="idContrato" 			value="<%= contrato.getIdContrato()%>"/>
		<input type="hidden" name="idContratoExclusao"	value=""/>
		<table>
			<tr> 
				<td> 
					<select name="idUsuario" onchange="carregaComboInstituicao();" >
						<option>Pick one</option>
					<%
						Integer idUsuario = (Integer)session.getAttribute("idUsuarioEscolhido");
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
			<% if(!listaInstituicoes.isEmpty()){ %>
				<tr> 
					<td> 
						<select name="idInstituicao" onchange="carregaComboLocalizacao();">
						<option>Pick one</option>
						<%
							Integer idInstituicao = (Integer)session.getAttribute("idInstituicaoEscolhida");
						
							if(idInstituicao == null){
								idInstituicao = new Integer(0);
							}
						
							for(int i=0; i < listaInstituicoes.size(); i ++){
								Instituicao instituicao = listaInstituicoes.get(i);
								if(!instituicao.getIdInstituicao().equals(idInstituicao)){
								%>
									<option value="<%= instituicao.getIdInstituicao() %>" > <%= instituicao.getNome() %> </option>
								<%
								}else{
								%>
									<option value="<%= instituicao.getIdInstituicao() %>" selected="selected" > <%= instituicao.getNome() %> </option>
								<%
								}
							}
						%>
						</select>
						
					</td>
				</tr>
			<%} %>

			<% if(!listaLocalizacoes.isEmpty()){ %>
				<tr> 
					<td> 
						<select name="idLocalizacao" onchange="carregaComboBox();">
						<option>Pick one</option>
						<%
							Integer idLocalizacao = (Integer)session.getAttribute("idLocalizacaoEscolhida");
							
							if(idLocalizacao == null){
								idLocalizacao = new Integer(0);
							}
						
							for(int i=0; i < listaLocalizacoes.size(); i ++){
								Localizacao localizacao = listaLocalizacoes.get(i);
								if(!localizacao.getIdLocalizacao().equals(idLocalizacao)){
								%>
									<option value="<%= localizacao.getIdLocalizacao() %>" > <%= localizacao.getNome() %> </option>
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
			<%} %>

			<% if(!listaBoxs.isEmpty()){ %>
				<tr> 
					<td> 
						<select name="idBox" onchange="mostrarCampos();">
						<option>Pick one</option>
						<%
							Integer idBox = (Integer)session.getAttribute("idBoxEscolhida");
							
							if(idBox == null){
								idBox = new Integer(0);
							}
						
							for(int i=0; i < listaBoxs.size(); i ++){
								Box box = listaBoxs.get(i);
								if(!box.getIdBox().equals(idBox)){
								%>
									<option value="<%= box.getIdBox() %>" > <%= box.getNumero() %> </option>
								<%
								}else{
								%>
									<option value="<%= box.getIdBox() %>" selected="selected"> <%= box.getNumero() %> </option>
								<%	
								}
							}
						%>
						</select>
						
					</td>
				</tr>
			<%} %>


		</table>

		<table id="campos">
			<tr>
				<td>Data Inicial:</td>
				<td> <input type="text" name="dtInicial" value="<%= contrato.getDataInicial() %>">
			</tr>
		
			<tr>
				<td>Data Final:</td>
				<td> <input type="text" name="dtFinal" value="<%= contrato.getDataFinal() %>">
			</tr>
		
			<tr> 
				<td>Termo de Adesao</td>
				<td><textarea rows="10" cols="0" name="txtTermo" value="<%= contrato.getTermoDeAdesao() %>"></textarea>
			</tr>
		
			<tr>
				<td>Renovacao Automatica </td>
				<td><input type="checkbox" name="renAuto" value="<%= contrato.getRenovacaoAuto() %>"> </td>
			</tr>


			<tr>
				<td>Periodo </td>
				<td><input type="text" name="periodo" value="<%= contrato.getPeriodo() %>"> </td>
			</tr>
			
			<tr>
				<td>Valor Periodo </td>
				<td><input type="text" name="vlrPeriodo" value="<%= contrato.getValorPeriodo() %>"> </td>
			</tr>		
		<table>
			
		<table>
			<tr>
				<% if(contrato.getIdContrato() == null){ %>
					<td> <input type="submit" value="Cadastrar" onclick="cadastrarContrato();"> </td>
				<%}else{ %>
					<td> <input type="submit" value="Alterar" onclick="alterarContrato();"></td>
				<%} %>
			</tr>
		</table>
		
	</form>
