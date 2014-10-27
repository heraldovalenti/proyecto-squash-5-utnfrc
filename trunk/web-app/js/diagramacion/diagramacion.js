var canchas = {};
var partidos = {};
var torneo = null;

function loadTorneo() {
	$.ajax({
		url: "diagramacionHorarios/getDatosTorneo",
		success: function(data) {
			torneo = data;
		}
	});
}

function loadCanchas() {
	$.ajax({
		url: "diagramacionHorarios/getCanchas",
		success: function(data) {
			canchas = data;
		}
	});
}

function loadPartidos() {
	$.ajax({
		url: "diagramacionHorarios/getPartidos",
		success: function(data) {
			partidos = data;
		}
	});
}


$(document).ready( function() {
	
	$("#dia-torneo").spinner({
		min: 1,
		step: 1
	});
	
	$(".partido").draggable({
		revert: true,
		revertDuration: 200,
		opacity: 0.5		
	});
	
	$(".contenedor-multi").droppable({
		tolerance: "pointer",
		drop: function( event, ui ) {
			var partido = ui.draggable[0];
			var contenedor = event.target;
			partidoToRonda(partido);
		}
	});
	
	$(".contenedor-single").droppable({
		tolerance: "pointer",
		drop: function( event, ui ) {
			var partido = ui.draggable[0];
			var contenedor = event.target;
			if (partido.parentElement === contenedor) return;
			var otherPartido;
			for (var i = 0; i < contenedor.children.length; i++) {
				if ( $(contenedor.children[i]).hasClass("partido") ) {
					otherPartido = contenedor.children[i];
					break;
				}
			}
			var fromSingleToSingle = $(partido.parentElement).hasClass("contenedor-single") && $(contenedor).hasClass("contenedor-single");
			if (otherPartido && fromSingleToSingle) {
				swapPartidos(partido, otherPartido);
				return;
			}
			if (otherPartido && !fromSingleToSingle) {
				partidoToRonda( otherPartido);
			}
			partido.remove();
			$(contenedor).append(partido);				
		}
	});
	
	$("#diagramacion-canchas").tabs();

});

function swapPartidos(partido1, partido2) {
	var contenedor = partido2.parentElement;
	partido2.remove();
	$(partido1.parentElement).append(partido2);
	partido1.remove();
	$(contenedor).append(partido1);	
}

function partidoToRonda(partido) {
	var contenedor = $(".contenedor-multi")[0];
	var rondas = contenedor.children
	var rondaPartido = $(partido).attr("ronda");
	for (var i = 0; i < rondas.length; i++) {
		var ronda = $(rondas[i]).attr("ronda");
		if (ronda === rondaPartido) {
			contenedor = rondas[i];
			break;
		}
	}
	if (partido.parentElement == contenedor) return;
	partido.remove();
	$(contenedor).append(partido);
}