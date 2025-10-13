package com.DAT108_Oblig4_Del1;

import java.util.ArrayList;
import java.util.List;

public class DeltagerData {
	
	public static List<Deltager> data;
	
	static {
		data = new ArrayList<>();
		
		data.add(new Deltager("Anne", "Panne","12345678","passord123", "Mann"));
		data.add(new Deltager("Ulf", "Kjos","13462345", "1pass2ord3", "Mann"));
		data.add(new Deltager("Lars-Petter", "Helland","12345678", "12passord", "Mann"));
		data.add(new Deltager("Kristine", "Frekkhaug", "12345678", "Pass23ord","Kvinne"));
		data.add(new Deltager( "Arvid", "Garvik","12345678","2Pass3ord","Mann"));
	}
	
	

}
