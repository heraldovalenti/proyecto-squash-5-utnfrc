
<%@ page import="sgt.Rol" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'rol.label', default: 'Rol')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
	
	<fieldset class="buttons">
    		<g:link action="list"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-person"></span><span style="padding-left: 18px;">Permisos</span> </g:link>
	</fieldset>
		
		<div id="list-rol" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'rol.nombre.label', default: 'Nombre')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rolInstanceList}" status="i" var="rolInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${rolInstance.id}">${fieldValue(bean: rolInstance, field: "nombre")}</g:link></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${rolInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
