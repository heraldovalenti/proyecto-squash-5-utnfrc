<div class="container_16 nav mt20">
    <ul>
        <li><a href="/SistemaGestionTorneo/">Home</a></li>
        <li><a href="#">La ACS</a></li>
        <li><a href="#">Noticias</a></li>
        <li><a href="#">Jugadores</a></li>
        <li><a href="/SistemaGestionTorneo/torneo/listaFechasPuntuables">Torneos</a></li>        
        <li><a href="#">Clubes</a></li>
        <li><a href="#">Media</a></li>
        <li><a href="#">Contacto</a></li>
        <li>
            <form action="#" method="get" name="searchForm" id="headerSearch" onsubmit="return false;">
                <input type="text" value="Ingresar Jugador" name="search-top" class="autocomplete ac_input" id="search-top" 
                    autocomplete="off"
                    onkeypress="autosuggest_jugadores('#search-top', '#results-home', '#jug-home', 0);"
                    onblur="if (!this.value) {this.value = 'Ingresar Jugador'}" 
                    onfocus="if (this.value == 'Ingresar Jugador') {this.value = ''}" 
                >
                <input type="hidden" name="jug-home" id="jug-home" class="autoCompId"> 
                <div id="results-home" class="results results-h2h raised"></div>
                <input type="hidden" class="autoCompId">                
                <span class="lupa"></span>
            </form>
        </li>
    </ul>
</div>