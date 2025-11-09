package com.DAT108_Oblig4_Del2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.DAT108_Oblig4_Del2.Deltager;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

class ValidatorTest {

	private Validator validator;

	private Deltager testPerson;

	@BeforeEach
	void setUp() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();

		testPerson = new Deltager();
		testPerson.setFornavn("Henrik");
		testPerson.setEtternavn("Ibsen");
		testPerson.setKjonn("Mann");
		testPerson.setMobil("12345678");
		testPerson.setPlainPassord("Hemmelig123");
	}

	@Test
	void harFornavnStorBokstav() {
		testPerson.setFornavn("henrik");
		sjekkFeilmelding("Fornavnet må starte med stor bokstav og kan inneholde bokstaver, bindestrek og mellomrom. (2–20 tegn)");
	}
	
	@Test
	void fornavnIkkeNull() {
		testPerson.setFornavn(null);
		sjekkFeilmelding("Fornavn må fylles ut");
	}
	
	@Test
	void etternavnIngenMellomrom() {
		testPerson.setEtternavn("Ibsen is");
		sjekkFeilmelding("Første tegn skal være en stor bokstav. 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) og bindestrek (IKKE mellomrom)");
	}
	
	@Test
	void etternavnIkkeNull() {
		testPerson.setEtternavn(null);
		sjekkFeilmelding("Etternavn må fylles ut");
	}
	
	@Test
	void etternavnIngenFeilmeldingBindestrek() {
		testPerson.setEtternavn("Ibsen-Ole");
		Set<ConstraintViolation<Deltager>> violations = validator.validate(testPerson);
		assertTrue(violations.isEmpty());
	}
	
	
	//hjelpemetode for å sjekke spesifike tilbakemeldinger 
	private void sjekkFeilmelding(String feilmelding) {

		Set<ConstraintViolation<Deltager>> violations = validator.validate(testPerson);
		assertFalse(violations.isEmpty());
		assertThat(violations).hasSize(1);

//		Henter ut feilmeldingen fra det ene violation-objektet
		String violationMessage = violations.iterator().next().getMessage();
		assertEquals(feilmelding, violationMessage);
	}
}

