<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
</head>
	
<body>
	<h2>Logg inn</h2>
	<p id="feillogginn" style="color:red; display:${melding != null ? 'block':'none'}">${melding}</p>
	<form action="/innlogging" method="post">
		<lable>Mobil:</lable> </br>
		<input type="text" name="mobil"> </br>
		<lable>Passord:</lable> </br>
		<input id="pw" type="password" name="plainPassord"> </br>
		</br>
		<button type="button" onclick="togglePassword()">Vis / Skjul</button>
		<button id="logginn">Logg inn</button>
	</form>

	<a href="paamelding">Gå til påmelding</a>
</body>

<script>
		documentGetElementById("logginn").addEventListener("click", function(event){
		const form = document.querySelector("form");
		form.sumbit();
	});
	
	function togglePassword() {
		const input = document.getElementById("pw");
				  
		if(input.type === "password") {    //Egen innebygget Type i HTML,
			input.type = "text";										 //type="password" gir stjerner i innput felt
		} else {
			input.type = "password";
		}
	}
</script>
</html>