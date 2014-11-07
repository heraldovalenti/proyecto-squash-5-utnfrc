
<%@ page import="sgt.Partido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'partido.label', default: 'Partido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-partido" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link class="list" controller="torneo" action="show" id="${torneoInstance.id}">Volver</g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li><g:link class="list" controller="partido" action="listarResultadosPartidosTorneo">Informe Resultados Partidos</g:link></li>
			</ul>
		</div>
		<div id="list-partido" class="content scaffold-list" role="main">
			<h1>Listado de partidos de ${torneoInstance.nombre}</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						
						<g:sortableColumn property="categoria" title="Categoria" />
						
						<g:sortableColumn property="fecha" title="Fecha" />
						
						<g:sortableColumn property="horaDesde" title="Hora" />
						
						<g:sortableColumn property="jugador1.persona" title="Jugador 1" />
						
						<g:sortableColumn property="jugador2.persona" title="Jugador 2" />
						
						<th></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${partidoInstanceList}" status="i" var="partidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">	
											
						<td><g:link action="show1" id="${partidoInstance.id}">${fieldValue(bean: partidoInstance, field: "categoria")}</g:link></td>
						
						<td><g:formatDate date="${partidoInstance.fecha}"/></td>
						
						<td>${fieldValue(bean: partidoInstance, field: "horaDesde")}</td>
						
						<td><g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:partidoInstance?.jugador1?.id,categoria:partidoInstance?.categoria]">${fieldValue(bean: partidoInstance, field: "jugador1")}</g:link></td>
						
						<td><g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:partidoInstance?.jugador2?.id,categoria:partidoInstance?.categoria]">${fieldValue(bean: partidoInstance, field: "jugador2")}</g:link></td>							
																	
						<td>
							<g:if test="${ !partidoInstance.esSingle() }">
								<g:link controller="resultadoPartido" action="cargarResultado" id="${partidoInstance.id}" >
								<g:if test="${ !partidoInstance.finalizado() }">Cargar Resultado</g:if>
								<g:else>Ver resultado</g:else>
								</g:link>
							</g:if>
						</td>
						
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${partidoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
