$(function() {
	$("#categoria").bind("change", function() {	
		var categoria = $("#categoria").val();
		var fecha = $("#datepicker").val();
		if(fecha!=null && fecha!=""){
			window.location = "listarPartidosPorJugar?categoria="+categoria+"&fecha="+fecha;
		}
		else{
			window.location = "listarPartidosPorJugar?categoria="+categoria;
		}			
				
		});	
	
});

$(function() { 
    $("#datepicker").datepicker({dateFormat: 'dd/mm/yy'});    
})  
