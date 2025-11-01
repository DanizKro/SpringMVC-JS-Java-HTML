package com.DAT108_Oblig4_Del2;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class Deltager {
	
	@Pattern(regexp="^\\d{8}$", message="Mobilnummer må være eksakt 8 sifre")
	@NotNull(message="Mobil må fylles ut")
	private String mobil;
	
	@Pattern(regexp="[a-zA-ZæøåÆØÅ0-9]{6,20}", message="Passord kan bestå av stor bokstav eller tall, lengde 6-20 symboler")
	@NotNull(message="Passord må fylles ut")
	private String passord;
	
	
	@Pattern(regexp="[A-ZÆØÅ][a-zæøå\\- ]{1,19}", 
	message="Fornavnet må starte med stor bokstav og kan inneholde bokstaver, bindestrek og mellomrom. (2–20 tegn)")
	@NotNull(message="Fornavn må fylles ut")
	private String fornavn;
	
	@Pattern(regexp="[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]{1,20}", 
	message="Første tegn skal være en stor bokstav. 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) og bindestrek (IKKE mellomrom)")
	@NotNull(message="Etternavn må fylles ut")
	private String etternavn;
	
	
	private String kjonn;
	
	public Deltager() {
		
	}
	
	public Deltager(String fornavn, String etternavn, 
			String mobil,String passord, String kjonn) {
		super();
		this.mobil = mobil;
		this.passord = passord;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}

	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getKjonn() {
		return kjonn;
	}

	@Override
	public String toString() {
		return "Deltager [mobil=" + mobil + ", passord=" + passord + ", fornavn=" + fornavn + ", etternavn=" + etternavn
				+ ", kjonn=" + kjonn + "]";
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}
	
	

}
