<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>






<title>Sistema SchoolBox</title>
<link rel="stylesheet" href="<%=ctx%>/docs/css/cssSite.css"> 
<link rel="stylesheet" href="<%=ctx%>/docs/css/font/opensans.css">
<link rel="stylesheet" href="<%=ctx%>/docs/themes/redmond/jquery-ui-1.9.2.custom.min.css">

<script src="<%=ctx%>/docs/js/jquery-1.9.1.js"></script>
<script src="<%=ctx%>/docs/ui/jquery.ui.core.js"></script> 
<script src="<%=ctx%>/docs/ui/jquery.ui.widget.js"></script>
<script src="<%=ctx%>/docs/ui/jquery.ui.position.js"></script>
<script src="<%=ctx%>/docs/ui/jquery.ui.menu.js"></script>
<script src="<%=ctx%>/docs/js/jquery.mask.min.js"></script>
<script src="<%=ctx%>/docs/js/jquery.validate.min.js"></script>  


<script>
	$(function() { 
		$("#menu").menu(); 
		$("input[type=submit], a.insert").button().click(function( event ) {});
	
	});
	function atualizarMensagens(){
		$("#mensagensSistema").html('').load("/SchoolBox/jsp/inc/incMensagem.jsp");
	}
	
	
</script>
<style>
	.ui-menu {
		width: 150px;
	}
</style>

<!--[if lt IE 9]>
	<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script>try{Typekit.load();}catch(e){};TypekitConfig={kitId:"zbh6eqe",scriptTimeout:4000},function(){var a=document.getElementsByTagName("html")[0];a.className+=" wf-loading";var b=setTimeout(function(){a.className=a.className.replace(/(\s|^)wf-loading(\s|$)/g,""),a.className+=" wf-inactive"},TypekitConfig.scriptTimeout),c=document.createElement("script");c.src="//use.typekit.com/"+TypekitConfig.kitId+".js",c.type="text/javascript",c.async="true",c.onload=c.onreadystatechange=function(){var a=this.readyState;if(!a||a=="complete"||a=="loaded"){clearTimeout(b);try{Typekit.load(TypekitConfig)}catch(c){}}};var d=document.getElementsByTagName("script")[0];d.parentNode.insertBefore(c,d)}()</script>