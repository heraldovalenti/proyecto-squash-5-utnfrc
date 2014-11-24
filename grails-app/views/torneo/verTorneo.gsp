<%@ page import="sgt.Torneo" %>

<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main">
	<r:require module="jquery"/>
</head>
<body>
	<div class="box-968 fl">
		
		<g:render template="/utils/messages" />
		
		<g:if test="${ !torneo }">
			<h2>Torneo no encontrado...</h2>
		</g:if>
		
		<g:if test="${ torneo }">
			
			<g:render template="fichaTorneo" model="[torneo: torneo]"/>
		
			<g:render template="inscripcionTorneo" model="[torneo: torneo]"/>
			
			<g:render template="draws" model="[torneo: torneo]"/>
			
			<g:render template="quienesJuegan" model="[torneo: torneo]"/>
			
			<g:render template="diagramacionTorneo" model="[diagramacion: diagramacion]"/>
			
		</g:if>
		
	</div>
</body>
</html>