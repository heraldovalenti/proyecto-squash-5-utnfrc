var canchas = {};
var partidos = {};
var torneo = null;
var diasTorneo = [];
var fechaSeleccionada = null;
var diasSemana = ["Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"];

function initDiagramacionCanchas() {
	renderDiagramacionCanchas();
	loadCanchas();
	loadTorneo();
}

function renderDiagramacionRondas() {
	
}

function renderDiagramacionCanchas() {
	//panel principal
	$("<div/>")
		.attr("id","diagramacion-canchas")
		.addClass("box")
		.appendTo("#diagramacion-table");

	//header
	$("<div/>")
		.html("Canchas disponibles")
		.addClass("box ui-widget-header ui-corner-all canchas-header")
		.appendTo("#diagramacion-canchas");
	
	//selector de dia
	$("<div/>")
		.attr("id","diagramacion-dia-torneo")
		.addClass("box ui-widget-header ui-corner-all")
		.appendTo("#diagramacion-canchas");
	$("<label/>")
		.attr("for","dia-torneo")
		.html("Dia")
		.appendTo("#diagramacion-dia-torneo");
	$("<input/>")
		.attr("id","dia-torneo")
		.attr("name","dia-torneo")
		.attr("value","1")
		.appendTo("#diagramacion-dia-torneo");
	$("<span/>")
		.attr("id","dia-semanal")
		.addClass("dia-semanal")
		.html("Lunes")
		.appendTo("#diagramacion-dia-torneo");
	$("<span/>")
		.attr("id","dia-fecha")
		.addClass("dia-fecha")
		.html("01/01/2014")
		.appendTo("#diagramacion-dia-torneo");
	$("#dia-torneo").spinner({
		min: 1,
		step: 1
	});
	
	//horarios de canchas
	$("<ul/>").appendTo("#diagramacion-canchas");
}

function renderCanchas() {
	for (var i = 0; i < canchas.length; i++) {
		var cancha = canchas[i];
		var idCancha = "cancha-" + cancha.numero;
		var li = $("<li/>").appendTo("#diagramacion-canchas ul");
		$("<a/>").html("#"+cancha.numero).attr("href","#"+idCancha).appendTo(li);
		$("<div/>").attr("id",idCancha).appendTo("#diagramacion-canchas");
	}
	$("#diagramacion-canchas").tabs();
}

function loadTorneo() {
	$.ajax({
		url: "diagramacionHorarios/getDatosTorneo",
		success: function(data) {
			torneo = data;
			loadDiasTorneo();
		}
	});
}

function loadDiasTorneo() {
	var fechaFinTorneo = new Date(torneo.fechaFinTorneo);
	var fechaActual = new Date(torneo.fechaInicioTorneo);
	while (fechaActual <= fechaFinTorneo) {
		diasTorneo.push(new Date(fechaActual.getTime()));
		fechaActual.setTime(fechaActual.getTime() + (1000 * 60 * 60 * 24));
	}
	$("#dia-torneo").spinner({ 
		max: (diasTorneo.length),
		stop: function() { 
			var val = $("#dia-torneo").spinner("value");
			setFechaSeleccionada(val - 1); 
		}
	});
	$("#dia-torneo").spinner("value",1);
	setFechaSeleccionada(0);
}

function setFechaSeleccionada(dia) {
	fechaSeleccionada = diasTorneo[dia];
	var diaSemanal = diasSemana[fechaSeleccionada.getDay()];
	var diaFecha = fechaSeleccionada.toLocaleString().split(" ")[0];
	$("#dia-semanal").html(diaSemanal);
	$("#dia-fecha").html(diaFecha);
	cargarHorariosCanchas();
}

function cargarHorariosCanchas() {
	var diaSemanal = diasSemana[fechaSeleccionada.getDay()];
	var diaFecha = fechaSeleccionada.toLocaleString().split(" ")[0];
	for (var i = 0; i < canchas.length; i++) {
		var cancha = canchas[i];
		//limpiar los horarios de la cancha
		var idCancha = "cancha-" + cancha.numero;
		var divCancha = $("#" + idCancha)
		$(divCancha).empty();
		//buscar los horarios del dia seleccionado
		var detalles = (cancha.disponibilidad !== null && cancha.disponibilidad.detalles !== null) ? cancha.disponibilidad.detalles : null;
		var horariosDia = [];
		for (var j = 0; detalles !== null && j < detalles.length; j++) {
			var detalle = detalles[j];
			if (detalle === undefined) {
				console.log(detalle);
			}
			if (detalle.dia === diaSemanal.toLowerCase()) {
				horariosDia.push(detalle.hora);
			}
		}
		horariosDia.sort();
		//render los horarios
		for (var j = 0; j < horariosDia.length; j++) {
			var horario = horariosDia[j];
			var div = $("<div/>")
				.addClass("horario-cancha ui-corner-all contenedor-single")
				.appendTo(divCancha);
			var ul = $("<ul/>")
				.addClass("horario-cancha-fecha")
				.appendTo(div);
			$("<li/>").html(diaSemanal).appendTo(ul);
			$("<li/>").html(diaFecha).appendTo(ul);
			$("<li/>").html(horario + ":00-" + (horario + 1) + ":00").appendTo(ul);
		}
	}
}

function loadCanchas() {
	$.ajax({
		url: "diagramacionHorarios/getCanchas",
		success: function(data) {
			canchas = data;
			renderCanchas();
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

	initDiagramacionCanchas();
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