<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="/SchoolBox/docs/ui/jquery.ui.button.js"></script>
<script src="/SchoolBox/docs/ui/jquery.ui.dialog.js"></script>

<h1>Usuarios</h1>

<%@include file="/jsp/inc/incMensagem.jsp" %>
<script>
	$(function() {
		$( "#modalConfirma" ).dialog({
			resizable: false,
			auto
			height:190,
			modal: true,
			buttons: {
				"Excluir ?": function() {
					$( this ).dialog( "close" );
				},
				Cancel: function() {
					$( this ).dialog( "close" );
				}
			}
		});
		
		
	});
</script>
 <p><a href="UsuarioController?acao=inserir" class="insert">Adicionar Usuário</a></p>
 <table border="0" class="bordered" >
        <thead>
            <tr >
                <th>Id</th> 
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>Email</th>
                <th colspan=2>Operações</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.idUsuario}" /></td>
                    <td>
                    	<a href='UsuarioController?acao=editar&idUsuario=<c:out value="${usuario.idUsuario}"/>'><c:out value="${usuario.nome}" /></a>
                    </td>
                    <td><c:out value="${usuario.sobrenome}" /></td>
                    <td><c:out value="${usuario.email}" /></td>
                    <td><a href="UsuarioController?acao=deletar&idUsuario=<c:out value="${usuario.idUsuario}"/>" class="del" id="deletar" >Deletar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    
    