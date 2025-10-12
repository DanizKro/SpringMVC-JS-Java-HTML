package com.DAT108_Oblig4_Del1;

public class Deltager {
	
	private String mobil;
	private String passord;
	private String fornavn;
	private String etternavn;
	private String kjonn;
	
	public Deltager(String mobil, String passord, String fornavn, String etternavn, String kjonn) {
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
