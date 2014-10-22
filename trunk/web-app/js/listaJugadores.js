//Permite listar los jugadores mediante en autocomplete de jquery

$(function() {
    $.ajax({
        type: "GET",
        url: "/SistemaGestionTorneo/jugador/listarJugadoresJSON",
        dataType: "json",
        success : function(response) {
            //Create a map.
            var data =
                $.map(response, function(item){                 	
                    return{
                        id: item.id,
                        value: item.apellido + ", " + item.nombre //deberia ser item.persona.nombre algo asi
                    }
                });
 
 
            $("#buscadorJugadores").autocomplete({
                source: data,
                select: function (event, ui){               
                	
                    $("#jugadorId").val(ui.item.id);                    
                }
            });
            
            }
        });
     
    });

//Bindea el click a el div con la lupa para buscar usuarios 

$(function() {
	$("#mostrarJugador").bind("click", function() {
		var persona = $("#jugadorId").val();
		if (persona!="")
		window.location = "/SistemaGestionTorneo/jugador/cargarPerfilJugadorConPersona?persona="+persona;
	});
});