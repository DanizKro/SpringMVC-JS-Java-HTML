<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="no">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/simple.css">
	<title>Deltagerliste</title>
</head>
<body>
	<script>
			function kjonn(kjonn) {
				if (kjonn.toLowerCase() === "kvinne") {
					return "&#9792;";
				} else {
					return "&#9794;";
				}
			}
		</script>
	
	<p>Innlogget som: ${d.mobil}/${d.fornavn} ${d.etternavn}</p>
		
	<h2>Deltagerliste</h2>
	<table>
		<tr>
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>

		<c:forEach var="e" items="${deltagere}">
			<tr ${e.mobil == d.mobil ? 'class="highlight"' : ''}>
				<td align="center">
					<script>
						document.write(kjonn("${e.kjonn}"));
					</script>
				</td>
				<td>${e.fornavn} ${e.etternavn}</td>
				<td>${e.mobil}</td>
			</tr>
		</c:forEach>
	</table>
	
	<form action="/logut"method="get">
		<button>Logg ut</button>
	</form>
</body>
</html>