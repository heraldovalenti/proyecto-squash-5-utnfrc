$("#form-registro-usuario").submit( function(event) {
	event.preventDefault();
	var formData = $("#form-registro-usuario").serialize();
	$.ajax({
		type: "POST",
		url: "save",
		data: formData,
		success: function(data,textStatus,jqXHR) {
			console.log(textStatus);
			console.log(data);
		},
		error: function(jqXHR,textStatus,errorThrown) {
			console.log(textStatus);
			console.log(errorThrown);
			console.log(jqXHR.responseText);
		}
	});
});