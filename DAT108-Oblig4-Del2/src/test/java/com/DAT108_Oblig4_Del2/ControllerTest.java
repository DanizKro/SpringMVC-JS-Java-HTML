package com.DAT108_Oblig4_Del2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@ExtendWith(MockitoExtension.class)
public class ControllerTest {
	
	@Mock
	BindingResult bindingResult;
	
	@Mock
	HttpSession session;
	
	@Mock
	RedirectAttributes ra;
	
	@Mock
	DeltagerRepo deltagerRepo;
	
	@Mock
	PassordService passordService;
	
	@InjectMocks
	private PaameldingController controller;	//Dette er metoden vi skal teste, så den må injeseres, ikke fakes med Mock
	
	@Test
	void nyDeltagerRegistrering() {
		
		Deltager deltager = new Deltager("Daniel","Kron", "12345678", "passord", "mann");
		String passordRep = "passord";
		
		when(bindingResult.hasErrors()).thenReturn(false);
		when(deltagerRepo.findByMobil("12345678")).thenReturn(null);
		when(passordService.genererTilfeldigSalt()).thenReturn("salt123");
		when(passordService.hashMedSalt("passord", "salt123")).thenReturn("hashetPassord");
		
		//Lager et kall til metoden vi skal teste -> som returnerer en String med resultat
		String resultat = controller.paameldingMedMelding(deltager,bindingResult,session,ra,passordRep);
		
		//Asserts									  //Kunne delt metoden opp å hjelpeklasser, for mer nøye testing
		verify(deltagerRepo).save(deltager);		  //Metoden skal lagre deltager i deltagerRepo
		verify(session).setAttribute("d", deltager);  //Metoden skal sette deltager til session med attributt "d"
		assertNull(deltager.getPlainPassord());		  //Metoden skal slette plainPassord
		assertEquals("redirect:/paameldt", resultat); //Metoden skal returnere en String som går til paameldt
		
		
	}
	
	@Test
	void hvisDeltagerFinnes() {
		
		Deltager deltager = new Deltager("Daniel","Kron", "12345678", "passord", "mann");
		
		when(bindingResult.hasErrors()).thenReturn(false);
		when(deltagerRepo.findByMobil("12345678")).thenReturn(deltager);
		
		//test av metoden
		String resultat = controller.paameldingMedMelding(deltager, bindingResult, session, ra, "passord");
		
		//Assert
		verify(ra).addFlashAttribute("finnes", "Deltager finnes fra før av!");
		verify(deltagerRepo, never()).save(deltager); //never() -> verifiser at metoden deltagerRepo.save(deltager) ikke skjer
		verify(session, never()).setAttribute("d", deltager);
		assertEquals("redirect:/paamelding", resultat);
	}
}
