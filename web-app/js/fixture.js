$(function() {
	$("#categoria").bind("change", function() {
		
		$('#fixture').html('');
		
		 $('#fixture').bracket({
		      init: obtenerPartidosPorCategoria()
		    })
		
		});	
	
	});

function obtenerPartidosPorCategoria(){
	var categoria = $("#categoria").val();
	var JSON;
	$.ajax({
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		async: false,
		url : "generarFixturePorCategoria?categoria="+categoria,
		success : function(data) {					
			
			//Hay que mandar el data por parametro, pero convertirlo en JSON antes				
			
			json= [
					{
					"jugador1":"jose palazo",
					"jugador2":"mario gomez"
					},
					{
					"jugador1":"pablo gonzalez",
					"jugador2":"freddy mercury"
					}
					
			];				
			result= generarPartidos(json);				
				
		}
	});
	return result;	
}


function generarPartidos(part){	

	var jugadores;
	
	var partidos = {};
	
	var teams=[];
	
	
		teams.push([part[0]["jugador1"], part[0]["jugador2"]]);			
		teams.push([part[1]["jugador1"], part[1]["jugador2"]]);	
	
	
		/*	$.each(part, function(key,value) {
	      teams.push([part["jugador1"], part["jugador2"]]);
			});*/
	   

	var results =[ [ //WINNER BRACKET 
		   [ [ 1, 2 ], [ 3, 4 ] ], //first and second matches of the first round 
		   [ [ 5, 6 ] ] //second round 
		   ], [ //LOSER BRACKET 
		   // [[7,8]],         //first round 
		   [ [ 9, 10 ] ] // second round 
		   ], [ //FINALS 
		   [ [ 1, 12 ], [ 13, 14 ] ], [ [ 15, 16 ] ] //LB winner won first round so need a rematch 
		   ] ];
		
	partidos.teams=teams;
	partidos.results=results;
	
	return partidos;
	
}

$(function() {		
    $('#fixture').bracket({
      init: obtenerPartidosPorCategoria()
    })
  })
