$(document).ready(function() {
	$("#calendar_year").bind("change", function() {
		var year = $("#calendar_year").val();
		window.location = "listaTorneo?year="+year;
	});
});