package com.DAT108_Oblig4_Del1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;


@Controller
public class PaameldingController {

	@GetMapping("/paameldt")
	public String paameldt() {
		
		return "paameldt";
	}
	
	@GetMapping("/deltagerliste")
	public String deltagerliste(Model model) {
		
		model.addAttribute("deltagere", DeltagerData.data);
		
		return "deltagerliste";
	}
	
	@GetMapping("/paamelding")
	public String visPaameldingSkjema() {
		return "paameldingMelding";
	}
	
	//Må bruke postMapping fordi at det ikke skal skrives data i nettadressen(mer sikker)
	@PostMapping("/paamelding")
	public String paameldingMedMelding(Model model, String fornavn, String etternavn, 
	                                   String mobil, String passord, String passordRep, String kjonn) {
	    
	    // Sjekker om mobil finnes
	    boolean finnes = DeltagerData.data.stream()
	                        .anyMatch(d -> d.getMobil().equals(mobil));
	    if (finnes) {
	        model.addAttribute("finnes", "Deltager finnes fra før av!");
	        return "paameldingMelding";
	    }
	    
	    // Hvis mobil ikke finnes og passordene er like opprettes deltager
	    if (passord != null && passord.equals(passordRep)) {
	        Deltager d1 = new Deltager(fornavn, etternavn, mobil, passord, kjonn);
	        DeltagerData.data.add(d1);
	        DeltagerData.data.sort((a,b)-> {
	        	//sorterer på fornavn
	        	int compFornavn = a.getFornavn().compareTo(b.getFornavn());
	        	//hvis fornavn er like, sorteres de på etternavn
	        	if(compFornavn == 0) {
	        		return a.getEtternavn().compareToIgnoreCase(b.getEtternavn());
	        	}
	        	return compFornavn;
	        });
	        model.addAttribute("d", d1);
	        return "paameldt";
	    } else { // Passordene samsvarer ikke
	        model.addAttribute("passord", "Passord samsvarer ikke");
	        return "paameldingMelding";
	    }
	}
	
	
	
	
	
	
}
