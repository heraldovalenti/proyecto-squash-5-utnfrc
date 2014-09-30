<%@ page import="sgt.Cancha"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>
<body>
	<g:link controller="cancha" action="show" params="[cancha: cancha.id]">Volver</g:link>
	<div id="edit-cancha" class="content scaffold-edit" >
		
		<h1>Datos de cancha</h1>
		<g:render template="/utils/messages"/>
		
		<g:form method="post" action="update" >
			<g:hiddenField name="cancha" value="${cancha?.id}" />
			<fieldset class="form">
				<g:render template="/club/canchas/form" />
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Guardar" />			
				<g:link elementId="deletion-button" class="delete" controller="cancha" 
					action="delete"	params="[cancha: cancha.id]">Eliminar</g:link>
			</fieldset>
		</g:form>
	</div>
	<r:require modules="deletion"/>
</body>
</html>
