<%@page import="sgt.Categoria" %>
<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main" />
</head>
<body>
	<div class="box-968 fl">
	
		<div class="box box-335 fr mt10 mr5">
			<h3>informacion de torneo</h3>
			<div class="mt10 ml10 mr10 mb10">
				<ul id="news-result">
					<li>Inicio: <g:formatDate date="${ torneo.fechaInicioTorneo }" format="dd/MM/yyyy"/></li>
					<li>Finalizacion: <g:formatDate date="${ torneo.fechaFinTorneo }" format="dd/MM/yyyy"/></li>
				</ul>
				<br>
				<g:link controller="torneo" action="verTorneo" 
				params="[idTorneo: torneo.id]" class="button blue">Volver al torneo</g:link>
			</div>
		</div>
		<div class="box box-607 fl mt10 ml10 mb10" style="overflow: scroll;">
			<h3>Draw: ${ categoriaSeleccionada.categoria }</h3>
			
			<g:field type="hidden" name="categoria" value="${ categoriaSeleccionada.categoria }" />
			
			<g:render template="/administracion/fixture/verFixtureTorneo"/>
		</div>
		
		<g:render template="draws" />
		
	</div>
</body>
</html>