<%@ page import="sgt.Club" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>
<body>
	<g:link controller="club" action="datosClub">Volver</g:link>
	<div id="edit-club" class="content scaffold-edit" role="main">
		<h1>Datos de Club</h1>
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
				<li>${ flash.exception.message }</li>
			</ul>
		</g:if>
		<g:form action="update" method="post" name="form-datos-club" enctype="multipart/form-data">
			<fieldset class="form">
				<g:render template="form"/>
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Guardar" />
			</fieldset>
		</g:form>
	</div>
	<r:require modules="imagenes, club"/>
</body>
</html>
