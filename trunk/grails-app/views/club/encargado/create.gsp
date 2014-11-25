<%@ page import="sgt.Usuario" %>
<%@ page import="sgt.Persona" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<fieldset class="buttons">
    		<g:link action="index"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
		<div id="create-encargado" class="content scaffold-create" role="main">
			<h1>Encargado de Club</h1>
			<g:render template="/utils/messages"/>
			
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="/club/encargado/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Registrar encargado" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
