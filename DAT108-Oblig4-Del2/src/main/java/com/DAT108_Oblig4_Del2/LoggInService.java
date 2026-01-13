package com.DAT108_Oblig4_Del2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Service
public class LoggInService {

	@Autowired
	private DeltagerRepo deltagerRepo;
	@Autowired
	private PassordService passordService;
	

	public void loggUt(HttpSession session, RedirectAttributes ra) {
		if(session.getAttribute("d") != null) { //litt usikker på denne
			session.invalidate();
		}
		ra.addFlashAttribute("melding", "Du er logget ut");
	}

	public String LoggInn(HttpSession session, RedirectAttributes ra, String mobil, String plainPassord) {

		//sjekker først om brukeren finnes i databasen
		Deltager bruker = deltagerRepo.findByMobil(mobil);

		if (bruker == null) {
			ra.addFlashAttribute("melding", "Bruker finnes ikke");
			return "redirect:/innlogging";
		}
		boolean passordSjekk = passordService.erKorrektPassord(plainPassord, bruker.getSalt(), bruker.getHash());

		if (!passordSjekk) {
			ra.addFlashAttribute("melding", "Ugyldig passord");
			return "redirect:/innlogging";
		}
		//hvis alt ok, legger til bruker i session med variabelnavn "d".
		session.setAttribute("d", bruker);
		return "redirect:/deltagerliste";
	}

}
