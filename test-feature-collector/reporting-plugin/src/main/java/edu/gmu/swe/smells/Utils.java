package edu.gmu.swe.smells;

public class Utils {
	public static String escapeStrForOutput(String str){
		if(str == null)
			return null;
		return str.replace(',','-');
	}
}
