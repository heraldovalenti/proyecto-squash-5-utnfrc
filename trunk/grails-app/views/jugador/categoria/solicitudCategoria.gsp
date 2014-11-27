<%@ page import="sgt.Categoria" %>
<%@ page import="sgt.CategoriaJugador" %>

<html>
<head>
	<meta name="layout" content="jugador">
</head>
<body>
	<h3>Solicitud de Categoria de jugador</h3>
	
	<fieldset class="buttons">
    		<g:link controller="jugador" action="categorias"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link> 	
	</fieldset>
	
	<div id="create-categoriaJugador" class="content scaffold-create">
	
		<g:render template="/utils/messages" />
		
		<g:form controller="jugador" action="saveSolicitudCategoria" >
			<fieldset class="form">
				
				<div class="fieldcontain required">
					<label for="categoria">Categoria</label>
					<g:select optionKey="id" optionValue="nombre" name="idCategoria" 
					from="${ categorias }" noSelection="['': '']" required="" />
				</div>
		
			</fieldset>
			<fieldset class="buttons">
				<g:submitButton name="create" class="save" value="Solicitar categoria" />
			</fieldset>
		</g:form>
	</div>
</body>
</html>