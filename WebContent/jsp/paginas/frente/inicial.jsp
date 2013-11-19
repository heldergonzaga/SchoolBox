<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
	}
	#effect h3 {
		margin: 0 0  0.6em 0;
		padding: 0.4em;
		text-align: center;
	}
	
	
	label {
		display: inline-block; width: 11em;
	}
	fieldset div {
		margin-bottom: 0em;
	}
	fieldset .help {
		display: inline-block;
	}
	.ui-tooltip {
		width: 210px;
	}
	</style>
	
	
	<script>
		function redefinirSenhaR(objeto){ 
			
			if(objeto.checked == true){
				$("#senha").show();
			}else{
				$("#senha").hide();
			}	
		}
		
		
		 
		 $(document).ready(function(){
			 
				var tooltips = $( "[title]" ).tooltip();
				
				
				
				$( "input[type=submit]" )
				.button()
				.click(function( event ) {
					
				});
			 
			   $("#formCadastroUsuario").validate({
			      rules: {
			    	  nome: {required: true},
			    	  sobrenome: {required: true},
			    	  email: {required: true, email: true},
			    	  emailc:{
			                required: true, email: true ,equalTo: "#email"
			            }
			      },
			      messages: {
			    	 nome: {required: 'Informe o nome'},
			         sobrenome: {required: 'Informe o sobrenome'},
			    	 email: {required: 'Informe o email'},
			    	 emailc:{
			                required: "Confirme seu email."
			         }
			         
			      }
			   });
				 
		
			  $('.cpf').mask('000.000.000-00', {reverse: true});
			 
		});
		
	</script>
<h1>
	Seja bem vindo!
</h1>

<div id="effect" class="ui-widget-content ui-corner-all">
	<h3 class="ui-widget-header ui-corner-all">Passo 1 - Cadastro básico de dados</h3>
	<p>
		É muito simples locar um Box<br>
		Em apenas três passos você facimenete aluga seu box.
		Tenha em mãos seus dados básicos de identificação, assim como o seu cartão de credito, 
		caso deseje pagar por essa modalidade.
		
		
		<form action="/SchoolBox/FrontController" id="formCadastroUsuario" method="post">   
			<input type="hidden" value="1" name="passo">
			<fieldset>
				<div>
					<label for="nome">Nome
						<input id="nome" name="nome" title="Insira seu nome inicial." size="50" value='<c:out value="${usuario.nome}" />'>
					</label>
				</div>
				<div>
					<label for="sobrenome">Sobrenome
						<input id="sobrenome" name="sobrenome" title="Insira seu Sobrenome."  size="40" value='<c:out value="${usuario.sobrenome}" />'>
					</label>
				</div>
				<div>
					<label for="email">Email
						<input id="email" name="email" title="Insira seu Email."  size="60" value='<c:out value="${usuario.email}" />'>
					</label>
				</div>
				<div>
					<label for="emailc">Email - Confirmação
						<input id="emailc" name="emailc" title="Conforme seu Email."  size="60" value=''>
					</label>
				</div>
				
				
			</fieldset>
			<input type="submit" value="Avançar" /> 
		
		</form>
</div>

<br><br>
