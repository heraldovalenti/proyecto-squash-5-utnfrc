<div id="atpNavBar">
	<div class="container_16" id="tour">
		<g:if test="${ session.getAttribute("userLogon") }">
		<div class="tour-title tour-more fr">
			<g:link controller="usuario" action="logout" class="button_small blue" style="margin: 3px;">
				SALIR	
			</g:link>
		</div>
		
		<div class="tour-title tour-more fr" style="float:left; position:absolute; padding-left: 5px; padding-right: 5px;">
			Bienvenido ${ session.getAttribute("userLogon").nombreUsuario }
		</div>
		
		<div class="tour-title tour-more fr">
			<g:link controller="club" action="index" class="button_small green" style="margin: 3px">
			Panel de control personal
			</g:link>
		</div>
		</g:if>
	</div>
</div>