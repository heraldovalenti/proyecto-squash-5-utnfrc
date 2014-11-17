$(document).ready(function() {
	$("#calendar_year").bind("change", function() {
		var year = $("#calendar_year").val();
		var personaId= $("#personaId").val();
		window.location = "cargarPerfilJugadorConPersona?persona="+personaId+"&year="+year;
	});
});

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
 
 
            $("#buscadorContrincante").autocomplete({
                source: data,
                select: function (event, ui){               
                	
                    $("#contrincanteId").val(ui.item.id);                    
                }
            });
            
            }
        });
     
    });

//Bindea el click a el div con la lupa para buscar usuarios 

$(function() {
	$("#mostrarContrincante").bind("click", function() {
		var personaId= $("#personaId").val();
		var persona2Id = $("#contrincanteId").val();
		if (personaId!="" && persona2Id!="")
		window.location = "/SistemaGestionTorneo/jugador/verEnfrentamientoJugadores?jugador1="+personaId+"&jugador2="+persona2Id;
	});
});