$("#form-registro-usuario").submit( function(event) {
	event.preventDefault();
	var formData = $("#form-registro-usuario").serialize();
	$.ajax({
		type: "POST",
		url: "save",
		data: formData,
		success: function(data,textStatus,jqXHR) {
			var login_func = function() {
				window.location = "login?" + formData;
			}
			dialogs.showMessageDialog(data,login_func);
		},
		error: function(jqXHR,textStatus,errorThrown) {
			var errorMessages = [];
			var jsonErrors = $.parseJSON(jqXHR.responseText).errors;
			for (var i = 0; i < jsonErrors.length; i++) {
				var errorMessage = jsonErrors[i].message;
				errorMessages.push({ "error" : errorMessage });
			}
			dialogs.showErrorsDialog(errorMessages);
		}
	});
});