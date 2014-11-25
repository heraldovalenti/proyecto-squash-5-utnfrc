<head>    	
        <r:require module="listaClubes"/>
</head>
<body>

	<div class="box mb10 box-225">
		<h3 class="title">Clubes de Córdoba</h3>
		<div id="menu-clubes" class="inner-box">
		<li>				
                <input type="text" id="buscadorClubes" placeholder="Ingrese un Club" name="search-top" class="autocomplete ac_input" id="search-top">
                <input type="hidden" id="clubId" class="autoCompId"/> 
                <div id="results-home" class="results results-h2h raised"></div>
                <input type="hidden" class="autoCompId"/> 
                <div id= "mostrarClub">
                <span class="lupa"></span>
                </div>               
                
            
        </li>
			<g:each in="${listadoClub}" var="club">
				<li style="padding: 5px;"><g:link controller="club" action="listarClubes" params="[club:club.id]">${ club.nombre }</g:link></li>
			</g:each>
		</div>
	</div>
<body>