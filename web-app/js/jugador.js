$( document ).ready( function() {
	$(".fieldcontain div.vista-previa").click( function(e) {
		$("#profileImage").click();
	});
	
	$("#profileImage").change( function(e) {
		var input = document.getElementById("profileImage")
		readURL(input)
	});
});