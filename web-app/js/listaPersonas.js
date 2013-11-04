$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "/SistemaGestionTorneo/usuario/listarPersonas",
        dataType: "json",
        success : function(response) {
            //Create a map.
            var data =
                $.map(response, function(item){
                  console.log("id: " + item.id);
                  console.log("nombre: " + item.nombreUsuario);
                    return{
                        id: item.id,
                        value: item.nombreUsuario //deberia ser item.persona.nombre algo asi
                    }
                });
 
 
            $("#jugador1").autocomplete({
                source: data,
                select: function (event, ui){          	
                	                	
                    console.log("selected id:" + ui.item.id);
                    console.log("selected name:" + ui.item.value);
 
                    //when a country is selected(ie: type China and press enter),
                    //change the value of hidden field to the country's id.
                    
                    $('#jugador1.id').val(ui.item); //aca deberia pasar el value del hidden
                    console.log("yiiuuuuu");
                }
            });
            
            $("#jugador2").autocomplete({
                source: data,
                select: function (event, ui){
                    console.log("selected id:" + ui.item.id);
                    console.log("selected name:" + ui.item.value);
 
                    //when a country is selected(ie: type China and press enter),
                    //change the value of hidden field to the country's id.
                    $('#jugador2.id').val(ui.item.id);
                    console.log("yiiuuuuu");
                }
            });
            
            $("#arbitro").autocomplete({
                source: data,
                select: function (event, ui){
                    console.log("selected id:" + ui.item.id);
                    console.log("selected name:" + ui.item.value);
 
                    //when a country is selected(ie: type China and press enter),
                    //change the value of hidden field to the country's id.
                    $('#arbitro.id').val(ui.item.id);
                    console.log("yiiuuuuu");
                    
                }
            });
 
        }
    });
 
});