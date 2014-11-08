<head>	
<link href="${resource(dir: 'css', file: 'jugador.css') }" type="text/css" rel="stylesheet"/>  	
</head>

<body>
<div class="mb10">
	<div id="news-result" class="inner-box">
	<ul>	
	<li id="li-jugador-masculino"><a href="#">Masculinos</a>
	<g:each in="${categorias}" var="categoria">
	<g:if test="${categoria.modalidadCategoria == 'Masculino'}">
		<g:if test="${tipo == 'jugador'}">
			<li><g:link controller="jugador" action="obtenerJugadores" params="[categoria:categoria.nombre]">${ categoria.nombre }</g:link></li>
		</g:if>
		<g:elseif test="${tipo == 'ranking'}">  
			<li><g:link controller="jugador" action="obtenerRankingJugadores" params="[categoria:categoria.nombre]">${ categoria.nombre }</g:link></li>
		</g:elseif>
	</g:if>
	</g:each>	 		
    </li>
    <li id="li-jugador-femenino"><a href="#">Femeninos</a>	
	<g:each in="${categorias}" var="categoria">
	<g:if test="${categoria.modalidadCategoria == 'Femenino'}">
		<g:if test="${tipo == 'jugador'}">
			<li><a><g:link controller="jugador" action="obtenerJugadores" params="[categoria:categoria.nombre]">${ categoria.nombre }</g:link></a></li>
		</g:if>
		<g:elseif test="${tipo == 'ranking'}">  
			<li><g:link controller="jugador" action="obtenerRankingJugadores" params="[categoria:categoria.nombre]">${ categoria.nombre }</g:link></li>
		</g:elseif>
	</g:if>
	</g:each>	   		
    </li>     	       	
        	        	      	
    </ul>		
	</div>
</div>
<body>