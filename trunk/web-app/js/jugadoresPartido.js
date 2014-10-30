function obtenerTorneo(){
	return $("#torneo").val();
}

function obtenerCategoria(){
	return $("#categoria").val();
}


$(function() {
    $.ajax({
        type: "POST",
        url: "/SistemaGestionTorneo/jugador/listarNombresJugadoresTorneo",
        dataType: "json",
        data: {'torneo':obtenerTorneo(), 'categoria':obtenerCategoria()},
        success : function(response) {      
            var data =
                $.map(response, function(item){             
                    return{
                        id: item.id,
                        value: item.apellido  + ", "+ item.nombre
                    }
                });
 
 
            $("#jugador1Text").autocomplete({
                source: data,
                select: function (event, ui){              
                    $('#jugador1').val(ui.item.id); //aca deberia pasar el value del hidden
               
                }
            });
            
            $("#jugador2Text").autocomplete({
                source: data,
                select: function (event, ui){                  
                    $('#jugador2').val(ui.item.id);
                }
            });           
 
        }
    });
 
});

$(function() {
    $.ajax({
        type: "GET",
        url: "/SistemaGestionTorneo/jugador/listarJugadoresJSON",
        dataType: "json",
        success : function(response) {      
            var data =
                $.map(response, function(item){             
                    return{
                        id: item.id,
                        value: item.apellido  + ", "+ item.nombre
                    }
                }); 
           
            
            $("#arbitroText").autocomplete({
                source: data,
                select: function (event, ui){
                    $('#arbitro').val(ui.item.id);                
                    
                }
            });
 
        }
    });
 
});