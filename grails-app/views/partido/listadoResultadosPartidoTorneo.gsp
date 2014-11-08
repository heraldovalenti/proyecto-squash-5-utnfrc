<%@ page import="sgt.Partido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'partido.label', default: 'Partido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<r:require module="listaResultadosPartidos"/>
	</head>	
	<body>
		<a href="#list-partido" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<%--<li><g:link class="list" controller="torneo" action="show" id="${torneoInstance.id}">Volver</g:link></li>				
			--%></ul>
		</div>
		<div id="list-partido" class="content scaffold-list" role="main">
			<h1>Informe de Resultados de partidos <g:select name="categoria" from='${categorias}' value="${categoriaSeleccionada?.id }"
					optionKey="id" noSelection="['':'Todas']" class="profile-year" id="categoria" style="margin-left: 25%;
margin-right: 5%;"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						
						<g:sortableColumn property="categoria" title="Categoria" />
						
						<g:sortableColumn property="fecha" title="Fecha" />	
						
						<g:sortableColumn property="instancia" title="Instancia" />			
												
						<g:sortableColumn property="jugador1.persona" title="Jugador 1" />
						
						<g:sortableColumn property="jugador2.persona" title="Jugador 2" />
						
						<g:sortableColumn property="resultado" title="Resultado" />
											
					</tr>
				</thead>
				<tbody>
				<g:each in="${partidos}" status="i" var="partidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">	
											
						<td><g:link action="show1" id="${partidoInstance.id}">${fieldValue(bean: partidoInstance, field: "categoria")}</g:link></td>
						
						<td><g:formatDate date="${partidoInstance.fecha}"/></td>	
						
						<td>${partidoInstance.rondaPartidoString()}</td>
													
						<td><g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:partidoInstance?.jugador1?.id,categoria:partidoInstance?.categoria]">${fieldValue(bean: partidoInstance, field: "jugador1")}</g:link></td>
						
						<td><g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:partidoInstance?.jugador2?.id,categoria:partidoInstance?.categoria]">${fieldValue(bean: partidoInstance, field: "jugador2")}</g:link></td>	
						
						<td><g:link controller="resultadoPartido" action="cargarResultado" id="${partidoInstance?.resultado?.id}">${partidoInstance?.resultado?.calcularSets()[0]?.toString()} - ${partidoInstance?.resultado?.calcularSets()[1]?.toString()} </g:link></td>						
																	
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${totalPartidos}" />
			</div>
		</div>
	</body>
</html>
