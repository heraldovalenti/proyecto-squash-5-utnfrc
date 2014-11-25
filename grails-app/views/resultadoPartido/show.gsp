<%@ page import="sgt.Partido" %>
<%@ page import="sgt.ResultadoPartido" %>
<%@ page import="sgt.DetalleResultados" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link controller="partido" action="show1" id="${ partido.id }"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
		
		<div id="show-resultadoPartido" class="content scaffold-show">
			<h1>Resultado de partido</h1>
			
			<g:render template="/utils/messages" />
			
			<g:form>
				<table>
					<thead>
						<tr>
							<th></th>
							<th>${ partido.jugador1.persona }</th>
							<th>${ partido.jugador2.persona }</th>
						</tr>
					</thead>
					<tbody>
						<g:if test="${ !resultado }">
						<tr>
							<g:field type="hidden" name="nuevo_set" value="true"/>
							<td>1er Set</td>
							<td><g:field name="nuevo_set_1" type="number" min="1" max="20" required="" autofocus="true"/></td>
							<td><g:field name="nuevo_set_2" type="number" min="1" max="20" required=""/></td>
						</tr>
						</g:if>
						
						<g:else>
						<g:each in="${ detalles }" var="d">
						<tr>
							<td>${ d.setString() }</td>
							<td><g:field name="${ d.nroSet }set_1" type="number" min="1" max="20" value="${ d.jugador1 }" required="" /></td>
							<td><g:field name="${ d.nroSet }set_2" type="number" min="1" max="20" value="${ d.jugador2 }" required="" /></td>
						</tr>
						</g:each>
						</g:else>
						
						<g:if test="${ nuevoSet }">
						<tr>
							<g:field type="hidden" name="nuevo_set" value="true"/>
							<td>${ nuevoSet.setString() } - <g:link action="cargarResultado" id="${ partido.id }">Cancelar</g:link></td>
							<td><g:field name="nuevo_set_1" type="number" min="1" max="20" required="" autofocus="true"/></td>
							<td><g:field name="nuevo_set_2" type="number" min="1" max="20" required=""/></td>
						</tr>
						</g:if>
					</tbody>
				</table>
				
				<div class="fieldcontain">
					<label for="ganador">Ganador</label>
					<g:select id="ganador" name="ganador" 
						noSelection="[ '': '---']"
						from="[partido.jugador1.persona, partido.jugador2.persona]" 
						keys="[partido.jugador1.id, partido.jugador2.id]" value="${ resultado?.ganador?.id }" />
				</div>
				
				<g:if test="${ !partido.finalizado() }">
				<div class="fieldcontain">
					<label for="ganador">Finalizar partido</label>
					<g:checkBox name="finalizar_partido" value="finalizar_partido" checked="false" />
					<span>(Una vez finalizado el partido no se podrá editar el resultado)</span>
				</div>
				</g:if>
				
				<g:if test="${ !partido.finalizado() }">
				<fieldset class="buttons">
					<g:if test="${ !partido.finalizado() }">
						<g:actionSubmit class="save" action="save" value="Guardar" />
					</g:if>
					<g:if test="${ detalles.size() > 1 && detalles.size() <= 5 && !partido.finalizado() }">
						<g:actionSubmit class="delete" action="eliminarSet" value="Eliminar ultimo set" />
					</g:if>
					<g:if test="${ detalles.size() >= 1 && detalles.size() < 5 && !partido.finalizado() }">
						<g:actionSubmit action="agregarSet" value="Agregar set" />
					</g:if>
					<g:field type="hidden" name="partido" value="${ partido.id }"/>
				</fieldset>
				</g:if>
			</g:form>
		</div>
	</body>
</html>
