<%@ page import="sgt.Torneo" %>
<%@ page import="sgt.DetalleTorneo" %>
<%@ page import="sgt.Categoria" %>

<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
</head>
<body>
	<h3>Inscripcion a torneo</h3>
	
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>		
			
	<div>
		<fieldset class="form">
			<div class="fieldcontain ${hasErrors(bean: categoriaJugadorInstance, field: 'categoria', 'error')} ">
				<label for="categoria">Inscripción en Categoría:</label>
				<g:each in="${ detalleTorneoInstanceList }" status="i" var="detalle">
					<g:link controller="inscripcionTorneo" action="inscribir" id="${ detalle?.id }">
						${ detalle?.categoria?.toString() } - 
					</g:link>
				</g:each>
			</div>
		</fieldset>
	</div>		
	
	<div>
		<p>INFORMACION DE TORNEO</p>
		<p>(_torneoCard.gsp)</p>
	</div>
</body>
</html>
