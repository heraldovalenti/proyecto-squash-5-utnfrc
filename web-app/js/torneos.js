$(document).ready(function() {
	$("#calendar_year").bind("change", function() {
		var year = $("#calendar_year").val();
		window.location = "listaTorneos?year="+year;
	});
	
	$(".aceptar-postulacion").click( function(event) { 
		event.preventDefault();
		var submitURl = event.currentTarget.href;
		var yes_func = function() {
			window.location = submitURl;
		}
		dialogs.showConfirmDialog("Se aceptara la solicitud seleccionada y se rechazaran todas las demas. ¿Desea continuar?",yes_func);
	});
	
	$(".rechazar-postulacion").click( function(event) { 
		event.preventDefault();
		var submitURl = event.currentTarget.href;
		var yes_func = function() {
			window.location = submitURl;
		}
		dialogs.showConfirmDialog("Se rechazara la solicitud seleccionada. ¿Desea continuar?",yes_func);
	});
});