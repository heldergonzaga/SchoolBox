<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	


<meta charset="ISO-8859-1">
<title>jQuery UI Menu - Default functionality</title>
<link rel="stylesheet" href="<%=ctx%>/docs/themes/base/jquery.ui.all.css">
<script src="<%=ctx%>/docs/js/jquery-1.9.1.js"></script>
<script src="<%=ctx%>/docs/ui/jquery.ui.core.js"></script> 
<script src="<%=ctx%>/docs/ui/jquery.ui.widget.js"></script>
<script src="<%=ctx%>/docs/ui/jquery.ui.position.js"></script>
<script src="<%=ctx%>/docs/ui/jquery.ui.menu.js"></script>
<link rel="stylesheet" href="<%=ctx%>/docs/css/cssSite.css">
<script>
	$(function() {
		$("#menu").menu();
	});
</script>
<style>
.ui-menu {
	width: 150px;
}
</style>