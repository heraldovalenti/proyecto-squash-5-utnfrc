<%@ page import="sgt.Cancha"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>

<body>
	<fieldset class="buttons">
    	<g:link controller="cancha" action="create"><span  style="position: absolute; height: 20px"class="ui-icon ui-icon-circle-plus"></span><span style="padding-left: 18px;">Nueva Cancha</span> </g:link> 	
	</fieldset>
	<div id="list-cancha" class="content scaffold-list" >
		<h1>Listado de canchas del club</h1>
		<g:if test="${flash.message}">
			<div class="message" >
				${flash.message}
			</div>
		</g:if>
		<g:if test="${ !encargadosClub || encargadosClub.empty() }">
				<h2>No existen encargados registrados</h2>
		</g:if>
		<g:else>
		<table>
			<thead>
				<tr>
					<th>Numero</th>
					<th>Nombre</th>
					<th>Techada</th>
					<th>Tipo piso</th>
					<th>Disponibilidad</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${canchas}" status="i" var="cancha">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td style="text-align: center;">
							<g:link controller="cancha" action="show" params="[cancha: cancha.id]">
								${ cancha.numero }
							</g:link>
						</td>
						
						<td>	
							${ cancha.nombre }
						</td>

						<td>
							<g:formatBoolean boolean="${ cancha.techada }" true="Si" false="No"/>
						</td>
						
						<td>
							${ cancha.tipoSuelo }
						</td>
						
						<td>
							<g:link controller="disponibilidadCancha" 
							params="[idCancha: cancha.id]">Ver disponibilidad</g:link>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
		</g:else>
		<div class="message">* Click sobre el numero de alguna cancha para más opciones</div>
	</div>
</body>
</html>
