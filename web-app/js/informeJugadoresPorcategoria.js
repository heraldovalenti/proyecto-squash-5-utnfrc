$(function(){	
	
	$.ajax({
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		url : "cantidadJugadoresPorCategoria",
		success : function(data) {
			if(data[0][0]==null){
				var callback = function() { window.location = "verPorcentajeJugadoresPorCategoria"; };
				var text = "No existen jugadores registrados en las categorias del club";
				dialogs.showMessageDialog(text,callback)	
			}
			else{
				cargarGrafico(data);	
			}
		}
	});	
	
	
});



function cargarGrafico(data){
         
    var plot8 = $.jqplot('chart1', data, {
        grid: {
            drawBorder: false, 
            drawGridlines: false,
            background: '#ffffff',
            shadow:false
        },
        axesDefaults: {
             
        },
        seriesDefaults:{
            renderer:$.jqplot.PieRenderer,
            rendererOptions: {
                showDataLabels: true
            }
        },
        legend: {
            show: true,
            rendererOptions: {
                numberRows:3
            },
            location: 's'            
        }
    }); 
}