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
	<h3 class="ui-widget-header ui-corner-all">Parabens! - Sua contratação foi feita com sucesso.</h3>
		<form action="inicial.sb">
			<fieldset>
			<p></p>
				<h2>
					Parabens!, você concluiu o processo de aluguel:
					<br/>
					Foi enviado para o seu email, as informações de seu aluguel<br>
					Entre as informações enviadas, está a senha para os boxes selecionados.
				
				</h2>
				
				
				<br/><br/>
			
				
				
			</fieldset>
				<hr />
				<input type="submit" value="Voltar" />
		</form>
</div>

<br><br>
