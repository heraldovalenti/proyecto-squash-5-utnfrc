$( document ).ready( function() {
	$(".fieldcontain div.vista-previa").click( function(e) {
		$("#logoClub").click();
	});
	
	$("#logoClub").change( function(e) {
		var input = document.getElementById("logoClub")
		readURL(input)
	});
});