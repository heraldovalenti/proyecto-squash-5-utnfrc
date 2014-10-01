<%@ page import="sgt.Club" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>
<body>
	<div>
	<h1>Perfil publico de club</h1>
	
	<g:if test="${ club }">
		<g:render template="clubCard" />
	</g:if>
	
	<g:else>
	<h1>Perfil public de club no disponible</h1>
	</g:else>
	</div>
</body>
</html>