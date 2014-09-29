
<%@ page import="sgt.Cancha"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>

<body>
	<g:link class="create" action="create" controller="cancha" namespace="club">Registrar nueva cancha</g:link>

	<div id="list-cancha" class="content scaffold-list" role="main">
		<h1>Listado de canchas del club</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<table>
			<thead>
				<tr>

					<g:sortableColumn property="nombre"
						title="${message(code: 'cancha.nombre.label', default: 'Nombre')}" />

					<g:sortableColumn property="tipoSuelo"
						title="${message(code: 'cancha.tipoSuelo.label', default: 'Tipo Suelo')}" />

					<g:sortableColumn property="ancho"
						title="${message(code: 'cancha.ancho.label', default: 'Ancho')}" />

					<g:sortableColumn property="largo"
						title="${message(code: 'cancha.largo.label', default: 'Largo')}" />

					<th>Disp. horaria</th>

				</tr>
			</thead>
			<tbody>
				<g:each in="${canchaInstanceList}" status="i" var="canchaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link controller="cancha" action="show" namespace="club"
								id="${canchaInstance.id}">
								${fieldValue(bean: canchaInstance, field: "nombre")}
							</g:link></td>

						<td>
							${fieldValue(bean: canchaInstance, field: "tipoSuelo")}
						</td>

						<td><g:link action="show" id="${canchaInstance.id}">
								${fieldValue(bean: canchaInstance, field: "ancho")}
							</g:link></td>

						<td>
							${fieldValue(bean: canchaInstance, field: "largo")}
						</td>

						<td><g:if test="${ canchaInstance.disponibilidad }">Cargada</g:if>
							<g:else>Sin especificar</g:else></td>

					</tr>
				</g:each>
			</tbody>
		</table>
		* Click en alguna cancha para más opciones
	</div>
</body>
</html>
