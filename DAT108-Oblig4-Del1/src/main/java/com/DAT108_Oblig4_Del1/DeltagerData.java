package com.DAT108_Oblig4_Del1;

import java.util.ArrayList;
import java.util.List;

public class DeltagerData {
	
	public static List<Deltager> data;
	
	static {
		data = new ArrayList<>();
		
		data.add(new Deltager("12345678", "passord123", "Anne", "Panne", "Mann"));
		data.add(new Deltager("13462345", "1pass2ord3", "Ulf", "Kjos", "Mann"));
		data.add(new Deltager("12345678", "12passord", "Lars-Petter", "Helland", "Mann"));
		data.add(new Deltager("12345678", "Pass23ord", "Kristine", "Frekkhaug", "Kvinne"));
		data.add(new Deltager("12345678", "2Pass3ord", "Arvid", "Garvik", "Mann"));
	}
	
	

}
