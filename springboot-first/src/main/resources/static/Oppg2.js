
function converter(selectElement) {
  const valg = document.getElementById("valg").value;

  if (valg === "C") {
    convertCelciusToFahrenheit();
  } else if (valg === "F") {
    convertFahrenheitToCelsius();
  }
}

function convertFahrenheitToCelsius() {
  let f = document.getElementById("Grader").value;
  let c = ((f - 32) * 5) / 9;
  document.getElementById("Svar").value = c.toFixed(2) + "°C";
}

function convertCelciusToFahrenheit() {
  let f = document.getElementById("Grader").value;
  let c = (f * 9) / 5 + 32;
  document.getElementById("Svar").value = c.toFixed(2) + "°F";
}
