<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="no">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/simple.css">
<title>Påmeldingsbekreftelse</title>
</head>
<body>
	<h2>Påmeldingsbekreftelse</h2>
	<p>Påmeldingen er mottatt for:</p>
	<p>
		&nbsp;&nbsp;&nbsp;${d.fornavn}<br/> <!-- &nbsp; "non-breaking space" lager mellomrom betyr -->
		&nbsp;&nbsp;&nbsp;${d.etternavn}<br/>
		&nbsp;&nbsp;&nbsp;${d.mobil}<br/> 
		&nbsp;&nbsp;&nbsp;${d.kjonn}
	</p>
	<a href="innlogging">Gå til deltagerlisten</a>
</body>
</html>
