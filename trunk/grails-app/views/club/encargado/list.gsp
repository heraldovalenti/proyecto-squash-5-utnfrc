<%@ page import="sgt.Usuario" %>
<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
	<fieldset class="buttons">
    		<g:link action="create" ><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-person"></span><span style="padding-left: 18px;">Nuevo Encargado</span> </g:link>
	</fieldset>
		<div id="list-encargados" class="content scaffold-list" role="main">
			<h1>Encargados de Club</h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:if test="${ !encargadosClub || encargadosClub.empty() }">
				<h2>No existen encargados registrados</h2>
			</g:if>
			<g:else>
				<table>
					<thead>
						<tr>
							<td>Nombre de Usuario</td>
							<td>Apellido</td>
							<td>Nombre</td>
							<td>Estado</td>
						</tr>
					</thead>
					<tbody>
					
					<g:each in="${encargadosClub}" status="i" var="encargado">
						<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
							<td>
								<g:link action="show" params="[encargado: encargado.id ]">
									${ encargado.nombreUsuario }
								</g:link>
							</td>
							<td>${ encargado.persona.apellido }</td>
							<td>${ encargado.persona.nombre }</td>
							<td>
								<g:formatBoolean boolean="${ encargado.activo }" 
								true="Activo" false="Inactivo"/>
							</td>
						</tr>
					</g:each>
					</tbody>
				</table>
				<div class="message">* Click sobre algun encargado para más opciones</div>		
			</g:else>
		</div>
	</body>
</html>
