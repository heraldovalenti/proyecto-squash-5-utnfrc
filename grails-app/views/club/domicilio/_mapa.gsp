<!DOCTYPE html>
<html> 
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <style type="text/css">
      html { height: 50% }
      body { height: 100%; margin: 0; padding: 0 }
      #map_canvas { height: 100% }
    </style>
    <script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?key=AIzaSyCUC1Ft_ffCDO4tXbrGqNB1OthqaVRkeQc&sensor=true&q=Obispo+Trejo+1134+Córdoba">
    </script>
    <script type="text/javascript">
    var geocoder, map;

    function obtenerPunto() {
        geocoder = new google.maps.Geocoder();
        geocoder.geocode({
            'address': '${club.domicilio.toString()}'
        }, function(results, status) {
            if (status == google.maps.GeocoderStatus.OK) {
                var myOptions = {
                    zoom: 17,
                    center: results[0].geometry.location,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                }
                map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);

                var marker = new google.maps.Marker({
                    map: map,
                    position: results[0].geometry.location
                });
            }
        });
    }
    </script>
  </head>
  <body onload="obtenerPunto()"> 
    <div id="map_canvas" style="width:100%; height:80%"></div>
  </body>
</html>