
function generarPartidos(){	

	var partidos = {
	    teams : [
	      ["Heraldo Valenti", "David Coppa"],
	      ["Matias Del Carlo", "Guillermo Fank"]
	    ],
	    results : [[       //WINNER BRACKET 
	      [[1,2], [3,4]],  //first and second matches of the first round 
	      [[5,6]]          //second round 
	    ], [               //LOSER BRACKET 
	     // [[7,8]],         //first round 
	      [[9,10]]        // second round 
	    ], [               //FINALS 
	      [[1,12], [13,14]],
	      [[15,16]]        //LB winner won first round so need a rematch 
	    ]]
	  }
	
	return partidos;
	
}

$(function() {		
    $('#fixture').bracket({
      init: generarPartidos()
    })
  })
