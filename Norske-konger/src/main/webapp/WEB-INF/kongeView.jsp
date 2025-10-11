
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<h1>King:</h1>
		<!-- Henter ut navn og fra til årstall kongen var konge-->
		<h2>${k.navn}</h2>
		<img src="${k.bilde}" width="200" height="200">
		<p>King in ${aarstallFraSok}, <br>
			 was king from ${k.kongeFraAar} to ${k.kongeTilAar}, <br>
			 born ${k.fodtAar}</p>
		
		<a href="kongesok">Back to search</a>
	</body>
	
</html>