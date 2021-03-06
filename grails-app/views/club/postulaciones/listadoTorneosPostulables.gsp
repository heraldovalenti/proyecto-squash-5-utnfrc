<%@ page import="sgt.Torneo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link controller="postulacionTorneo" action="listadoPostulaciones"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
		<div id="list-club" class="content scaffold-list" role="main">
			<h1>Torneos postulables</h1>
			<g:render template="/utils/messages"/>
			
			<table>
				<thead>
					<tr>	
						<g:sortableColumn property="nombre" title="Nombre" />
					
						<g:sortableColumn property="fechaInicio" title="Fecha inicio" />
					
						<g:sortableColumn property="fechaFin" title="Fecha fin" />
						
						<g:sortableColumn property="puntuable" title="Puntuable" />
						
						<g:sortableColumn property="estado" title="Estado" />
						
						<td></td>
					</tr>
				</thead>
				<tbody>
				<g:each in="${torneoInstanceList}" status="i" var="torneoInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td>${fieldValue(bean: torneoInstance, field: "nombre")}</td>
						
						<td>
							<g:formatDate date="${ torneoInstance.fechaInicioTorneo }" format="dd/MM/yyyy"/>
						</td>
						
						<td><g:formatDate date="${ torneoInstance.fechaFinTorneo }" format="dd/MM/yyyy"/></td>
					
						<td><g:formatBoolean boolean="${ torneoInstance.puntuable }" true="Si" false="No"/></td>
						
						<td>${fieldValue(bean: torneoInstance, field: 'estado')}</td>
						
						<td><g:link controller="postulacionTorneo" action="postulacion" id="${ torneoInstance.id }">Postulacion</g:link></td>					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${torneoInstanceTotal}" />
			</div>
		</div>
	</body>
</html>