<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:if test="${not empty processoCadastro.listaBoxesCadastrados}">


	<script src="/SchoolBox/docs/ui/jquery.ui.tooltip.js"></script>
	<script src="/SchoolBox/docs/ui/jquery.ui.button.js"></script>
	<script>
	$( "input[type=submit]" )
		.button()
		.click(function( event ) {		
	});
	</script>
	

	<form action="/SchoolBox/tm/frente/passo3.sb">	
		<h3 class="ui-widget-header ui-corner-all">Seus Boxes Reservados são:</h3>
		<div><br/></div>
		 
		<table border="0" class="bordered" >
	        <thead>
	            <tr>
	                <th>Número</th> 
	                <th>Instituição</th>
	                <th>Localização</th>
	                <!-- th>mofr</th-->
	                <th>Valor Por Mês</th>
	                <th></th>
	            </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${processoCadastro.listaBoxesCadastrados}" var="box">
				<tr>
                    <td><c:out value="${box.numero}"/></td>
                    <td><c:out value="${box.localizacao.instituicao.idInstituicao}"/></td>
                    <td><c:out value="${box.localizacao.idLocalizacao}"/></td>
                    <!-- td>MOD-002</td-->
                    <td><c:out value=""/>R$ 20,00</td>
                    <td><a href="#" class="delete">Excluir</a></td>
                </tr>
				
				
				<option value=""><c:out value="${localizacao.nome}"/></option> 
			</c:forEach>
	        </tbody>
	    </table>
	    <div><br/></div>
		<input type="submit" value="Avançar" />
		<div><br/></div>
	</form>
</c:if>

