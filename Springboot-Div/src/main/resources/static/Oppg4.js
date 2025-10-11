
let valgtOperator = null;

function velgAntall(){
    const antall = parseInt(document.getElementById("antall").value);
    const container = document.getElementById("inputContainer");
    container.innerHTML = ""; //tømmer tidligere inputfelt - MÅ ikke ha

    //Sjekker om det er tall du skriver inn, og må være 2 tall som regnes på
    if(isNaN(antall) || antall < 2){
        alert("Minst 2 tall for å regne");
        return;
    }

    document.getElementById("numberText").classList.remove("hidden");

    for(let i=0; i<antall; i++){
        const input = document.createElement("input");
        input.type = "number";
        input.placeholder = "Tall " + (i+1);
        container.appendChild(input)
    }

    document.getElementById("operatorContainer").classList.remove("hidden");
}

function settOperator(op){
    valgtOperator = op;
    document.getElementById("executeBtn").classList.remove("hidden");
}


function execute(){
    const inputs = document.querySelectorAll("#inputContainer input");
    // # forran inputContainer betyr -> 
    // «finn alle <input>-elementer som ligger inne i elementet med id inputContainer».
    const tall = Array.from(inputs).map(input=> parseFloat(input.value));

    if(tall.some(isNaN)){
        alert("Fyll inn alle tall!")
        return;
    } else if(valgtOperator === '/' && tall.slice(1).some(x => x === 0)){
        alert("kan ikke dele på 0!")
        return;
    }

    //begynner prosessen med første tall tastet inn,
    //deretter bruke regneoperator i påfølgende tall
    let resultat = tall[0];

    for(let i=1; i< tall.length; i++){
        switch(valgtOperator){
            case '+': resultat +=tall[i]; break;
            case '-': resultat -=tall[i]; break;
            case '*': resultat *=tall[i]; break;
            case '/': resultat /=tall[i]; break;
        }
    }

    document.getElementById("output").textContent = resultat;
    document.getElementById("result").classList.remove("hidden");


}