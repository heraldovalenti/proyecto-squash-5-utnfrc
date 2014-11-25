<%@ page import="sgt.Usuario" %>
<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link action="show" params="[encargado: usuarioEncargado.id]"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
		<div id="edit-encargado" class="content scaffold-edit" role="main">
			<h1>Encargado de Club</h1>
			<g:render template="/utils/messages"/>
			
			<g:form action="update">
				<g:hiddenField name="encargado" value="${usuarioEncargado?.id}" />
				
				<fieldset class="form">
					<g:render template="/club/encargado/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
