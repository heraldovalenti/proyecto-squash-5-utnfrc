<head>    	
        <r:require module="listaJugadores"/>
</head>
<body>
<div class="container_16 nav mt20">

    <ul id="menu">
        <li><a href="/SistemaGestionTorneo">Home</a></li>
        <li><a href="/SistemaGestionTorneo/acsInfo/">La ACS</a></li>
        <li><a href="#">Noticias</a></li>
        <li id="li-jugador"><g:link controller="jugador" action="obtenerJugadores" params="[categoria:'Primera']">Jugadores</g:link></li>             	
        <li><a href="/SistemaGestionTorneo/torneo/listaTorneos">Torneos</a></li>        
        <li><a href="/SistemaGestionTorneo/club/listarClubes">Clubes</a></li>
        <li><g:link controller="jugador" action="obtenerRankingJugadores" params="[categoria:'Primera']">Ranking</g:link></li>       
        <li><a href="#">Contacto</a></li>
        <li>
           <form action="#" method="get" name="searchForm" id="headerSearch" onsubmit="return false;">
			<input type="text" id="buscadorJugadores" placeholder="Ingrese un Jugador" name="search-top" class="autocomplete ac_input" id="search-top">
            <input type="hidden" id="jugadorId" class="autoCompId"/> 
            <div id="results-home" class="results results-h2h raised"></div>
            <input type="hidden" class="autoCompId" class="autoCompId"/> 
            <div id= "mostrarJugador">
               <span class="lupa"></span>
             </div> 
			</form>
        </li>
    </ul>
</div>
</body>