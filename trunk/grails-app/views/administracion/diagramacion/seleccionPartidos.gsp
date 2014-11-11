<%@ page import="sgt.Partido" %>
<%@ page import="sgt.Torneo" %>

<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="administracion">
</head>
<body>
	<div class="nav">
		<ul>
			<li><g:link action="verTorneo" >Volver</g:link>
			<li><g:link action="diagramacionHorarios" id="${ torneo.id }">Diagramacion manual</g:link>
		</ul>
	</div>
	<div id="seleccion-partidos" class="content scaffold-create">
		<h1>Seleccion de partidos para diagramacion automatica</h1>
			
		<g:render template="/utils/messages" />
		
		<g:form method="post">
			<fieldset class="form">
				<div class="fieldcontain">
					<label for="fechaInicioTorneo">
						Duracion torneo
					</label>	
					${ formatDate(format: 'dd/MM/yyyy', date: torneo.fechaInicioTorneo) } -
					${ formatDate(format: 'dd/MM/yyyy', date: torneo.fechaFinTorneo) }
				</div>
				
				<div class="fieldcontain required">
					<label for="incluirDiagramados">
						Incluir partidos diagramados
					</label>	
					<g:checkBox name="incluirDiagramados" value="${ ( params['incluirDiagramados'] != null ) }"/>
				</div>
				
				<div class="fieldcontain required">
					<label for="categoria">
						Categoria
					</label>	
					<g:select name="categoria" from="${ categorias }" optionKey="id" 
						value="${ categoria }" noSelection="[ '' : 'Todas']"/>
				</div>
				
				<div class="fieldcontain required">
					<label for="ronda">
						Ronda
					</label>	
					<g:select name="ronda" from="${ valuesRonda }" keys="${ keysRonda }" 
						value="${ ronda }" noSelection="[ '' : 'Todas']"/>
				</div>
				
				<div class="fieldcontain required">
					<label for="fechaInicioDiagramacion">
						Fecha inicio diagramacion
						<span class="required-indicator">*</span>
					</label>	
					<g:textField name="fechaInicio" class="date-picker" 
						value="${ (fechaInicio) ? formatDate(format: 'dd/MM/yyyy', date: fechaInicio) : formatDate(format: 'dd/MM/yyyy', date: torneo.fechaInicioTorneo) }"
						placeholder="Seleccione una fecha" />
				</div>
				
				<div class="fieldcontain required">
					<label for="fechaFinDiagramacion">
						Fecha inicio diagramacion
						<span class="required-indicator">*</span>
					</label>	
					<g:textField name="fechaFin" class="date-picker"
						value="${ (fechaFin) ? formatDate(format: 'dd/MM/yyyy', date: fechaFin) : formatDate(format: 'dd/MM/yyyy', date: torneo.fechaFinTorneo) }"
						placeholder="Seleccione una fecha" />
				</div>
			</fieldset>
			
			<fieldset class="buttons">
				<g:field type="hidden" name="id" value="${ torneo.id }"/>
				<g:actionSubmit action="seleccionarPartidos" value="Aplicar filtros" />
				<g:actionSubmit action="generarDiagramacion" id="${ torneo.id }" value="Generar diagramacion"/>
			</fieldset>
			
			<div id="partidos">
				<table>
					<thead>
						<tr>
							<th class="select-all"></th>
							<th>Categoria</th>
							<th>Ronda</th>
							<th>Jugador 1</th>
							<th>Jugador 2</th>
							<th>Fecha</th>
							<th>Horario</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${ partidos }" var="p" status="i">
							<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
								<td><g:checkBox name="partido-${ p.id }" value="${ ( params['partido-' + p.id] ) != null }" class="selectable" /></td>
								<td>${ p.categoria }</td>
								<td>${ p.rondaPartidoString() }</td>
								<td>${ p.jugador1 }</td>
								<td>${ p.jugador2 }</td>
								<td>
									<g:if test="${ p.fecha }">
										<g:formatDate format="dd/MM/yyyy" date="${ p.fecha }"/>
									</g:if>
								</td>
								<td>
									<g:if test="${ p.horaDesde && p.horaHasta }">
										${ p.horaDesde }:00 - ${ p.horaHasta }:00
									</g:if>
								</td>
							</tr>
						</g:each>
					</tbody>
				</table>
			</div>
		</g:form>
	</div>
	<r:require modules="fechasTorneo, selection"/>
</body>
</html>