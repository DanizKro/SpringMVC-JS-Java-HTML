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
	<p id="feilmelding" style="color:red; display:${passord != null ? 'block':'none'}">
		    ${passord}</p>
	<p id="deltagerFinnes" style="color:red; display:${finnes != null ? 'block':'none'}">
	    ${finnes}
	</p>

	<!-- Jeg har fjernet alt som har med form og input å gjøre,
		 siden dette er pensum. Her får dere sette opp skjemaet
		 selv. Lykke til.
	-->
	
	<form action="/paamelding" method="post">
		<fieldset> <!-- fieldset og legend er pynte ramme rundt-->
		
		<label for="fornavn">Fornavn</label>  <!-- kan bruke name="fornavn" for å ha klikkbar tekst -->
		<input type="text" name="fornavn"
				pattern="[A-ZÆØÅ][a-zA-ZæøåÆØÅ\- ]{1,19}"
				title="Fornavnet må starte med stor bokstav og kan inneholde bokstaver, 
				bindestrek og mellomrom. (2–20 tegn)"
				required> 
		
		<label for= "etternavn">Etternavn</label>
		<input type="text" name="etternavn" 
				pattern="[A-ZÆØÅ][a-zA-ZæøåÆØÅ\-]{1,19}"
				title="Første tegn skal være en stor bokstav. 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) og
				bindestrek (IKKE mellomrom)."
				required>
		
		<label for="mobil">Mobil(8 siffer)</label>
		<input type="text" name="mobil"
				title="Må bestå av 8 tall." 
				pattern="[0-9]{8}"
				required>
				
	<!--type="password" gir stjerner i innput felt, egen funksjon som bytter mellom type="text" og type="password"-->
		<label for="passord">Passord:</label>
		<input id="pw1" type="password" name="passord" 
				pattern="[a-zA-ZæøåÆØÅ0-9]{6,20}"
				title="Passord kan bestå av stor bokstav eller tall, lengde 6-20 symboler."
				required>
		
		<label for="passordRep">Passord repetert</label>
		<input id="pw2" type="password" name="passordRep"
				pattern="[a-zA-ZæøåÆØÅ0-9]{6,20}"
				title="Passord kan bestå av stor bokstav eller tall, lengde 6-20 symboler."
				required> <br>
		
		<button type="button" onclick="togglePassword()">Vis / Skjul</button>
		
		<label>
			<input type="radio" name="kjonn" value="Mann" required>
			Mann
		</label>
		
		<label>
			<input type="radio" name="kjonn" value="Kvinne" required>
			Kvinne
		</label>
		
		<button id="meldMegPaa">Meld meg på!</button> <!-- Må bruke form.submit() i et eget script med EventListner -->
		<!-- <input type="submit" Value="Meld meg på!" id="meldMegPaa"> kan bruke denne som redirecter til
		action="/valgtNettside" -->

		</fieldset>
	</form>
	
	<script>
			function togglePassword() {
			  const input = document.getElementById("pw1");
			  const input2 = document.getElementById("pw2");
			  
			  if (input.type === "password" && input2.type === "password") { //Egen innebygget Type i HTML,
			    input.type = "text";										 //type="password" gir stjerner i innput felt
				input2.type = "text";
			  } else {
			    input.type = "password";
				input2.type = "password";
			  }
			}
			//Må sjekke validering før .submit() fordi button går rett forbi grunnet en vanlig button, kan bruke type="submit"
			document.getElementById("meldMegPaa").addEventListener("click", function(event){
			  const form = document.querySelector("form");

			  if (form.checkValidity()) {
			    form.submit();
			  } else {
			    form.reportValidity();
			  }
			});
			
	</script>
	
	<a href="deltagerliste">Se deltagerlisten</a>
</body>
</html>
