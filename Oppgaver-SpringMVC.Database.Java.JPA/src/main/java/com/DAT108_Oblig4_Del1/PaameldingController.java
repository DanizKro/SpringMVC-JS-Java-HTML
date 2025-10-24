package com.DAT108_Oblig4_Del1;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

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

	// Må bruke postMapping fordi at det ikke skal skrives data i nettadressen(mer
	// sikker)
	@PostMapping("/paamelding")
	public String paameldingMedMelding(@Valid Deltager deltager, BindingResult bindingResult, Model model, String passordRep) {
		
		//Sjekker om det er veliderings-feil
		if(bindingResult.hasErrors()) {
			List<String> feilmeldinger = bindingResult.getAllErrors().stream()
					.map(e -> e.getDefaultMessage()).toList();
			model.addAttribute("feilmeldinger", feilmeldinger);
			return "paameldingMelding";
		}

		// Sjekker om deltager finnes ved å sjekke om det finnes en deltager med samme mobilnummer
		boolean finnes = DeltagerData.data.stream().anyMatch(d -> d.getMobil().equals(deltager.getMobil()));
		if (finnes) {
			model.addAttribute("finnes", "Deltager finnes fra før av!");
			return "paameldingMelding";
		}

		//sjekker passord om det stemmer med inntastet og ny bruker
		if (!deltager.getPassord().equals(passordRep)) {
			model.addAttribute("passord", "Passord samsvarer ikke");
			return "paameldingMelding";
		}
		
		//Hvis alt ok, legger til deltager og sorterer på fornavn, deretter etternavn
		DeltagerData.data.add(deltager);
	    DeltagerData.data.sort((a,b)-> {
	    	
        	//sorterer på fornavn
        	int compFornavn = a.getFornavn().compareTo(b.getFornavn());
        	
        	//hvis fornavn er like, sorteres de på etternavn
        	if(compFornavn == 0) {
        		return a.getEtternavn().compareToIgnoreCase(b.getEtternavn());
        	}
        	return compFornavn;
        });

        model.addAttribute("d", deltager);
        return "paameldt";
	}
}
