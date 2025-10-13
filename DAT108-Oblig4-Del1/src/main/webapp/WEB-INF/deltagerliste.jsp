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
		
	<h2>Deltagerliste</h2>
	<table>
		<tr>
			<th>Kjønn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>

		<c:forEach var="d" items="${deltagere}">
			<tr>
				<td align="center">
					<script>
						document.write(kjonn("${d.kjonn}"));
					</script>
				</td>
				<td>${d.fornavn} ${d.etternavn}</td>
				<td>${d.mobil}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>