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
					
			result= generarPartidos(data);				
				
		}
	});
	return result;	
}


function generarPartidos(part){	
	
	var partidos = {};
	
	var teams=[];
	var results=[];
	var primerRonda=[];
	var segundaRonda=[];
	var finales=[];
	
	$.each(part, function(key,value) {	
		
		teams.push([ value.jugador1, value.jugador2 ]);
		
		if (value.resultado != null) {
			primerRonda.push(value.resultado);
		} else {
			primerRonda.push([ null, null ]);
		}
	
	});	
/*	primerRonda.push([1,2]);
	primerRonda.push([0,3]);
	primerRonda.push([3,1]);
	primerRonda.push([5,4]);*/
	segundaRonda.push([null,null],[null,null]);
	finales.push([null,null],[null,null]);	
	
	results.push(primerRonda);
	results.push(segundaRonda);
	results.push(finales);

		
	partidos.teams=teams;
	partidos.results=results;
	
	return partidos;
	
}

$(function() {		
    $('#fixture').bracket({
      init: obtenerPartidosPorCategoria()
    })
  })
