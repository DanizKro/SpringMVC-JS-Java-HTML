<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="no">
<head>
	<link href="css/simple.css" rel="stylesheet" type="text/css" />
<!-- <script src="js/myscript.js" defer></script>  -->  
	<title>Påmelding</title>
</head>

<body>
	<h2>Påmelding</h2>
	<p id="feilmelding" style="color:red; display:none;">Påmeldingsdetaljer er ugyldige</p>
	

	<!-- Jeg har fjernet alt som har med form og input å gjøre,
		 siden dette er pensum. Her får dere sette opp skjemaet
		 selv. Lykke til.
	-->
	
	<form action="/Paamelding" method="get">
		<label for="navn">Fornavn</label> 
		<input type="text" id="fornavn"> <!-- kan bruke name="navn" for å ha klikkbar tekst-->
		
		<label for= "etternavn">Etternavn</lable> <br>
		<input type="text" id="etternavn" name="etternavn">
		
		<label for="mobil">Mobil</label>
		<input type="text" id="mobil" navn="mobil">
		
		<label for="passord">Passord:</label>
		<input type="password" id="passord" name="passord">
		
		<label for="passordRep">Passord repetert</label>
		<input type="password" id="passordRep" name="passordRep"> <br>
		<button type="button" onclick="togglePassword()">Vis / Skjul</button>
		
		<label>
			<input type="radio" name="kjonn" value="Mann" required>
			Mann
		</label>
		
		<label>
			<input type="radio" name="kjonn" value="Kvinne" required>
			Kvinne
		</label>
		
		<button id="meldMegPaa">Meld meg på!</button>

		
	</form>
	
	<script>
			function togglePassword() {
			  const input = document.getElementById("passord");
			  const input2 = document.getElementById("passordRep");
			  
			  if (input.type && input2.type === "password") { //Egen innebygget Type i HTML,
			    input.type = "text";						 //input.type = "password" gir stjerner i innput felt
				input2.type = "text";
			  } else {
			    input.type = "password";
				input2.type = "password";
			  }
			}
			</script>
</body>
</html>
