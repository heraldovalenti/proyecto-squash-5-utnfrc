<%@ page import="sgt.Club" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>
<body>
	<div id="create-club" class="content scaffold-create" role="main">
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
				<li>${ flash.exception }</li>
			</ul>
		</g:if>
		<g:form action="save" method="post" name="form-datos-club" enctype="multipart/form-data">
			<fieldset class="form">
				<g:render template="form" />
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Guardar" />
			</fieldset>
		</g:form>
	</div>
	<r:require modules="imagenes, club"/>
</body>
</html>
