<%@ page import="sgt.Torneo"%>
<%@ page import="sgt.PostulacionTorneo"%>

<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>
<body>
	<div class="nav" role="navigation">
		<ul>
			<li><g:link controller="postulacionTorneo" action="listadoTorneosPostulables">Volver</g:link></li>
		</ul>
	</div>

	<div id="create-club" class="content scaffold-create" role="main">
		<h1>Postulacion a torneo</h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<g:hasErrors bean="${ postulacionInstance }">
			<ul class="errors" role="alert">
				<g:eachError bean="${postulacionInstance}" var="error">
					<li
						<g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
							error="${error}" /></li>
				</g:eachError>
			</ul>
		</g:hasErrors>
		<g:form controller="postulacionTorneo" action="save">
			<fieldset class="form">
			
				<div class="fieldcontain">
					<label for="torneo.nombre">
						Torneo
					</label>
					<label>${ torneoInstance.nombre }</label>
				</div>
				
				<div class="fieldcontain">
					<label for="torneo.fechaInicio">
						Fecha inicio
					</label>
					<label><g:formatDate date="${ torneoInstance.fechaInicioTorneo }" format="dd/MM/yyyy" /></label>
				</div>
				
				<div class="fieldcontain">
					<label for="torneo.fechaFin">
						Fecha fin
					</label>
					<label><g:formatDate date="${ torneoInstance.fechaFinTorneo }" format="dd/MM/yyyy" /></label>
				</div>
				
				<div class="fieldcontain ${hasErrors(bean: postulacionInstance, field: 'observaciones', 'error')} ">
					<label for="torneo.puntuable">
						Puntuable
					</label>
					<label><g:formatBoolean boolean="${ torneoInstance.puntuable }" true="Si" false="No" /></label>
				</div>
				
				<div class="fieldcontain ${hasErrors(bean: postulacionInstance, field: 'observaciones', 'error')} ">
					<label for="observaciones">
						Observaciones
					</label>
					<g:textArea name="observaciones" value="${ fieldValue(bean: postulacionInstance, field: "observaciones") }" />
				</div>
				
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Guardar" />
				<g:hiddenField name="idTorneo" value="${ torneoInstance.id }"/>
			</fieldset>
		</g:form>
	</div>
</body>
</html>
