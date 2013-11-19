<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script src="/SchoolBox/docs/ui/jquery.ui.button.js"></script>
<script src="/SchoolBox/docs/ui/jquery.ui.dialog.js"></script>

<h1>Financeiro</h1>

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

<p>
   <a href="#" class="insert">Situação</a> 
   <a href="#" class="insert">Extrato</a> 
</p>
   
   
<table border="0" class="bordered" >
        <thead>
            <tr >
                <th>Nome</th> 
                 <th>Instituição</th>
                <th>Tipo de dados</th>
                 <th></th>
            </tr>
        </thead>
         <tbody>
            <tr >
                <td><input type="text" name="nome" id="nome"  value='' /> </td> 
                <td>
                
                <select name="idcargo" id="idcargo" id="idcargo">
	          		<option value="">Selecione</option>
	          		<option value="">Marista</option>
	          		<option value="">Escola teste</option>
	          	</select> 
			 
			 <br /> 	
			 
			 </td>
                <td>
                
                 <select name="idcargo" id="idcargo" id="idcargo">
	          		<option value="">Selecione</option>
	          		<option value="">Inadimplentes</option>
	          		<option value="">Adimplentes</option>
	          	</select> 
	          	
				</td>
				  <td>
                
                <a href="#" class="insert ">Buscar</a> 
	          	
				</td>
               
               
            </tr>
            
              
           
        </tbody>
</table>


<br>
<p>Resultado da Busca</p>

<table border="0" class="bordered" >
        <thead>
            <tr >
                <th>Id</th> 
                <th>Contrato</th>
                <th>Nome</th>
                <th>Data de Adesao</th>
                <th>Ren Auto</th>
                <th>Period.</th>
                <th>Operação</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.idUsuario}" /></td>
                    <td><c:out value="${usuario.idUsuario}" /></td>
                    <td><a href='#'><c:out value="${usuario.nome}" /></a></td>
                    <td>10/10/2010</td>
                    <td>Sim</td>
                    <td>Mensal</td>
                    <td><a href='#'>Cobrar</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    
    