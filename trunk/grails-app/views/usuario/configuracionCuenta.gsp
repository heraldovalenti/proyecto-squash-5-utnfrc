<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<g:if test="${ layout }">
			<meta name="layout" content="${ layout }">
		</g:if>
		<g:else>
			<meta name="layout" content="main">
		</g:else>
		<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<g:set var="entityName" value="${message(code: 'persona.label', default: 'Persona')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<h1>Pagina en construccion</h1>
	</body>
</html>