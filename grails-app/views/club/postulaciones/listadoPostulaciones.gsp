<%@ page import="sgt.PostulacionTorneo" %>
<%@ page import="sgt.Torneo" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
	<fieldset class="buttons">
    	<g:link controller="postulacionTorneo" action="listadoTorneosPostulables"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Postularse a Torneo</span> </g:link> 	
	</fieldset>
		<div id="list-club" class="content scaffold-list" role="main">
			<h1>Postulaciones a torneo</h1>
			<g:render template="/utils/messages"/>
			
			<g:if test="${ postulacionInstanceList.size()>0 }">			
			
			<table>
				<thead>
					<tr>	
						<g:sortableColumn property="fecha" title="Fecha" />
					
						<g:sortableColumn property="torneo.nombre" title="Torneo" />
					
						<g:sortableColumn property="estado" title="Estado" />
						
						<td></td>
					</tr>
				</thead>
				<tbody>
				<g:each in="${postulacionInstanceList}" status="i" var="postulacionInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:formatDate date="${ postulacionInstance.fecha }" format="dd/MM/yyyy"/></td>
					
						<td>${fieldValue(bean: postulacionInstance, field: "torneo")}</td>
					
						<td>${fieldValue(bean: postulacionInstance, field: "estado")}</td>
						
						<td><g:link controller="postulacionTorneo" action="cancelarPostulacion" id="${ postulacionInstance.id }">Cancelar</g:link></td>					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${postulacionInstanceTotal}" />
			</div>
			
				
			</g:if>
			
			<g:else>
			
				<h2>No existen postulaciones a torneos actualmente</h2>	
	
			</g:else>
			
		</div>
	</body>
</html>