package com.DAT108_Oblig4_Del1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaameldingController {

	@GetMapping("/paameldt")
	public String paameldt() {
		
		return "paameldt";
	}
	
	@GetMapping("/deltagerliste")
	public String deltagerliste() {
		
		return "deltagerliste";
	}
	
	@GetMapping("paameldingMelding")
	public String paameldingMedMelding() {
		
		return "paameldingMelding";
	}
}
