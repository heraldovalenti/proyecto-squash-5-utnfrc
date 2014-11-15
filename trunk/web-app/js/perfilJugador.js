$(document).ready(function() {
	$("#calendar_year").bind("change", function() {
		var year = $("#calendar_year").val();
		var personaId= $("#personaId").val();
		window.location = "cargarPerfilJugadorConPersona?persona="+personaId+"&year="+year;
	});
});