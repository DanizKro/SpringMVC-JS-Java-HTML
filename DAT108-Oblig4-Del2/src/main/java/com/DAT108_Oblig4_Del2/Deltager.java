package com.DAT108_Oblig4_Del2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(schema = "DAT108_oblig4")
public class Deltager {


	@Id
	@Pattern(regexp = "^\\d{8}$", message = "Mobilnummer må være eksakt 8 sifre")
	@NotNull(message = "Mobil må fylles ut")
	private String mobil;

	@Transient
	@Pattern(regexp = "[a-zA-ZæøåÆØÅ0-9]{6,20}", message = "Passord kan bestå av stor bokstav eller tall, lengde 6-20 symboler")
//	@NotNull(message = "Passord må fylles ut")
	private String plainPassord;

	@Pattern(regexp = "[A-ZÆØÅ][a-zæøå\\- ]{1,19}", message = "Fornavnet må starte med stor bokstav og kan inneholde bokstaver, bindestrek og mellomrom. (2–20 tegn)")
	@NotNull(message = "Fornavn må fylles ut")
	private String fornavn;

	@Pattern(regexp = "[A-ZÆØÅ][a-zA-ZæøåÆØÅ\\-]{1,20}", message = "Første tegn skal være en stor bokstav. 2-20 tegn og kan inneholde bokstaver (inkl. æøåÆØÅ) og bindestrek (IKKE mellomrom)")
	@NotNull(message = "Etternavn må fylles ut")
	private String etternavn;

	private String hash;
	private String kjonn;
	private String salt;

	public Deltager() {

	}

	public Deltager(String fornavn, String etternavn, String mobil, String passord, String kjonn) {
		super();
		this.mobil = mobil;
		this.hash = passord;
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

	public String getPlainPassord() {
		return plainPassord;
	}

	public void setPlainPassord(String plainPassord) {
		this.plainPassord = plainPassord;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String lagretPassord) {
		this.hash = lagretPassord;
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "Deltager [mobil=" + mobil + ", passord=" + hash + ", fornavn=" + fornavn + ", etternavn="
				+ etternavn + ", kjonn=" + kjonn + "]";
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

}
