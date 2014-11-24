<%@ page import="sgt.Torneo" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
	</head>
	<body>
		
		<fieldset class="buttons">
    		<g:link controller="torneo" action="list"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
		</fieldset>
		
		<div id="create-torneo" class="content scaffold-create" >
			<h1>Nuevo Torneo</h1>
			
			<g:render template="/utils/messages" />
			
			<g:form action="save" >
				<fieldset class="form">
					<g:render template="/administracion/torneos/form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="Guardar" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
