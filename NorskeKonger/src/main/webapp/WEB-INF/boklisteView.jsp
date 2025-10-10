<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="simple.css">
  </head>
  <body>
	<h4>Bokliste</h4>
	<!--  Fyll inn lenker til nytt søk og alle bøker -->
	<table><tr>
			<th align="left">Tittel</th>
			<th align="left">Forfatter</th>
			<th>År</th>
		</tr>
		<!-- Fyll inn forEach-tag for å iterere gjennom listen av bøker -->
		<c:forEach var="bok" items="${bokliste}">
		<tr>
			<td align="left">${bok.tittel}</td> <!--bok.getTittel()-->
			<td align="left">${bok.forfatter}</td>
			<td>${bok.utgivelsesaar}</td>
		</tr>
		</c:forEach>
	</table>
	
  </body>
</html>
