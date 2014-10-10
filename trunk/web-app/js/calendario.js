$(document).ready(function() {
	$('td').click(function() {
		if(($(this).hasClass('selected') && $(this).hasClass('selected'))==false){
			//$(this).removeClass('unselected');
			$(this).addClass('selected');
			var col_index= $(this).index();
			var row_index= $(this).parent().index();
			var header= $(this).closest('table');			
			
		}
		else if($(this).hasClass('selected')== true){
			$(this).removeClass('selected');			
			}
		
	});
});


$(function() {
$('th').click(function(){
	
	var columna= $.trim($(this).text());
	var cont=0;
		
		$('td').each(function(){
			
			var header= $(this).closest('table');
			var col_index= $(this).index();			
			
			if(($.trim(header.find('th').eq(col_index).text()))== columna){				
				
				if($(this).hasClass('selected') ){
					cont++;		
					
				}
				else {					
					$(this).addClass('selected');					
				}		
				
				
			}	
					
			
			
		});
		
		if(cont==16){
			
			$('td').each(function(){
				
				var header= $(this).closest('table');
				var col_index= $(this).index();			
				
				if(($.trim(header.find('th').eq(col_index).text()))== columna){
					
					$(this).removeClass('selected');	
					
					
				}	
						
				
				
			});
			
			
			
		}
			
	});	

			
});

$(function() {
	$('td.time-hour').click(function(){	
		
		var fila= $.trim($(this).text());		
		var cont=0;
			
			$('td').each(function(){
				
				var header= $(this).closest('table');
				var row_index= $(this).parent().index();
				
				if(($.trim(header.find('td.time-hour').eq((row_index)).text()))== fila){
					
					if($(this).hasClass('selected') ){
						cont++;		
						
					}
					else {					
						$(this).addClass('selected');					
					}					
				}					
				
				
			});
			
			if(cont==7){
				
				$('td').each(function(){
					
					var header= $(this).closest('table');
					var row_index= $(this).parent().index();		
					
					if(($.trim(header.find('td.time-hour').eq((row_index)).text()))== fila){
						
						$(this).removeClass('selected');							
						
					}	
							
					
					
				});
				
				
				
			}
				
		});	

				
	});




$(function() {
	$('#guardarDisponibilidad')
			.click(
					function() {
						dialogs.showLoadingDialog("Guardando disponibilidad...");
						var disponibilidad = [];
						$('td')
								.each(
										function() {
											var col_index = $(this).index();
											var row_index = $(this).parent()
													.index();
											var header = $(this).closest(
													'table');
											var headerText = ($.trim(header
													.find('th').eq(col_index)
													.text()));
											if (($(this).hasClass('selected') && headerText == 'lunes')) {
												detalle = {};
												detalle["dia"] = 'lunes';
												detalle["hora"] = $
														.trim(header
																.find(
																		'td.time-hour')
																.eq((row_index))
																.text());
												disponibilidad.push(detalle);
											} else if (($(this).hasClass(
													'selected') && headerText == 'martes')) {
												detalle = {};
												detalle["dia"] = 'martes';
												detalle["hora"] = $
														.trim(header
																.find(
																		'td.time-hour')
																.eq((row_index))
																.text());
												disponibilidad.push(detalle);
											} else if (($(this).hasClass(
													'selected') && headerText == 'miercoles')) {
												detalle = {};
												detalle["dia"] = 'miercoles';
												detalle["hora"] = $
														.trim(header
																.find(
																		'td.time-hour')
																.eq((row_index))
																.text());
												disponibilidad.push(detalle);
											} else if (($(this).hasClass(
													'selected') && headerText == 'jueves')) {
												detalle = {};
												detalle["dia"] = 'jueves';
												detalle["hora"] = $
														.trim(header
																.find(
																		'td.time-hour')
																.eq((row_index))
																.text());
												disponibilidad.push(detalle);
											} else if (($(this).hasClass(
													'selected') && headerText == 'viernes')) {
												detalle = {};
												detalle["dia"] = 'viernes';
												detalle["hora"] = $
														.trim(header
																.find(
																		'td.time-hour')
																.eq((row_index))
																.text());
												disponibilidad.push(detalle);
											} else if (($(this).hasClass(
													'selected') && headerText == 'sabado')) {
												detalle = {};
												detalle["dia"] = 'sabado';
												detalle["hora"] = $
														.trim(header
																.find(
																		'td.time-hour')
																.eq((row_index))
																.text());
												disponibilidad.push(detalle);
											} else if (($(this).hasClass(
													'selected') && headerText == 'domingo')) {
												detalle = {};
												detalle["dia"] = 'domingo';
												detalle["hora"] = $
														.trim(header
																.find(
																		'td.time-hour')
																.eq((row_index))
																.text());
												disponibilidad.push(detalle);
											}

										}

								)
						$.ajax({
							type : "POST",
							data : JSON.stringify(disponibilidad),
							contentType : "application/json",
							dataType : "json",
							url : "save",
							success : function(data) {
								dialogs.hideLoadingDialog();
								var callback = function() { window.location = "show"; };
								var text = "Disponibilidad registrada";
								dialogs.showMessageDialog(text,callback)
							},
							error : function(a,b,c) {
								console.log("error...");
							}
						});

					}),
	$('#borrarDisponibilidad').click(
			function(){
				
				var text = "¿Esta seguro que desea eliminar la disponibilidad horaria?";
				var yes_callback = function() {
					dialogs.showLoadingDialog("Eliminando disponibilidad...");
					$.ajax({
						type : "GET",
						contentType : "application/json",
						dataType : "json",
						url : "delete",
						success : function(data) {
							dialogs.hideLoadingDialog();
							var callback = function() { window.location = "index"; };
							var text = "Disponibilidad eliminada";
							dialogs.showMessageDialog(text,callback)
						}
					});	
				};
				dialogs.showConfirmDialog(text,yes_callback);
			})
});

$(function(){	
	
	$.ajax({
		type : "GET",
		contentType : "application/json",
		dataType : "json",
		url : "obtenerDisponibilidad",
		success : function(data) {
			cargarDisponibilidad(data);
		}
	});	
	
	
});

function cargarDisponibilidad(data) {	
	
	var detalles= data;
	$.each(detalles, function(key,value) {	  
	  
	  $('td').each(function(){
		  
		  var header= $(this).closest('table');
		  var row_index= $(this).parent().index();
		  var col_index= $(this).index();
		  
		  if(value!=null){	
		  if(value.hora==8 || value.hora ==9){
			  var hora= '0'+(value.hora + ':00');
		  }
		  else{
			  var hora= (value.hora + ':00');
		  }		  
		  var dia= value.dia;
		  
		  if((($.trim(header.find('td.time-hour').eq((row_index)).text()))== hora) && 
		  (($.trim(header.find('th').eq(col_index).text()))== dia)) {
			  
			  $(this).addClass('selected');			  
		  }
		  }		  
		  else if($(this).hasClass('selected')== true){
				$(this).removeClass('selected');
				$(this).addClass('unselected');
				}	  
	  
	  }); 
	});	

}