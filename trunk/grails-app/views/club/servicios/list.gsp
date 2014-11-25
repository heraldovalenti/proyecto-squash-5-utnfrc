<%@ page import="sgt.ServicioClub" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="club">
	</head>
	<body>
		<div id="list-servicios" class="content scaffold-list" role="main">
			<h1>Servicios ofrecidos en Club</h1>
			<g:render template="/utils/messages"/>
			
			<div id="servicios-club">
				<ul>
					<g:if test="${ serviciosClub }">
					<g:each in="${ serviciosClub }" var="servicio">
					<li>
						<span>${ servicio.nombre } - </span>
						<g:link action="quitarServicio" params="[servicio: servicio.id]">Quitar</g:link>
					</li>
					</g:each>
					</g:if>
				
					<g:else>
					<li>
						<h2>Aun no se han registrado servicios</h2>
					</li>
					</g:else>
				</ul>
			</div>
		</div>
		
		<g:if test="${ serviciosDisponibles }">
		<div id="list-servicios" class="content scaffold-create" role="main">
			<div id="servicios-disponibles">
				<g:form action="agregarServicio">
					<fieldset class="buttons">	
						<div class="fieldcontain">
							<label for="provincia">
								Agregar nuevo servicio:
							</label>
							<g:select name="nombre" from="${ serviciosDisponibles }" required=""/>
							<g:submitButton name="create" class="save" value="Guardar" />
						</div>
					</fieldset>
				</g:form>
			</div>
		</div>
		</g:if>
	</body>
</html>
