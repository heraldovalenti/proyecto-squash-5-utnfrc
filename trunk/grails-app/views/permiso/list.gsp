
<%@ page import="sgt.Permiso" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'permiso.label', default: 'Permiso')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link controller="rol" action="list"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-person"></span><span style="padding-left: 18px;">Roles</span> </g:link>
    		<g:link action="create"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Agregar Permiso</span> </g:link>
		</fieldset>
		
		<div id="list-permiso" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="controller" title="${message(code: 'permiso.controller.label', default: 'Controller')}" />
					
						<g:sortableColumn property="action" title="${message(code: 'permiso.action.label', default: 'Action')}" />
					
						<g:sortableColumn property="mode" title="${message(code: 'permiso.mode.label', default: 'Mode')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${permisoInstanceList}" status="i" var="permisoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${permisoInstance.id}">${fieldValue(bean: permisoInstance, field: "controller")}</g:link></td>
					
						<td>${fieldValue(bean: permisoInstance, field: "action")}</td>
					
						<td>${fieldValue(bean: permisoInstance, field: "mode")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${permisoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
