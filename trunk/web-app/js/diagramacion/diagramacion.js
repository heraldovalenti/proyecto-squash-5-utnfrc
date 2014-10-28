var canchas = {};
var partidos = {};
var torneo = null;
var diasTorneo = [];
var fechaSeleccionada = null;
var diasSemana = ["Domingo","Lunes","Martes","Miercoles","Jueves","Viernes","Sabado"];

function initDiagramacionCanchas() {
	renderDiagramacionRondas();
	renderDiagramacionCanchas();
	loadCanchas();
	loadTorneo();
	loadPartidos();
}

function renderDiagramacionRondas() {
	//panel principal
	$("<div/>")
		.attr("id","diagramacion-rondas")
		.addClass("box ui-tabs ui-widget ui-widget-content ui-corner-all contenedor-multi")
		.appendTo("#diagramacion-table");
	
	$(".contenedor-multi").droppable({
		tolerance: "pointer",
		drop: function( event, ui ) {
			var partido = ui.draggable[0];
			var contenedor = event.target;
			partidoToRonda(partido);
		},
	});
}

function renderPanelesRonda() {
	var rondasPartido = [];
	for (var i = 0; i < Object.keys(partidos).length; i++) {
		var key = Object.keys(partidos)[i];
		var partido = partidos[key];
		if (rondasPartido.indexOf(partido.ronda) === -1) {
			rondasPartido.push(partido.ronda);
		}
	}
	rondasPartido.sort( function(a, b){ return b - a } );
	for (var i = 0; i < rondasPartido.length; i++) {
		$("<div/>")
			.attr("id","ronda-" + rondasPartido[i])
			.attr("ronda",rondasPartido[i])
			.addClass("ronda box ui-corner-all")
			.appendTo("#diagramacion-rondas");
	}
	renderPartidos();
}

function renderPartidos() {
	for (var i = 0; i < Object.keys(partidos).length; i++) {
		var key = Object.keys(partidos)[i];
		var partido = partidos[key];
		if (partido.cancha == null) {
			var divRonda = $("#ronda-" + partido.ronda);
			var divPartido = $("#ronda-" + partido.ronda + " #partido-" + partido.id);
			if (divPartido.length !== 0) continue;
			var div = $("<div/>")
				.addClass("partido ui-widget-header ui-corner-all")
				.attr("id","partido-" + partido.id)
				.attr("ronda", partido.ronda)
				.appendTo(divRonda);
			var jugador1 = (partido.jugador1 != "null") ? partido.jugador1 : "?????";
			var jugador2 = (partido.jugador2 != "null") ? partido.jugador2 : "?????";
			$("<span/>").addClass("info").html(partido.rondaString).appendTo(div);
			$("<span/>").addClass("info").html(partido.categoria).appendTo(div);
			$("<span/>").addClass("jugador").html(jugador1).appendTo(div);
			$("<span/>").addClass("jugador").html(jugador2).appendTo(div);
		} else if(partido.fecha === fechaSeleccionada) {
			var divHorario = $("#cancha-" + partido.cancha + " div[hora='" + partido.inicio + "']");
			var div = $("<div/>")
			.addClass("partido ui-widget-header ui-corner-all")
			.attr("id","partido-" + partido.id)
			.attr("ronda", partido.ronda)
			.appendTo(divHorario);
			var jugador1 = (partido.jugador1 != "null") ? partido.jugador1 : "?????";
			var jugador2 = (partido.jugador2 != "null") ? partido.jugador2 : "?????";
			$("<span/>").addClass("info").html(partido.rondaString).appendTo(div);
			$("<span/>").addClass("info").html(partido.categoria).appendTo(div);
			$("<span/>").addClass("jugador").html(jugador1).appendTo(div);
			$("<span/>").addClass("jugador").html(jugador2).appendTo(div);
		}
	}
	$(".partido").draggable({
		revert: true,
		revertDuration: 200,
		opacity: 0.5,
	});
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
	renderHorariosCanchas();
	renderPartidos();
}

function renderHorariosCanchas() {
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
		horariosDia.sort( function(a, b){ return a - b } );
		//render los horarios
		for (var j = 0; j < horariosDia.length; j++) {
			var horario = horariosDia[j];
			var div = $("<div/>")
				.attr("hora",horario)
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
			appendPartido(partido,contenedor);
		}
	});
}

function loadCanchas() {
	$.ajax({
		url: "diagramacionHorarios/getCanchas",
		success: function(data) {
			canchas = data;
			renderCanchas();
			setFechaSeleccionada(0);
		}
	});
}

function loadPartidos() {
	$.ajax({
		url: "diagramacionHorarios/getPartidos",
		success: function(data) {
			for (var i = 0; i < data.length; i++) {
				partido = data[i];
				var partidoId = partido.id;
				partidos[partidoId] = partido;
			}
			renderPanelesRonda();
		}
	});
}


$(document).ready( function() {
	initDiagramacionCanchas();
});

function swapPartidos(partido1, partido2) {
	var contenedor = partido2.parentElement;
	partido2.remove();
	appendPartido(partido2,$(partido1.parentElement));
	partido1.remove();
	appendPartido(partido1,contenedor);
}

function partidoToRonda(partido) {
	var contenedor = $(".contenedor-multi")[0];
	var rondaPartido = $(partido).attr("ronda");
	
	contenedor = $("#ronda-" + rondaPartido)[0]; 
	if (partido.parentElement == contenedor) return;
	partido.remove();
	appendPartido(partido,contenedor);
}

function appendPartido(partido, contenedor) {
	$(contenedor).append(partido);
	if ( $(contenedor).hasClass("ronda") ) {
		var partidoId = partido.id.split("-")[1];
		var partido = partidos[partidoId];
		partido.cancha = null;
		partido.fecha = null;
		partido.inicio = null;
		partido.fin = null;
	} else if ( $(contenedor).hasClass("horario-cancha") ) {
		var partidoId = partido.id.split("-")[1];
		var partido = partidos[partidoId];
		var canchaId = contenedor.parentElement.id.split("-")[1];
		var fecha = fechaSeleccionada;
		var inicio = $(contenedor).attr("hora");
		var fin = inicio + 1;
		partido.cancha = canchaId;
		partido.fecha = fecha;
		partido.inicio = inicio;
		partido.fin = fin;
	}
}