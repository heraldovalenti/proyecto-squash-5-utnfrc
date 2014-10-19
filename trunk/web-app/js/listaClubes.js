//Permite listar los clubes mediante en autocomplete de jquery

$(function() {
    $.ajax({
        type: "GET",
        url: "/SistemaGestionTorneo/club/obtenerClubesJSON",
        dataType: "json",
        success : function(response) {
            //Create a map.
            var data =
                $.map(response, function(item){                 
                    return{
                        id: item.id,
                        value: item.nombre //deberia ser item.persona.nombre algo asi
                    }
                });
 
 
            $("#buscadorClubes").autocomplete({
                source: data,
                select: function (event, ui){               
                	
                    $("#clubId").val(ui.item.id);                    
                }
            });
            
            }
        });
     
    });

//Bindea el click a el div con la lupa para buscar clubes y llama al controlador pasando un club como parámetro

$(function() {
	$("#mostrarClub").bind("click", function() {
		var club = $("#clubId").val();
		window.location = "listarClubes?club="+club;
	});
});