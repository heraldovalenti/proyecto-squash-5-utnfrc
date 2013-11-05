<script type="text/javascript" src="submenus.js"></script>

<div class="box mb10 box-335">
	<div id="news-result" class="inner-box">   
	
		<ul class="ul-admin">
			<li><g:link controller="administracion">Panel de inicio</g:link></li>
			
			<li id="seccion1" onmouseover="ver(1)" onmouseout="ocultar(1)">
			<g:link controller="torneoPuntuable">Torneos Puntuables</g:link>
					<div id="subseccion1">
				        <p><g:link class="create" controller="torneoPuntuable" action="create" namespace="admin">Nuevo Torneo Puntuable</g:link></p>
   			      </div>			
			</li>
			
			<li id="seccion2" onmouseover="ver(2)" onmouseout="ocultar(2)">
			<g:link controller="torneo">Torneos</g:link>
					<div id="subseccion2">
				        <p><g:link class="create" controller="torneo" action="create" namespace="admin">Nuevo Torneo</g:link></p>
   			      </div>			
			</li>
			
			<li id="seccion2" onmouseover="ver(3)" onmouseout="ocultar(3)">
     		<g:link controller="partido">Partidos</g:link>
     			<div id="subseccion3">
				        <p><g:link class="create" controller="partido" action="create" namespace="admin">Nuevo Partido</g:link></p>
   			      </div>	
     		
     		</li>						
			<li><g:link controller="puntaje">Puntajes</g:link></li>			
			<li><g:link controller="ranking">Rankings</g:link></li>
			<li><g:link controller="categoria">Categorias</g:link></li>
			<li><g:link controller="solicitudCategoria">Solicitudes de categoria</g:link></li>
			<li><g:link controller="usuario" action="logout">Cerrar sesión</g:link></li>					
		</ul>
	</div>
</div>

<script type="text/javascript">
function ver(n) {
         document.getElementById("subseccion"+n).style.display="block"
         }
function ocultar(n) {
         document.getElementById("subseccion"+n).style.display="none"
         }
</script>
  

<style type="text/css">
    #subseccion1, #subseccion2, #subseccion3, #subseccion4 
     { position: relative; top: 100%; left: 0px;  
            font:normal 0.8em arial; padding: 0.2em 0.5em ;  display: none;}	

</style>