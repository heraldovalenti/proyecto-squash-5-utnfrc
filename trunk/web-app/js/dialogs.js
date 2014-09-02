var dialogs = {
	showErrorsDialog : function(errors) {
		$("#showDialogDiv").remove();
		var $dialogDiv = $("<div/>")
			.attr("id","showDialogDiv")
			.appendTo("body");
		var $errorsList = $("<ul/>")
			.appendTo($dialogDiv);
		for (var i = 0; i < errors.length; i++) {
			$("<li/>")
				.html(errors[i].error)
				.appendTo($errorsList);
		}
		var closeFunc = function() {
			$dialogDiv.dialog("close");
		};
		var dialogButtons = [{
			text : "Aceptar",
			click : closeFunc
		}];
		$dialogDiv.dialog({
			title: "Error",
			modal : true,
			buttons : dialogButtons
		});
	},
	showMessageDialog : function(text,ok_func) {
		$("#showDialogDiv").remove();
		var $dialogDiv = $("<div/>")
			.attr("id","showDialogDiv")
			.html(text)
			.appendTo("body");
		var closeFunc = function() {
			$dialogDiv.dialog("close");
		};
		var dialogButtons = [{
			text : "Aceptar",
			click : closeFunc
		}];
		$dialogDiv.dialog({
			title: "Mensaje",
			modal : true,
			buttons : dialogButtons
		});
		if (ok_func !== undefined) {
			$dialogDiv.dialog({
				close : ok_func
			});
		}
	},
	showConfirmDialog : function(text,yes_func,no_func) {
		$("#showDialogDiv").remove();
		var $dialogDiv = $("<div/>")
		.attr("id","showDialogDiv")
		.html(text)
		.appendTo("body");
		var dialogButtons = [{
			text : "Si",
			click : yes_func
		}];
		if (no_func !== undefined) {
			dialogButtons.push({
				text : "No",
				click : no_func
			});
		}
		var closeFunc = function() {
			$dialogDiv.dialog("close");
		};
		dialogButtons.push({
			text : "Cancelar",
		    click : closeFunc
		});
		$dialogDiv.dialog({
			title: "Confirmar accion",
			modal : true,
			buttons : dialogButtons
		});
	}
};