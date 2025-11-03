package com.DAT108_Oblig4_Del2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class PaameldingController {
	
//	@Autowired
	private DeltagerRepo deltagerRepo;
//	@Autowired
	private PassordService passordService;
	
	//kan bruke en kontrukstør for å gjøre injection av klasser slik:
	public PaameldingController(DeltagerRepo deltagerRepo,PassordService passordService) {
		this.deltagerRepo = deltagerRepo;
		this.passordService = passordService;
	}
	
	@GetMapping("/logut")
	public String logUt(HttpSession session, RedirectAttributes ra) {
		if(session != null) {
			session.invalidate();
		}
		ra.addFlashAttribute("melding", "Du er logget ut");
		return "redirect:/innlogging";
	}
	
	@GetMapping("/innlogging")
	public String visInnlogging(HttpSession session) {
		return "innlogging";
	}
	
	@PostMapping("/innlogging")
	public String innlogging(HttpSession session, RedirectAttributes ra, String mobil, String plainPassord) {
		
		Deltager bruker = deltagerRepo.findByMobil(mobil);
		
		if(bruker == null) {
			ra.addFlashAttribute("melding", "Bruker finnes ikke");
			return"redirect:/innlogging";
		}
		boolean passordSjekk = passordService.erKorrektPassord(plainPassord, bruker.getSalt(), bruker.getHash());
		
		if(!passordSjekk) {
			ra.addFlashAttribute("melding", "Ugyldig passord");
			return "redirect:/innlogging";
		}
		session.setAttribute("d", bruker);
		
		return "redirect:/deltagerliste";
	}
	
	@GetMapping("/paameldt")
	public String paameldt(HttpSession session, Model model) {	
		Deltager deltager = (Deltager) session.getAttribute("d");
		model.addAttribute("d", deltager);
		return "paameldt";
	}

	
	@GetMapping("/deltagerliste")
	public String deltagerliste(HttpSession session, Model model, RedirectAttributes ra) {
		//Sjekker om man har logget inn for å lese deltagerlisten
		Deltager innlogget = (Deltager) session.getAttribute("d");
		if(innlogget == null) {
			ra.addFlashAttribute("melding", "Du må logge inn for å se deltagerlisten");
			return "redirect:/innlogging";
		}
		
		List<Deltager> liste = deltagerRepo.findAll();
	    liste.sort((a,b)-> {
        	//sorterer på fornavn
        	int compFornavn = a.getFornavn().compareTo(b.getFornavn());
        	//hvis fornavn er like, sorteres de på etternavn
        	if(compFornavn == 0) {
        		return a.getEtternavn().compareToIgnoreCase(b.getEtternavn());
        	}
        	return compFornavn;
        });
	    
	    model.addAttribute("deltagere", liste);
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
			return "redirect:/paamelding";
		}

		// Sjekker om deltager finnes ved å sjekke om det finnes en deltager med samme mobilnummer
		Deltager finnes = deltagerRepo.findByMobil(deltager.getMobil());
		if (finnes != null) {
			ra.addFlashAttribute("finnes", "Deltager finnes fra før av!");
			//ra.addFlashAttribute("deltager", deltager);
			return "redirect:/paamelding";
		}

		//sjekker passord om det stemmer med inntastet og ny bruker
		if (!deltager.getPlainPassord().equals(passordRep)) {
			ra.addFlashAttribute("passord", "Passord samsvarer ikke");
			//ra.addFlashAttribute("deltager", deltager);
			return "redirect:/paamelding";
		}
		
		//Lagrer passord sikkert
		String salt = passordService.genererTilfeldigSalt();
		String hash = passordService.hashMedSalt(deltager.getPlainPassord(), salt);
		deltager.setHash(hash);
		deltager.setSalt(salt);
		
		//Hvis alt ok, legger til deltager i databasen
		deltagerRepo.save(deltager);
		deltager.setPlainPassord(null);

	    session.setAttribute("d", deltager);
	    return "redirect:/paameldt";
	    
	}
	
	
}
