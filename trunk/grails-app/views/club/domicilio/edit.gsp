<%@ page import="sgt.Domicilio" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<g:if test="${ domicilioInstance?.id }">
			<g:link action="showDomicilio">Volver</g:link>
		</g:if>
		<div id="edit-domicilio" class="content scaffold-create" role="main">
			<h1>Domicilio de club</h1>
			<g:if test="${ flash.message }">
			<div class="message" role="status">
				${ flash.message }
			</div>
			</g:if>
			<g:if test="${ flash.errors }">
				<ul class="errors" role="alert">
					<g:each in="${ flash.errors }" var="error">
						<li>${ error }</li>
					</g:each>
				</ul>
			</g:if>
			<g:if test="${ flash.exception }">
				<ul class="errors" role="alert">
					<li>${ flash.exception.message }asdf</li>
				</ul>
			</g:if>
			
			<g:form action="saveDomicilio">				
				<fieldset class="form">
					<g:render template="/club/domicilio/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
