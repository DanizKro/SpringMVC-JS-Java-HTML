package com.DAT108_Oblig4_Del1;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class PaameldingController {

	@GetMapping("/paameldt")
	public String paameldt(HttpSession session, Model model) {
		
		Deltager deltager = (Deltager) session.getAttribute("d");
		model.addAttribute("d", deltager);

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
	public String paameldingMedMelding(@Valid Deltager deltager, 
			BindingResult bindingResult, 
			HttpSession session,
			RedirectAttributes ra, 
			String passordRep) {
		
		//Sjekker om det er veliderings-feil
		if(bindingResult.hasErrors()) {
			List<String> feilmeldinger = bindingResult.getAllErrors().stream()
					.map(e -> e.getDefaultMessage()).toList();
			ra.addFlashAttribute("feilmeldinger", feilmeldinger);
			//ra.addFlashAttribute("deltager", deltager);
			return "redirect:paamelding";
		}

		// Sjekker om deltager finnes ved å sjekke om det finnes en deltager med samme mobilnummer
		boolean finnes = DeltagerData.data.stream().anyMatch(d -> d.getMobil().equals(deltager.getMobil()));
		if (finnes) {
			ra.addFlashAttribute("finnes", "Deltager finnes fra før av!");
			//ra.addFlashAttribute("deltager", deltager);
			return "redirect:/paamelding";
		}

		//sjekker passord om det stemmer med inntastet og ny bruker
		if (!deltager.getPassord().equals(passordRep)) {
			ra.addFlashAttribute("passord", "Passord samsvarer ikke");
			//ra.addFlashAttribute("deltager", deltager);
			return "redirect:/paamelding";
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

	    session.setAttribute("d", deltager);
	    return "redirect:paameldt";
	    
	}
}
