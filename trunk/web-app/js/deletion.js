$( document ).ready( function() {
	$("#deletion-button").click( function(event) {
		event.preventDefault()
		var link = event.currentTarget;
		var text = "¿Esta seguro que desea eliminar?";
		var yes_func = function() { window.location = link; };
		dialogs.showConfirmDialog(text,yes_func)
	});
	
	$(".deletion-button").click( function(event) {
		event.preventDefault()
		var link = event.currentTarget;
		var text = "¿Esta seguro que desea eliminar?";
		var yes_func = function() { window.location = link; };
		dialogs.showConfirmDialog(text,yes_func)
	});
});