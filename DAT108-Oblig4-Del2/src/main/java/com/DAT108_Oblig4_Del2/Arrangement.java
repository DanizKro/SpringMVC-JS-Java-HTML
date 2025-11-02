package com.DAT108_Oblig4_Del2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(schema = "DAT108_oblig4")
public class Arrangement {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id ;
	
	private String navn;
	
	@Override
	public String toString() {
		return String.format("Arrangement: id=%d, navn=%s", id, navn);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	

}
