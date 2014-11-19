$(function(){	
	
	$.ajax({
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		url : "disponibilidadClubes",
		success : function(data) {
			cargarGrafico(data);
		}
	});	
	
	
});



function cargarGrafico(data){
    $.jqplot.config.enablePlugins = true;
    var s1 = data[0];
    var ticks = data[1];
     
    plot1 = $.jqplot('chart1', [s1], {
        animate: !$.jqplot.use_excanvas,
        seriesDefaults:{
            renderer:$.jqplot.BarRenderer,
            pointLabels: { show: true }
        },
        axes: {
            xaxis: {
                renderer: $.jqplot.CategoryAxisRenderer,
                ticks: ticks
            }
        },
        highlighter: { show: false }
    });
 
    $('#chart1').bind('jqplotDataClick', 
        function (ev, seriesIndex, pointIndex, data) {
            $('#info1').html('series: '+seriesIndex+', point: '+pointIndex+', data: '+data);
        }
    );
}