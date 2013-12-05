<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    <script src="/SchoolBox/docs/ui/jquery.ui.tooltip.js"></script>
	<script src="/SchoolBox/docs/ui/jquery.ui.button.js"></script>
	<script src="/SchoolBox/docs/ui/jquery.ui.widget.js"></script>
	<script src="/SchoolBox/docs/ui/jquery.ui.spinner.js"></script>
	
<div><br/></div>
<span style="display:bolck; padding-left:10px;">Neste momento existem <span style="font-size:16px;color:red;font-weight: bold;">(<c:out value="${disponiveis}"/>)</span>  boxes livres sua escolha.</span>
<input type="hidden" name="qtdBoxReserva" id="qtdBoxReserva" value="<c:out value="${disponiveis}"/>" />
<br><br>
<span id="selecaoQuantidade">
<label for="spinner">Selecione a Quantidade</label>
<input id="spinner" name="quantidadeRequerida" value="0" />
</span>