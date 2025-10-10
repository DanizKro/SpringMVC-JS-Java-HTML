package no.hvl.dat108;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoklisteController {

	@GetMapping("/alleboker")
	public String alleBoker(Model model) {
		
		//Hente listen av bøker fra en database
		List<Bok> boker = Boker.alleBoker;
		
		//Lagrer som attributt
		model.addAttribute("bokliste",boker);
		
		//Videre til viewet
		return "boklisteView"; //navnet på viewet
	}

	@GetMapping("/noenboker")
	public String noenBoker(Model model, String forfatter) {
		
		//søker
		List<Bok> boker = Boker.alleBoker.stream().filter((bok) -> bok.getForfatter().contains(forfatter)).toList();
		
		model.addAttribute("bokliste",boker);
		
		//Videre til viewet
		return "boklisteView"; //navnet på viewet
	}
	
	@GetMapping("/gjestebok")
		public String gjestebok() {
		
			return null;
		}
	
	
		
	}
