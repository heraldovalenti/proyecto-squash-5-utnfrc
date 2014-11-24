
<%@ page import="sgt.Ranking" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'ranking.label', default: 'Ranking')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link action="create"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Nuevo Ranking</span> </g:link>
		</fieldset>
	
		<div id="list-ranking" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<g:if test="${ rankingInstanceList?.size()>0 }">			
			
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="categoria" title="${message(code: 'ranking.categoria.label', default: 'Categoría')}" />				
						
					
						<g:sortableColumn property="puesto" title="${message(code: 'ranking.puesto.label', default: 'Puesto')}" />
					
						<g:sortableColumn property="puntaje" title="${message(code: 'ranking.puntaje.label', default: 'Puntaje')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${rankingInstanceList}" status="i" var="rankingInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${rankingInstance.id}">${fieldValue(bean: rankingInstance, field: "categoria")}</g:link></td>
					
						<td>${fieldValue(bean: rankingInstance, field: "puesto")}</td>
					
						<td>${fieldValue(bean: rankingInstance, field: "puntaje")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${rankingInstanceTotal}" />
			</div>
			
				
			</g:if>
			
			<g:else>
			
				<h2>No se han cargado rankings todavia</h2>	
	
			</g:else>
			
		</div>
	</body>
</html>
