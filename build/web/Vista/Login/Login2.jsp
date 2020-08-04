<%-- 
    Document   : Login2
    Created on : Jul 11, 2020, 4:12:59 AM
    Author     : trece
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Hello, world!</title>
    <style>
		#map{
			margin: 50%;
		}
	</style>
  </head>
  <body>
    <h1>Hello, world!</h1>

    
    <button onclick="findMe();">Mostrar ubicación</button>
	<div id="map"></div>
	

    
  	<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDGSAco59-zFttICWQbYDPsWeTl4vpckZo"></script>
	<script>
		function findMe(){
			var output = document.getElementById('map');

			// Verificar si soporta geolocalizacion
			if (navigator.geolocation) {
				output.innerHTML = "<p>Tu navegador soporta Geolocalizacion</p>";
			}else{
				output.innerHTML = "<p>Tu navegador no soporta Geolocalizacion</p>";
			}

			//Obtenemos latitud y longitud
			function localizacion(posicion){

				var latitude = posicion.coords.latitude;
				var longitude = posicion.coords.longitude;

				var imgURL = "https://maps.googleapis.com/maps/api/staticmap?center="+latitude+","+longitude+"&size=600x300&markers=color:red%7C"+latitude+","+longitude+"&key=AIzaSyDGSAco59-zFttICWQbYDPsWeTl4vpckZo";

var im = "https://maps.googleapis.com/maps/api/staticmap?center=19.2741376,-99.663872&size=600x300&markers=color:red%7C19.2741376,-99.663872&key=AIzaSyDGSAco59-zFttICWQbYDPsWeTl4vpckZo";
output.innerHTML ="<img src='"+imgURL+"'>";
output.innerHTML ="<img src='"+im+"'>";
                                
				

			}

			function error(){
				output.innerHTML = "<p>No se pudo obtener tu ubicación</p>";

			}

			navigator.geolocation.getCurrentPosition(localizacion,error);

		}


	</script>
  
  </body>
</html>


  