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
	
		
		$( "input[type=submit]" )
		.button()
		.click(function( event ) {
			
		});
	
			$( "#check" ).button();
			$( "#format" ).buttonset();
		
	
	});
	</script>
<h1>
	Seja bem vindo!
</h1>

<div id="effect" class="ui-widget-content ui-corner-all">
	<h3 class="ui-widget-header ui-corner-all">Passo 2 - Seleção de seu Box</h3>
	<p>
		Selecione o seu box
		
		
		<form action="passo3.sb">
			
				<div>
					<label for="instituicao">Instituição</label>
					<select id="instituicao" name="instituicao">
						<option value="">Selecione</option>
						<option value="1">Marista</option>
					</select>
				</div>
				
				<div>
					<label for="pavilhao">Pavilhao</label>
					<select id="instituicao" name="instituicao">
						<option value="">Selecione</option>
						<option value="1">Pavilhao em Frente ao Banheiro masculino</option>
					</select>
				</div>
				
				<div >
					<label for="sobrenome">Boxes</label>
					
				</div>
				
				<div id="format"> 
				<input type="checkbox" id="check1" /><label for="check1">1</label>
					<input type="checkbox" id="check2" /><label for="check2">2</label>
					<input type="checkbox" id="check3" /><label for="check3">3</label>
					<input type="checkbox" id="check4" /><label for="check4">4</label>
					<input type="checkbox" id="check5" /><label for="check5">5</label>
					<input type="checkbox" id="check6" /><label for="check6">6</label>
					<input type="checkbox" id="check7" /><label for="check7">7</label>
					<input type="checkbox" id="check8" /><label for="check8">8</label>
					<input type="checkbox" id="check9" /><label for="check9">9</label>
					<input type="checkbox" id="check10" /><label for="check10">10</label>
					<input type="checkbox" id="check11" /><label for="check11">11</label>
					<input type="checkbox" id="check12" /><label for="check12">12</label>
				</div>
		
				<hr />
				
			
			<input type="submit" value="Avançar" />
		
		</form>
</div>

<br><br>
