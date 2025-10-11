package no.hvl.dat108.f11;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KongerController {
	
	@GetMapping("/kongesok")
		public String visSokSide() {
		//returnerer navnet på view
		return "kongesok";
		
	}
	
	@GetMapping("/finnKonge")
	public String finnKonge(Model model, @RequestParam("aarstall") String aarstall) {
		
		int aar = Integer.parseInt(aarstall);
		
		//Finner konge
		List<Konge> liste = Konger.norske.stream()
				.filter((konge) -> konge.getKongeFraAar() <= aar && konge.getKongeTilAar() >= aar)
				.toList();
		
		if (liste.isEmpty()) {
		    model.addAttribute("ingen", true);
		} else {
		    model.addAttribute("k", liste.get(0));
		}
		//laster også opp aar som parameter fordi vi vil kunne bruke den i kongeView.jsp filen
		model.addAttribute("aarstallFraSok", aar );
		
		//Vises med egen HTML side som heter kongeView
		return "kongeView";
	}
	
	
	
	
	}
