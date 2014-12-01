<html>
    <head>
        <meta name="layout" content="administracion">
		<link href="${resource(dir: 'css', file: 'calendar.css') }" type="text/css" rel="stylesheet">
	</head>
    <body>
    
	    <fieldset class="buttons">
    		<g:link action="diagramacionHorarios" id="${ torneo.id }">
    			<span  style="position: absolute; height: 23px"class="ui-icon ui-icon-arrowthickstop-1-w"></span>
    			<span style="padding-left: 18px;">Volver</span>
   			</g:link>
		</fieldset>

    	<h1 class="mb20">Disponibilidad horaria - ${ usuario.persona.toString() }</h1>
    	
    	<g:if test="${ disponibilidad }">
    	
    	<table class="calendar">
		    <thead>
		        <tr>
		            <td class="time-hour"></th>
	                <td class="time-hour">Lunes</th>
	                <td class="time-hour">Martes</th>
	                <td class="time-hour">Miercoles</th>
	                <td class="time-hour">Jueves</th>
	                <td class="time-hour">Viernes</th>
	                <td class="time-hour">Sabado</th>
	                <td class="time-hour">Domingo</th>
	            <tr>
		    </thead>
		    <tbody>
	        	<g:each in="${ disponibilidad }" var="hora" status="i">
				<tr>
					<td class="time-hour">${ ( i + 8 ) }:00</td>
					
					<g:each in="${ hora }" var="dia">
						<g:if test="${ dia == 1 }">
							<td class="selected"></td>
						</g:if>
						<g:else>
							<td></td>
						</g:else>
					</g:each>
					
				</tr>	        	
		        </g:each>
		    </tbody>
		</table>
    	
    	<div style="margin: 20px">
			<h3 class="title-grey">Referencias</h3>
			<ul style="margin: 10px; list-style: none;">
				<li style="margin-bottom: 10px;">
					<div>
						<div style="height: 20px; width: 40px; border: 2px solid; background: #5882FA; float: left;"></div>
						<span style="line-height: 20px; margin: 0px 20px;">Horario disponible</span>
					</div>
				</li>
				<li style="margin-bottom: 10px;">
					<div>
						<div style="height: 20px; width: 40px; border: 2px solid; background: #FFFFFF; float: left;"></div>
						<span style="line-height: 20px; margin: 0px 20px;">Horario NO disponible</span>
					</div>
				</li>
			</ul>
		</div>
    	
    	</g:if>
    	
    	<g:else>
    	<p>El jugador no tiene cargada su disponibilidad horaria.</p>
    	</g:else>
	</body>
</html>