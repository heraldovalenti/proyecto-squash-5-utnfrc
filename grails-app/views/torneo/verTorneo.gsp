<%@ page import="sgt.Torneo" %>

<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
</head>
<body>
	<div class="box-968 fl">
		
		<g:render template="/utils/messages" />
		
		<g:if test="${ !torneo }">
			<h2>Torneo no encontrado...</h2>
		</g:if>
		
		<g:if test="${ torneo }">
			
			<g:render template="/torneo/fichaTorneo" model="[torneo: torneo]"/>
		
			<g:if test="${ torneo.inscripcionAbierta() }">
			<div class="box box-335 fr mt10 mr5">
				<h3>Inscripcion online</h3>
				<div class="mt10 ml10 mr10 mb10">
					<g:link controller="inscripcionTorneo" action="inscribirJugadorTorneo" 
					params="[idTorneo: torneo.id]" class="button green">Inscripción</g:link>
				</div>
			</div>
			</g:if>
			
		</g:if>
		
	</div>
</body>
</html>