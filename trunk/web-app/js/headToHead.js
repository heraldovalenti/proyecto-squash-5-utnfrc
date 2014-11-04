$( document ).ready(function() {
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
 
 
            $("#jugador1Text").autocomplete({
                source: data,
                select: function (event, ui){              
                    $('#jugador1').val(ui.item.id); //aca deberia pasar el value del hidden
                    $('#jugador1Perfil').html('');
                    $('#versus').html('');
                    $('#jugador1Perfil').append(ui.item.value);
                    $('#versus').append(" VS ");
               
                }
            });
            
            $("#jugador2Text").autocomplete({
                source: data,
                select: function (event, ui){                  
                    $('#jugador2').val(ui.item.id);
                    $('#jugador2Perfil').html('');
                    $('#jugador2Perfil').append(ui.item.value);
                }
            });           
 
        }
    });
 
});

