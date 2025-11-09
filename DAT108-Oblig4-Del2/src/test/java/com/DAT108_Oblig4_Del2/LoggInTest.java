package com.DAT108_Oblig4_Del2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@ExtendWith(MockitoExtension.class) 
public class LoggInTest {
	
	@Mock
    private DeltagerRepo deltagerRepo;

    @Mock
    private PassordService passordService;

    @Mock
    private HttpSession session;

    @Mock
    private RedirectAttributes ra;
    
    @InjectMocks
    private LoggInService loggInService; // Dette er det vi skal teste, så denne må injeseres ikke fakes
	
	@Test 
	void loggInGyldigBruker(){
		
		String mobil = "12345678";
		String passord = "hemmelig";
		
		Deltager deltager = new Deltager();
		deltager.setMobil(mobil);
		deltager.setHash("fakeHash");
		deltager.setSalt("fakeSalt");
		
		when(deltagerRepo.findByMobil(mobil)).thenReturn(deltager);
		when(passordService.erKorrektPassord(passord, deltager.getSalt(), deltager.getHash())).thenReturn(true);
		
		//Lager et kunstig resultat
		String resultat = loggInService.LoggInn(session, ra, mobil, passord);
		
		//Asserten
		verify(session).setAttribute("d", deltager);
		assertEquals("redirect:/deltagerliste", resultat);
	}
}

