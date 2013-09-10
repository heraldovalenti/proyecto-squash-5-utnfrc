
<%@ page import="sgt.Domicilio" %>
<!DOCTYPE html>
<html>
	<head>
	<link href="${resource(dir: 'css', file: 'main.css') }" type="text/css" rel="stylesheet">
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'domicilio.label', default: 'Domicilio')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-domicilio" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				
				<li><g:link class="create" action="create"><g:message code="Nuevo" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-domicilio" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="piso" title="${message(code: 'domicilio.piso.label', default: 'Piso')}" />
					
						<g:sortableColumn property="dpto" title="${message(code: 'domicilio.dpto.label', default: 'Dpto')}" />
					
						<g:sortableColumn property="codPostal" title="${message(code: 'domicilio.codPostal.label', default: 'Cod Postal')}" />
					
						<g:sortableColumn property="ciudadOrigen" title="${message(code: 'domicilio.ciudadOrigen.label', default: 'Ciudad Origen')}" />
					
						<g:sortableColumn property="provincia" title="${message(code: 'domicilio.provincia.label', default: 'Provincia')}" />
					
						<g:sortableColumn property="ciudad" title="${message(code: 'domicilio.ciudad.label', default: 'Ciudad')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${domicilioInstanceList}" status="i" var="domicilioInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${domicilioInstance.id}">${fieldValue(bean: domicilioInstance, field: "piso")}</g:link></td>
					
						<td>${fieldValue(bean: domicilioInstance, field: "dpto")}</td>
					
						<td>${fieldValue(bean: domicilioInstance, field: "codPostal")}</td>
					
						<td>${fieldValue(bean: domicilioInstance, field: "ciudadOrigen")}</td>
					
						<td>${fieldValue(bean: domicilioInstance, field: "provincia")}</td>
					
						<td>${fieldValue(bean: domicilioInstance, field: "ciudad")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${domicilioInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
