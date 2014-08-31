var dialogs = {
	showConfirmDialog : function(text,yes_func,no_func) {
		var dialogButtons = [{
			text : "Si",
			click : yes_func
		}];
		if (no_func !== undefined) {
			dialogButtons.push({
				text : "Si",
				click : no_func
			});
		}
		dialogButtons.push({
			text : "Cancelar",
		    click : function() {
		    	$dialogDiv.dialog("close");
		    }
		});
		$("#showConfirmDialog").remove();
		var $dialogDiv = $("<div/>")
			.attr("id","showConfirmDialog")
			.html(text)
			.appendTo("body");
		$dialogDiv.dialog({
			title: "Confirmar accion",
			modal : true,
			buttons : dialogButtons
		});
	}
};