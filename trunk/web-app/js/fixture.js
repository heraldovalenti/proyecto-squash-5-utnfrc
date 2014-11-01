$(function() {
	$("#categoria").bind("change", function() {
		var categoria = $("#categoria").val();
		var JSON;
		$.ajax({
			type : "GET",
			contentType : "application/json",
			dataType : "json",
			url : "generarFixturePorCategoria?categoria="+categoria,
			success : function(data) {					
				
				//Hay que mandar el data por parametro, pero convertirlo en JSON antes				
				
				json= {
						"jugador1":"jose palazo",
						"jugador2":"mario gomez"
						
				};
					
					generarPartidos(json);
					
					
			}
		});
		});	
	
	});






function generarPartidos(part){	

	var jugadores;
	
	var partidos = {};
	
	var teams=[
	      [part["jugador1"], part["jugador2"]],
	      ["Matias Del Carlo", "Guillermo Fank"]
	    ];

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
      init: generarPartidos()
    })
  })
