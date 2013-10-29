
<%@ page import="sgt.Categoria" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'categoria.label', default: 'Categoria')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		
		<div class="nav" role="navigation">
			<ul>
				<li><g:link controller="categoria" action="create">Nueva categoria</g:link></li>
			</ul>
		</div>
		<div id="list-categoria" class="content scaffold-list" role="main">
			<h1>Categorias</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nombre" title="${message(code: 'categoria.nombre.label', default: 'Nombre')}" />
					
						<g:sortableColumn property="descripcion" title="${message(code: 'categoria.descripcion.label', default: 'Descripcion')}" />
					
						<g:sortableColumn property="modalidadCategoria" title="${message(code: 'categoria.modalidadCategoria.label', default: 'Modalidad Categoria')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${categoriaInstanceList}" status="i" var="categoriaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${categoriaInstance.id}">${fieldValue(bean: categoriaInstance, field: "nombre")}</g:link></td>
					
						<td>${fieldValue(bean: categoriaInstance, field: "descripcion")}</td>
					
						<td>${fieldValue(bean: categoriaInstance, field: "modalidadCategoria")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${categoriaInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
