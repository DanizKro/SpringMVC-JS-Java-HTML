"use strict";

/**
 * Klasse med demonstrasjoner.
 * Et objekt hadde her kanskje passet bedre, men det tar vi i DAT152.
 */
class Demo {
    /**
     * Initialiserer Demo
     * @param {HTMLElement} rootElement - HTML container-elementet,  DIV
     *     elementet med HTML button som aktiverer demonstrasjonene.
     */
    constructor (rootElement) {
        this.setbg = this.setbg.bind(this);

        const demoButton = rootElement.querySelector("button[type='button']");
        demoButton.addEventListener('click',this.setbg);

        this.showtime();
    }

    /**
     * Metode som toggler HTML CLASS attributt for BODY.
     * @private
     * @listens Button:click
     */
    setbg() {
        document.body.classList.toggle("jsdemo_emph");
    }

    /**
     * Metode som viser tidspunktet i et alert-vindu
     * @private
     */
    showtime() {
        const now = new Date();
        const hours = now.getHours();
        const minuts = now.getMinutes();
        window.alert(`Velkommen! Klokken er nå ${hours}:${minuts}.`);
    }
}

function init () {
    const rootElement = document.getElementById('root');
    new Demo(rootElement);
}
document.addEventListener('DOMContentLoaded',init);
