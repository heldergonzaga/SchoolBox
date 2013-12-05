<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<script src="/SchoolBox/docs/ui/jquery.ui.tooltip.js"></script>
		<script src="/SchoolBox/docs/ui/jquery.ui.button.js"></script>

<style>
	.toggler {
		width: 100%;
	
	}
	#button {
		padding: .5em 1em;
		text-decoration: none;
	}
	#effect {
		position: relative;
		width: 100%;
		
		padding: 0.4em;
	}
	#effect h3 {
		margin: 0;
		padding: 0.4em;
		text-align: center;
	}
	
	
	label {
		display: inline-block; width: 11em;
	}
	fieldset div {
		margin-bottom: 2em;
	}
	fieldset .help {
		display: inline-block;
	}
	.ui-tooltip {
		width: 210px;
	}
	#format {}
	</style>
	<script>
	$(function() {
		var tooltips = $( "[title]" ).tooltip();
	
		
		$( "input[type=submit],input[type=button]" )
		.button()
		.click(function( event ) {
			
		}); 
	
		$( "#radio" ).buttonset();
		
	
	});
	</script>
<h1>
	Seja bem vindo!
</h1>

<div id="effect" class="ui-widget-content ui-corner-all">
	<h3 class="ui-widget-header ui-corner-all">Confirmação de dados - Informações de pagamento</h3>
	
	
		<form action="Final.sb">
			
			<fieldset>
				<P></P>
				Nome: Frederico. <br>
				Sobrenome: Gonzaga <br>
				Email: 	emailTeste@gmail.com<br>
				<P></P>
				
				<h3 class="ui-widget-header ui-corner-all">Dados do(s) seu(s) Boxe(s)</h3>	
			
				<div>
					<p></p>
					Instituição:  <b>Marista</b> <br>
					Pavilhao:	<b>7</b> 
					
					<table border="0" class="bordered" >
				        <thead>
				            <tr >
				                <th>Numero</th> 
				                <th>Identificativo</th>
				            </tr>
				        </thead>
				        <tbody>
				                <tr>
				                    <td>001</td>
				                    <td>MOD-002</td>
				                </tr>
				                <tr>
				                    <td>001</td>
				                    <td>MOD-002</td>
				                </tr>
				        </tbody>
				    </table>
				</div>
				
				<h3 class="ui-widget-header ui-corner-all">Termo de compromisso:</h3>	
				<p></p>
				
				<div style =" overflow: auto; display:block; height: 100px; width:90%; margin-left:10px;">
					Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
					 Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor 
					 in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
					 Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor 
					 in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
					 Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor 
					 in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
					 Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor 
					 in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
				</div>
				<div>	<input type="checkbox" value="sim" /> Aceito</div>
				
				<h3 class="ui-widget-header ui-corner-all">Dados de Pagamento</h3>
				<p></p>
				<div>
					Periodicidade: Mensal <br>
					Renovação automática: Sim <br>
					Valor do aluguel por periodo: R$ 120,00 <br>
					Forma de Pagamento : Cartão de Crédito (Visa).<br>
					
					<p></p>
					Para confirmar sua contratação, informe os dados abaixo:<br>
					<br>
					Numero do cartao:<br>	<input type="text" name="numeroCartao" size="20" /><br>
					Vençimento (Mês/Ano):<br>	<input type="text" name="numeroCartao" size="20" /><br>
					Código de Segurança:<br>	<input type="text" name="numeroCartao" size="3" /><br>
					CPF:<br>	<input type="text" name="numeroCartao" size="15" /><br>
					Numero do cartao:<br>	<input type="text" name="numeroCartao" size="20" /><br>
					
					
				</div>
				
				
				
			
				
				
			</fieldset>
				<hr />
				<input type="submit" value="Contratar" />
		</form>
</div>

<br><br>
