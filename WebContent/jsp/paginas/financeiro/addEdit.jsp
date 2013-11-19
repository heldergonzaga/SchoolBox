<%@page import="br.com.sb.entidade.Uf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<script>
		function redefinirSenhaR(objeto){ 
			
			if(objeto.checked == true){
				$("#senha").show();
			}else{
				$("#senha").hide();
			}	
		}
		
		
		 
		 $(document).ready(function(){
			 
			   $("#formCadastroUsuario").validate({
			      rules: {
			    	  nome: {required: true},
			    	  sobrenome: {required: true},
			    	  idcargo: {required: true},
			    	  cpf: {required: true},
			    	  bairro: {required: true},
			    	  cidade: {required: true},
			    	  uf:  {required: true},
			    	  complemento: {required: true},
			    	  numero: {required: true},
			    	  email: {required: true},
			    	  senha: {required: true}
			    	
			      },
			      messages: {
			    	 nome: {required: 'Informe o nome'},
			         sobrenome: {required: 'Informe o sobrenome'},
			         idcargo: {required: 'Informe Cargo'},
			    	 cpf:{required: 'Informe CPF'},
			    	 bairro: {required: 'Informe o bairro'},
			    	 cidade: {required: 'Informe o cidade'},
			    	 uf: {required: 'Informe o UF'},
			    	 complemento: {required: 'Informe o complemento'},
			    	 numero:{required: 'Informe o numero'},
			    	 email: {required: 'Informe o email'},
			    	 senha: {required: 'Informe o senha'}
			         
			      }
			   });
				 
			 
		 /* 
			  $('.date').mask('11/11/1111');
			  $('.time').mask('00:00:00');
			  $('.date_time').mask('00/00/0000 00:00:00');
			  $('.cep').mask('00000-000');
			  $('.phone').mask('0000-0000');
			  $('.phone_with_ddd').mask('(00) 0000-0000');
			  $('.phone_us').mask('(000) 000-0000'); c
			  $('.mixed').mask('AAA 000-S0S');
			 */  
			  
			  $('.cpf').mask('000.000.000-00', {reverse: true});
			 /*  
			 
			 $('.money').mask('000.000.000.000.000,00', {reverse: true});
			  $('.money2').mask("#.##0,00", {reverse: true, maxlength: false});
			  $('.ip_address').mask('0ZZ.0ZZ.0ZZ.0ZZ', {translation: {'Z': {pattern: /[0-9]/, optional: true}});
			  $('.ip_address').mask('099.099.099.099'); */
			  
		});
		
		
	</script>

	<h1>Usuário Criação/Alteracao </h1> 
	
    <form method="POST" action='UsuarioController' name="formCadastroUsuario" id="formCadastroUsuario">
       	
       		<p class="ui-state-error ui-corner-all">Para o cadastro os campos obrigatórios são marcados com: <span class="required">*</span></p>	
       		
       		<input type="hidden" readonly="readonly" name="idUsuario"
            value='<c:out value="${usuario.idUsuario}" />' /> <br />  
            
        	<label for="nome">Nome <span class="required">*</span></label>
        	<input type="text" name="nome" id="nome"
            value='<c:out value="${usuario.nome}" />' /> <br /> 
       
       		<label for="sobrenome">Sebrenome <span class="required">*</span></label>
       		<input type="text" name="sobrenome" id="sobrenome"
            value='<c:out value="${usuario.sobrenome}" />' /> <br /> 
            
			<label for="cargo">Cargo <span class="required">*</span></label>
         	<select name="idcargo" id="idcargo" id="idcargo">
          		<option value="">Selecione</option>
          		<c:forEach items="${cargos}" var="cargo">  
          		  <option value="${cargo.idCargo}" 
          		  
          		  <c:if test="${cargo.idCargo eq usuario.idCargo}">
          		  	selected
          		  </c:if>
          		  
          		  >${cargo.titulo}</option>
				</c:forEach>
			 </select> <br /> 	
			 
            
          	<label for="cpf">CPF <span class="required">*</span></label>
          	<input type="text" name="cpf" class="cpf" id="cpf"
            value='<c:out value="${usuario.cpf}" />' /> <br /> 
          	
          	<label for="bairro">Bairro <span class="required">*</span></label>
          	 <input type="text" name="bairro"  id="bairro"
            value='<c:out value="${usuario.bairro}" />' /> <br /> 
          	
          
          	<label for="cidade">Cidade <span class="required">*</span></label>
          	<input type="text" name="cidade" id="cidade"
            value='<c:out value="${usuario.cidade}" />' /> <br /> 
          	
          	
          	<label for="uf">UF <span class="required">*</span></label>
         	<select name="uf" id="uf" id="uf">
          		<option value="">Selecione</option>
          		<c:forEach items="${ufs}" var="uf">  
          		  <option value="${uf}" 
          		  
          		  <c:if test="${uf eq usuario.uf}">
          		  	selected
          		  </c:if>
          		  
          		  >${uf.nome}</option>
				</c:forEach>
			 </select> <br /> 
        
        
           <label for="complemento">Complemento </label>
           <input
            type="text" name="complemento" id="complemento"
            value='<c:out value="${usuario.complemento}" />' /> <br />   
           
           
           
           <label for="numero">Número <span class="required">*</span></label>
           <input type="text" name="numero"  id="numero"
            value='<c:out value="${usuario.numero}" />' /> <br /> 


           	 <label for="email">Email <span class="required">*</span></label>	    
       		<input type="text" name="email" id="email"
       		 value='<c:out value="${usuario.email}" />' /> <br /> 
       		 
           
           
            <c:if test="${not empty usuario}">
	  			<input type="checkbox" name="redefinirSenha" value="sim" onclick="redefinirSenhaR(this);" > Redefinir Senha <br/>
	 	  	</c:if>
           	<c:if test="${not empty usuario}">
          	<span id="senha" style="display:none">
          	</c:if>
 				<label for="senha">Senha <span class="required">*</span></label>
	            <input
	            type="password" name="senha"  id="senha"
	            value='' /> <br /> 	
	            
	        <c:if test="${not empty usuario}">
	        </span>  
	        </c:if>  
	     

            <input  type="submit" value="Enviar" />
            <input  type="reset" value="Limpar" />
            
    </form>
   