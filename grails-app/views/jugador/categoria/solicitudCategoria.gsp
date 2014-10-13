<%@ page import="sgt.Categoria" %>
<%@ page import="sgt.CategoriaJugador" %>

<html>
<head>
	<meta name="layout" content="jugador">
</head>
<body>
	<h3>Solicitud de Categoria de jugador</h3>
	<g:link controller="jugador" action="categorias">Volver</g:link>
	
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