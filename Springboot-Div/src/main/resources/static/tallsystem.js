
const root = document.getElementById("root");
root.getElementsByTagName("button")[0].addEventListener("click", regnut);

function regnut() {
  const tallElement = root.getElementsByTagName("input")[0];
  const radixElement = root.getElementsByTagName("input")[1];
  const tall = parseInt(tallElement.value);
  const radix = parseInt(radixElement.value);
  const resultatElement = root.getElementsByTagName("p")[0];

  if (tall > 0 && radix > 2 && radix <= 36) {
    resultatElement.getElementsByTagName("span")[0].textContent = tall;
    resultatElement.getElementsByTagName("span")[1].textContent = radix;
    resultatElement.getElementsByTagName("span")[2].textContent = tall.toString(radix);
    resultatElement.classList.remove("hidden");
  } else {
    resultatElement.classList.add("hidden");
  }
}
