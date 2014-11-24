
<%@ page import="sgt.Partido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'partido.label', default: 'Partido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link controller="torneo" action="show" id="${torneoInstance.id}"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link>
    		<g:link controller="partido" action="create"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Nuevo Partido</span> </g:link> 
    		<g:link controller="partido" action="listarResultadosPartidosTorneo"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-document"></span><span style="padding-left: 18px;">Informe Resultados Partidos</span></g:link>
			<g:link controller="partido" action="listarPartidosPorJugar"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-document"></span><span style="padding-left: 18px;">Informe Partidos por Jugar</span></g:link> 	
		</fieldset>
				
	
		<div id="list-partido" class="content scaffold-list" role="main">
			<h1>Listado de partidos de ${torneoInstance.nombre}</h1>
			
			<g:render template="/utils/messages" />
			
			<g:if test="${ partidoInstanceList?.size()>0 }">

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
		</g:if>
			
		<g:else>
			
			<h2>No hay partidos registrados en el torneo</h2>	
	
		</g:else>
		</div>
	</body>
</html>
