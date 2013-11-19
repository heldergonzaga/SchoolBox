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
		width: 80%;
		
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
	
		
		$( "input[type=button]" )
		.button()
		.click(function( event ) {
			event.preventDefault();
		});
	
		$( "#radio" ).buttonset();
		
	
	});
	</script>
<h1>
	Seja bem vindo!
</h1>

<div id="effect" class="ui-widget-content ui-corner-all">
	<h3 class="ui-widget-header ui-corner-all">Cofirme seus daos</h3>
	
	<p>
		Confira seus dados, veja se estão de acordo.
	</p>
		<form>
			
				<div>
				
					<div id="radio">
					<label for="instituicao">Peiodicidade</label>
						<input type="radio" id="radio1" name="radio" /><label for="radio1">Mensal</label>
						<input type="radio" id="radio2" name="radio" checked="checked" /><label for="radio2">Semestral</label>
						<input type="radio" id="radio3" name="radio" /><label for="radio3">Anual</label>
					</div>
				</div>
				<div>
					<label for="instituicao">renovação automática</label>
					<input type="checkbox" id="check2" />				
				<div>
					<label for="instituicao">Valor da compra</label>  R$ 120,00
				</div>
				
				
				<div>
					<label for="instituicao">Forma de Pagamento</label>
					<select id="instituicao" name="instituicao">
						<option value="">Selecione</option>
						<option value="1">Cartão</option>
					</select>
				</div> 
				
				
				
				<hr />
				
			
			<input type="button" value="Avançar" />
		
		</form>
</div>

<br><br>
