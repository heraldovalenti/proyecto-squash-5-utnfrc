function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
        	var a = e.target.result;
        	$(".fieldcontain div.vista-previa")
        		.attr("style","background-image: url(" + a + ");");
        }

        reader.readAsDataURL(input.files[0]);
    }
}