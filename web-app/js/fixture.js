$( document ).ready( function() {
	$("#categoria").bind("change", function() {	renderFixture(); });
	renderFixture();
});
	

function renderFixture() {
	$('#fixture').html('');
	
	try {
		$('#fixture').bracket({
			init: obtenerPartidosPorCategoria()
		})		
	} catch (e) {
		$("<h2/>").html("No hay partidos para la categoria seleccionada").appendTo( $('#fixture') );
	}
	//esconde tercer puesto
	var np_divs = $(".np");
	$(np_divs[np_divs.length - 1]).hide();
}

function obtenerPartidosPorCategoria(){
	var categoria = $("#categoria").val();
	var url = "/" + window.location.pathname.split("/")[1] + "/fixture/generarFixturePorCategoria?categoria="+categoria;
	var JSON;
	$.ajax({
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		async: false,
		url : url,
		success : function(data) {
			result= generarPartidos(data);
		}
	});
	return result;
}


function generarPartidos(part) {

	var partidos = {};

	var teams = [];
	var results = [];
	var dieciseisavos = [];
	var octavos = [];
	var cuartos = [];
	var semis = []
	var finales = [];

	$.each(part, function(key, value) {

		if (value.ronda == value.cantidadRondas) {
			if(value.jugador1=="null"){
				teams.push([ " ", value.jugador2 ]);
			}
			else if(value.jugador2=="null"){
				teams.push([ value.jugador1, " " ]);
				
			}
			else{
				teams.push([ value.jugador1, value.jugador2 ]);
			}
			
		}

		if (value.ronda == 5) {
			if (value.jugador1!="null" && value.jugador2=="null"){
				dieciseisavos.push([1,0]);
			}
			else if(value.jugador1=="null" && value.jugador2!="null"){
				dieciseisavos.push([0,1]);				
			}
			else if (value.resultado != null) {				
				dieciseisavos.push(value.resultado);
							
			}else{				
				dieciseisavos.push([ null, null ]);
			}
		} else if (value.ronda == 4) {
			if (value.jugador1!="null" && value.jugador2=="null"){
				octavos.push([1,0]);
			}
			else if(value.jugador1=="null"&& value.jugador2!="null"){
				octavos.push([0,1]);				
			}
		
			else if (value.resultado != null) {				
				octavos.push(value.resultado);
								
			}else {
				octavos.push([ null, null ]);
			}
		} else if (value.ronda == 3) {
			if (value.jugador1!="null" && value.jugador2=="null"){
				cuartos.push([1,0]);
			}
			else if(value.jugador1=="null" && value.jugador2!="null"){
				cuartos.push([0,1]);				
			}
			else if (value.resultado != null) {							
					cuartos.push(value.resultado);			
			} else {
				cuartos.push([ null, null ]);
			}
		} else if (value.ronda == 2) {
			if (value.jugador1!="null" && value.jugador2=="null"){
				semis.push([1,0]);
			}
			else if(value.jugador1=="null" && value.jugador2!="null"){
				semis.push([0,1]);				
			}
			else if (value.resultado != null) {			
				semis.push(value.resultado);								
			} else {
				semis.push([ null, null ]);
			}
		} else if (value.ronda == 1) {
			if (value.jugador1!="null" && value.jugador2=="null"){
				finales.push([1,0]);
			}
			else if(value.jugador1=="null" && value.jugador2!="null"){
				finales.push([0,1]);				
			}
			else if (value.resultado != null) {				
				finales.push(value.resultado);						
			} else {
				finales.push([ null, null ]);
			}
		}

	});

	if (dieciseisavos.length > 0) {
		
		results.push(dieciseisavos);
		results.push(octavos);
		results.push(cuartos);
		results.push(semis);
		results.push(finales);
		
	} else if (dieciseisavos.length == 0 && octavos.length > 0) {
		
		results.push(octavos);
		results.push(cuartos);
		results.push(semis);
		results.push(finales);
		
	} else if (octavos.length == 0 && cuartos.length > 0) {
		
		results.push(cuartos);
		results.push(semis);
		results.push(finales);
		
	} else if (cuartos.length == 0 && semis.length > 0) {
		
		results.push(semis);
		results.push(finales);
		
	} else if (semis.length == 0 && finales.length > 0) {
		
		results.push(finales);
	}

	partidos.teams = teams;
	partidos.results = results;

	return partidos;

}