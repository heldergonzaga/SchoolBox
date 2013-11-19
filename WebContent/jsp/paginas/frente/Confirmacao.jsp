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
	
	<p>
		confira seus dados e confirme a contratação do seu aluguel.
	</p>
		<form action="Final.sb">
			
			<fieldset>
			
				<div>
					<label for="nome">Nome: </label> Frederico.
				
				</div>
				<div>
					<label for="sobrenome">Sobrenome</label> Gonzaga
				</div>
				<div>
					<label for="sobrenome">Email</label>
					emailTeste@gmail.com
				</div>
				
				
				<hr>
				
				<div>
					<label for="instituicao">Instituição</label>
						Marista
				</div>
				
				<div>
					<label for="pavilhao">Pavilhao</label>
					7
				</div>
				
				<div>
					<label for="sobrenome">Boxes</label>
						<BR/>

					 Box numero 1 <br/>
					 Box numero 2 <br/>
					 Box numero 3 <br/>

				</div>
				
				<hr>
				
				
				<div>
				
					<div id="radio">
					<label for="instituicao">Peiodicidade: </label>
						
						Mensal
						
					</div>
				</div>
				<div>
					<label for="instituicao">Renovação automática: </label>
					Sim 			
				
				<div>
					<label for="instituicao">Valor do aluguel por periodo</label>  R$ 120,00
				</div>
				
				
				<div>
					<label for="instituicao">Forma de Pagamento</label>
						Cartao (situação: à pagar).
				</div> 
				
				
				
				<h4>Termo de compromisso:</h4>
				
				Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.
				<br/><br/>
				<input type="checkbox" value="sim" /> Aceito
			
				
				
			</fieldset>
				<hr />
				<input type="submit" value="Contratar" />
		</form>
</div>

<br><br>
