package com.DAT108_Oblig4_Del2;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PassordServiceTest {

	Deltager person = new Deltager("Daniel","Kron", "47951948", "passord", "mann");
	PassordService service = new PassordService();
	
	
	@BeforeEach
	void setPassord() {
		
		String salt = service.genererTilfeldigSalt();
		person.setSalt(salt);
		String hash = service.hashMedSalt(person.getPlainPassord(), person.getSalt());
		person.setHash(hash);
	}
	
	@Test
	void passordBlirHashet() {
		String salt = service.genererTilfeldigSalt();
		assertNotEquals(person.getPlainPassord(), service.hashMedSalt(person.getPlainPassord(), salt));
		
	}
	
	@Test
	void erRiktigPassord() {
		assertTrue(service.erKorrektPassord(person.getPlainPassord(), person.getSalt(), person.getHash()));
	}
	
	@Test
	void riktigSaltFeilPassord() {
		assertFalse(service.erKorrektPassord("feilPassord", person.getSalt(), person.getHash()));
	}
	
	@Test
	void feilPassordRiktigSalt() {
		String feilSalt = service.genererTilfeldigSalt();
		
		assertFalse(service.erKorrektPassord(person.getPlainPassord(), feilSalt, person.getHash()));
	}
}
