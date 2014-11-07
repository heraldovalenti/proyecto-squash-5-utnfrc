$(function() {
	$("#categoria").bind("change", function() {	
		var categoria = $("#categoria").val();
		window.location = "listarResultadosPartidosTorneo?categoria="+categoria;		
		});	
	
});
