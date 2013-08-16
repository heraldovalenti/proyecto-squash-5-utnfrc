<div id="atpNavBar">
	<div class="container_16" id="tour">
		<g:if test="${ !session.getAttribute("userLogon") }">
			<div class="tour-title tour-more fr">
				<g:link controller="usuario" action="registro" class="button_small blue" style="margin: 3px;">
					REGISTRARSE	
				</g:link>
			</div>
			<div class="tour-title tour-more fr">
				<g:link controller="usuario" action="loginForm" class="button_small green" style="margin: 3px;">
					INGRESAR	
				</g:link>
			</div>
		</g:if>
		<g:if test="${ session.getAttribute("userLogon") }">
			<div class="tour-title tour-more fr">
				<g:link controller="usuario" action="logout" class="button_small blue" style="margin: 3px;">
					SALIR	
				</g:link>
			</div>
			<div class="tour-title tour-more fr">
				Bienvenido ${ session.getAttribute("userLogon").nombreUsuario }
			</div>
		</g:if>
	</div>
</div>