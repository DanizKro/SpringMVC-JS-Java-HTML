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
	<p id="feilmelding" style="color:red; display:none;">Påmeldingsdetaljer er ugyldige!</p>
	<p id="delagerFinnes" style="color:red; display:none ">Deltager finnes allerede!</p>
	

	<!-- Jeg har fjernet alt som har med form og input å gjøre,
		 siden dette er pensum. Her får dere sette opp skjemaet
		 selv. Lykke til.
	-->
	
	<form action="/Paamelding" method="get">
		
		
		<label for="navn">Fornavn</label>  <!-- kan bruke name="navn" for å ha klikkbar tekst -->
		<input type="text" id="fornavn" name="navn"
				pattern="[A-ZÆØÅ][a-zA-ZæøåÆØÅ\- ]{1,19}"
				title="Fornavnet må starte med stor bokstav og kan inneholde bokstaver, 
				bindestrek og mellomrom. (2–20 tegn)"
				required> 
		
		<label for= "etternavn">Etternavn</label> <br>
		<input type="text" id="etternavn" name="etternavn" 
				pattern="[A-ZÆØÅ][a-zA-ZæøåÆØÅ\-]{1,19}"
				title="Første tegn skal være en stor bokstav. 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) og
				bindestrek (IKKE mellomrom)."
				required>
		
		<label for="mobil">Mobil(8 siffer)</label>
		<input type="text" id="mobil" name="mobil" 
				pattern="[0-9]{8}"
				required>
		
		<label for="passord">Passord:</label>
		<input type="password" id="passord" name="passord" 
				pattern="[A-ZÆØÅ][a-zA-ZæøåÆØÅ0-9\-]{6,20}"
				required>
		
		<label for="passordRep">Passord repetert</label>
		<input type="password" id="passordRep" name="passordRep" required> <br>
		
		<button type="button" onclick="togglePassword()">Vis / Skjul</button>
		
		<label>
			<input type="radio" name="kjonn" value="Mann" required>
			Mann
		</label>
		
		<label>
			<input type="radio" name="kjonn" value="Kvinne" required>
			Kvinne
		</label>
		
		<button id="meldMegPaa">Meld meg på!</button> <!-- Må bruke form.submit() i javaMetoden-->
		<!-- <input type="submit" id="meldMegPaa"> kan bruke denne som redirecter til
		action="/valgtNettside" -->

		
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
