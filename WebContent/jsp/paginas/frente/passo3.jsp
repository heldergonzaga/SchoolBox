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
		display: inline-block; width: 13em;
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
	
	</style>
	<script>
	$(function() {
		var tooltips = $( "[title]" ).tooltip();
	
		
		$( "input[type=submit],input[type=button]" )
		.button()
		.click(function( event ) {
			
		}); 
	
		$( "#radio" ).buttonset();
		$( "#opcaoPagamento" ).buttonset();
		
	
	});
	</script>
<h1>
	Seja bem vindo!
</h1>

<div id="effect" class="ui-widget-content ui-corner-all">
	<h3 class="ui-widget-header ui-corner-all">Passo 3 - Informações de pagamento</h3>
	<div><br/></div>
	<p>
		Agora selecione a periodicidade de sua contratação:
	</p>
		<form action="confirmacao.sb" >
			
				<div>
				<label for="instituicao">Peiodicidades Disponíveis:</label>
					<div id="radio">
						<input type="radio" id="radio3" name="radio" checked="checked"/><label for="radio3">Anual</label>
						<input type="radio" id="radio2" name="radio"  /><label for="radio2">Semestral</label>
					</div>
				</div>
				
				<div>
					<table border="0" class="bordered" >
				        <thead>
				            <tr >
				                <th>Detalhamento de valores</th> 
				            </tr>
				        </thead>
				        <tbody>
				                <tr>
				                    
				                    <td>
					                    <ul>
											<li>1ª parcela: R$ 20,00</li>
											<li>2ª parcela: R$ 20,00</li>
											<li>3ª parcela: R$ 20,00</li>
											<li>4ª parcela: R$ 20,00</li>
											<li>5ª parcela: R$ 20,00</li>
											<li>6ª parcela: R$ 20,00</li>
										</ul>
									</td>
				                </tr>
				        </tbody>
				    </table>
				</div>
				<div>
					<label for="instituicao">Selecione o Tipo de Cartão:</label>
					<div id="opcaoPagamento">
						<input type="radio" id="fmaPag1" name="formapagamento" checked="checked"/><label for="fmaPag1"> Visa</label>
						<input type="radio" id="fmaPag2" name="formapagamento"  /><label for="fmaPag2"> Master Card</label>
					</div>
				</div>
				<div>
					<label for="instituicao">Renovação automática</label>
					<input type="checkbox" id="check2" />				
				</div>
				<hr />
				<input type="submit" value="Avançar" />
		</form>
</div>

<br><br>
