<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script src="/SchoolBox/docs/ui/jquery.ui.tooltip.js"></script>
	<script src="/SchoolBox/docs/ui/jquery.ui.button.js"></script>
	<script src="/SchoolBox/docs/ui/jquery.ui.widget.js"></script>
	<script src="/SchoolBox/docs/ui/jquery.ui.spinner.js"></script>
	<script src="/SchoolBox/docs/js/jquery.form.min.js"></script> 

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




<h1>
	Seja bem vindo!
</h1>

<div id="effect" class="ui-widget-content ui-corner-all">
	<h3 class="ui-widget-header ui-corner-all">Passo 2 - Seleção de seu(s) Box(es)</h3>
		<%@include file="/jsp/inc/incMensagem.jsp" %>
		<form action="/SchoolBox/FrontController" id="formReserva">
			<input type="hidden" name="passo"  value="2">
			<input type="hidden"  name="subpasso" value="3">
				<div><br/></div>
				<div>
					<label for="instituicao">Instituição</label>
					<select id="instituicao" name="instituicao">
						<option value="">Selecione</option>
					  	<c:forEach items="${instituicoes}" var="instituicao">
						<option value="<c:out value="${instituicao.idInstituicao}"/>"><c:out value="${instituicao.nome}"/></option>
						</c:forEach>
					</select>
				</div>
				
				<div>
					<label for="localizacao">localizacao</label>
					<select id="localizacao" name="localizacao" >
						<option value="">Selecione ...</option>
		
					</select>
				</div>
				<div id="quantidadeDisponivel">
					
				</div>
				<div  style="width:100%;display:block;text-aling:right"><br/>
					<input type="submit" value="Adicionar " id="adicionar"/>
				</div>
				
				<div><br/></div>
			</form>
			
			<div id="resposta"></div>
</div>

<br><br>

<script>
	$(function() {
		
		
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

		
		var options = { 
			        target:        '#resposta',   // target element(s) to be updated with server response 
			       
			        success:       showResponse  // post-submit callback  
			     // beforeSubmit:  showRequest,  // pre-submit callback 
			        // other available options: 
			        //url:       url         // override for form's 'action' attribute 
			        //type:      type        // 'get' or 'post', override for form's 'method' attribute 
			        //dataType:  null        // 'xml', 'script', or 'json' (expected server response type) 
			        //clearForm: true        // clear all form fields after successful submit 
			        //resetForm: true        // reset the form after successful submit 
			 
			        // $.ajax options can be used here too, for example: 
			        //timeout:   3000 
		}; 
		
		// pre-submit callback 
		function showResponse(formData, jqForm, options) { 
			 
			$(".delete").click(function(e) {
		    	e.preventDefault();
		    	$('#carregando').fadeIn();
		    	var trTabela = $(this).parent().parent();
		    	var id = $(this).attr("id"); 
		    	var string = 'idbox='+ id+'&passo=2&subpasso=4';
		    	$.ajax({
		    	 type: "POST",
		    	 url: "/SchoolBox/FrontController",
		    	 data: string,
		    	 cache: false,
		    	 success: function(){
		    		trTabela.slideUp('slow', function() {$(this).remove();});
		    		$('#carregando').fadeOut();
		    	 	atualizaQuantidadeDisponivel();
		    	 	atualizarMensagens();
		    	 }
		    	 });
		    	return false;
		    });
			
			atualizaQuantidadeDisponivel();
			
		    // formData is an array; here we use $.param to convert it to a string to display it 
		    // but the form plugin does this for you automatically when it submits the data 
		    //var queryString = $.param(formData); 
		 
		    // jqForm is a jQuery object encapsulating the form element.  To access the 
		    // DOM element for the form do this: 
		    // var formElement = jqForm[0]; 
		 
		    
		 
		    // here we could return false to prevent the form from being submitted; 
		    // returning anything other than false will allow the form submit to continue 
		    return true; 
		} 
		
		
	    // bind form using 'ajaxForm' 
	    $('#formReserva').ajaxForm(options); 
	    
	    $("#adicionar").attr('disabled', true).addClass( 'ui-state-disabled' ); 
	    
	    $('#instituicao').change(function() {
	    	$('#carregando').fadeIn();
	    	$('#localizacao').removeAttr('disabled');
	        $('#localizacao').load("/SchoolBox/FrontController?passo=2&subpasso=1&idInstituicao="+$('#instituicao').val(),function(){
	        	$('#quantidadeDisponivel').html('');
	        	$('#carregando').fadeOut();
	        });
	        atualizarMensagens();
	        
	    });
	    
	    $('#localizacao').change(function() {
	    	atualizaQuantidadeDisponivel();
	    	atualizarMensagens();
	    });
	    function atualizaQuantidadeDisponivel(){
	    	$('#carregando').fadeIn();
	        $('#quantidadeDisponivel').html('').load( "/SchoolBox/FrontController?passo=2&subpasso=2&idInstituicao="+$('#instituicao').val()+"&idLocalizacao="+$('#localizacao').val(),function(){
	        	atualizarMensagens();
	        	var qtdDisp = 0; 
	        	try{ 
	        		qtdDisp = $("#qtdBoxReserva").val(); 
	        	}catch(e){
	        		
	        	}
	        	if(qtdDisp == 0){
	        		$( "#selecaoQuantidade" ).hide();
	        	}else{
	        		$( "#selecaoQuantidade" ).show();
	        		$( "#spinner" ).spinner({
		        		spin: function( event, ui ) {
		        			
		        			$('#adicionar').attr('disabled', false).removeClass( 'ui-state-disabled' ); 
		        			
		        			if ( ui.value > qtdDisp ) {
		        				$( this ).spinner( "value", qtdDisp );
			        			return false;
		        			} else if (ui.value < 1 ){
		        				$( this ).spinner( "value", 0 );
		        				$("#adicionar").attr('disabled', true).addClass( 'ui-state-disabled' ); 
		        				return false;
		        			}
		        		} 
		        	});
	        		
	        	}
	        	
	        	$('#carregando').fadeOut();
	        	
	        });
	    	
	    }
	    
	    $(".delete").click(function(e) {
	    	e.preventDefault();
	    	$('#carregando').fadeIn();
	    	var trTabela = $(this).parent().parent();
	    	var id = $(this).attr("id"); 
	    	var string = 'id='+ id ;
	    	$.ajax({
	    	 type: "POST",
	    	 url: "delete.php",
	    	 data: string,
	    	 cache: false,
	    	 success: function(){
	    		trTabela.slideUp('slow', function() {$(this).remove();});
	    		atualizarMensagens();
	    	 	$('#carregando').fadeOut();
	    	 }
	    	 });
	    	return false;
	    });

	});	
</script>
