<%@ page import="sgt.Partido" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="administracion">
		<g:set var="entityName" value="${message(code: 'partido.label', default: 'Partido')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<r:require module="listaPosicionesTorneo"/>
	</head>	
	<body>
	
		<fieldset class="buttons">
    		<g:link controller="torneo" action="show" id="${torneoInstance.id}"><span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span><span style="padding-left: 18px;">Volver</span> </g:link>
		</fieldset>
		
		<div id="list-partido" class="content scaffold-list" role="main">
			<h1>Posiciones del torneo (${categoriaSeleccionada?.toString()}) <g:select name="categoria" from='${categorias}' value="${categoriaSeleccionada?.id }"
					optionKey="id" class="profile-year" id="categoria" style="margin-left: 10%;
margin-right: 5%;"/></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>				
				<tbody>
				<g:each in="${jugadores}" status="i" var="jugadorInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">	
					
						<td style="width: 7%;background: #efefef"><span class="photo"><img width="50" height="50"
							src="<g:imagenPerfilJugador usuario="${ jugadorInstance }"/>" /></span></td>

						<td style="background: #efefef"> 
							<a style="border-right: 1px solid white; font-size: 20px; font-weight: bold; text-align: center; width: 29px;">
								${ i + 1 } -
						 	<g:link style="font-size:18px;font-weight: bold;color:#C20046" controller="jugador" action="cargarPerfilCompleto"
								params="[usuario:jugadorInstance?.id,categoria:categoriaSeleccionada,tipo:'Jugador']">
								${jugadorInstance?.toString()}
							</g:link>
							</a>
						</td>
							

					</tr>
				</g:each>
				</tbody>
			</table>
			<%--<div class="pagination">
				<g:paginate total="${totalJugadores}" />
			</div>
		--%></div>
	</body>
</html>