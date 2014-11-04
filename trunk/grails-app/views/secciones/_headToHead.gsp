<%@ page import="sgt.Usuario" %>
<head>    	
        <r:require module="headToHead"/>
</head>
<body>
<div class="h2h-home mt10">
	<h3 class="title">HEAD TO HEAD</h3>
	<div class="moduleContentOuter">
		<div class="moduleContentInner">
			<div class="head2headPremade">
				<div class="actionShot IE6pngFix">
					<img width="111" height="144" 
				src="<g:imagenPerfilJugador usuario="${ jugador1 }"/>" />
				</div>
				<div class="head2headPreStats raised IE6pngFix">
					<h4>HISTORIAL DE PARTIDOS</h4>
					<a class="head2headPreName1 pb10" id="jugador1Perfil"></a> 
					<a class="head2headPreName2 pb10" id="jugador2Perfil"></a>
					<p class="head2headPreScore" id="versus"></p>
					
				</div>
				<div class="actionShot  IE6pngFix">
					<img width="111" height="144" 
				src="<g:imagenPerfilJugador usuario="${ jugador2 }"/>" />
				</div>
			</div>
			<p>
				Ingrese el nombre o apellido de los jugadores y seleccionar de la lista para
				ver la comparación.<br>
			</p>
			<g:form controller="jugador" action="verEnfrentamientoJugadores" class="head2headEntryFields">
				<div class="head2headEntryField1">					
					<g:hiddenField name="jugador1" id="jugador1"/>	
					<g:textField name="jugador1Text" id="jugador1Text" class="autocomplete ac_input" value="${jugador1?.persona}" placeholder="Ingrese el Jugador 1.."/>					
				</div>
				<p>VS</p>
				<div class="head2headEntryField2">
					<g:hiddenField name="jugador2" id="jugador2"/>	
					<g:textField name="jugador2Text" id="jugador2Text" class="autocomplete ac_input"value="${jugador2?.persona}" placeholder="Ingrese el Jugador 2.."/>					
				</div>
				<div class="genericButton">
				<g:submitButton name="comparar" class="btn btn-primary btn-sm" style="margin: -10px 20px;" value="Comparar"/>
				<%--<g:link controller="jugador" action="verEnfrentamientoJugadores" class="button_small blue" style="margin: 3px;">Comparar</g:link>					
				--%></div>
			</g:form>
		</div>
	</div>
</div>
</body>
