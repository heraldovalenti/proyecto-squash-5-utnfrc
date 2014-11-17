<%@ page import="sgt.Partido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'partido.label', default: 'Partido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<r:require module="listaPartidosPorJugar"/>
	</head>	
	<body>
		<div class="nav" role="navigation">
			<ul>
				<li><g:link controller="partido" action="list1">Volver</g:link></li>
			</ul>
		</div>
		<div id="list-partido" class="content scaffold-list" role="main">
			<h1>Listado de Partidos por Disputarse				
				<g:textField name="fecha" id="datepicker" value="${formatDate(format:"dd/MM/yyyy", date:fechaSeleccionada)}" placeholder="Seleccione una fecha.." style="float: right; margin-right: 10px;"/>			
				<g:select name="categoria" from='${categorias}' value="${categoriaSeleccionada?.id }"
				optionKey="id" noSelection="['':'Todas']" class="profile-year" id="categoria" />
			</h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						
						<g:sortableColumn property="categoria" title="Categoria" style="text-align: center;" />
						
						<g:sortableColumn property="fecha" title="Fecha" style="text-align: center;" />	
						
						<g:sortableColumn property="horaDesde" title="Hora" style="text-align: center;" />
						
						<g:sortableColumn property="instancia" title="Instancia" style="text-align: center;" />			
												
						<g:sortableColumn property="jugador1.persona" title="Jugador 1" style="text-align: center;" />
						
						<g:sortableColumn property="jugador2.persona" title="Jugador 2" style="text-align: center;" />
											
					</tr>
				</thead>
				<tbody>
				<g:each in="${partidos}" status="i" var="partidoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">	
											
						<td style="text-align: center;"><g:link action="show1" id="${partidoInstance.id}">${fieldValue(bean: partidoInstance, field: "categoria")}</g:link></td>
						
						<td style="text-align: center;"><g:formatDate date="${partidoInstance?.fecha}"/></td>
						
						<td style="text-align: center;">${partidoInstance?.horaDesde}</td>		
						
						<td style="text-align: center;">${partidoInstance?.rondaPartidoString()}</td>
													
						<td style="text-align: center;"><g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:partidoInstance?.jugador1?.id,categoria:partidoInstance?.categoria]">${partidoInstance?.jugador1}</g:link></td>
						
						<td style="text-align: center;"><g:link controller="jugador" action="cargarPerfilCompleto" params="[usuario:partidoInstance?.jugador2?.id,categoria:partidoInstance?.categoria]">${partidoInstance?.jugador2}</g:link></td>	
												
																	
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
