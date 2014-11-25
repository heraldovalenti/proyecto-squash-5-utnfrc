<%@ page import="sgt.Cancha"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="club">
</head>

<body>
	<fieldset class="buttons">
    	<g:link controller="cancha" action="list"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
	</fieldset>
	<div id="create-cancha" class="content scaffold-create" >
		<h1>Registro de nueva cancha</h1>
		<g:render template="/utils/messages"/>
		
		<g:form action="save">
			<fieldset class="form">
				<g:render template="/club/canchas/form" />
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Guardar" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>
