package product;

import java.awt.Color;

public class Helper {

	public static int i;
	//{ new Color(244, 245, 155), new Color(170, 185, 231), new Color(144, 210, 168)}; //sw, gelb, blau, gn
	
	static Color white = new Color(255, 255, 255);
	static Color yellow = new Color(244, 245, 155);
	static Color blue = new Color(170, 185, 231);
	static Color green = new Color(144, 210, 168);
	static Color[] colors = {white, yellow, blue, green};
	
	
	// Einlagerung
	// String to Boolean
	public static boolean inOrOut(String s) {
		if ( s == "Einlagerung") {
			return true;
		} else {
			return false;
		}
	}
	
	// Boolean to String
	public static String inOrOut(boolean b) {
		if ( b ) {
			return "Einlagerung";
		} else {
			return "Auslagerung";
		}
	}
	
	// Material
	// String to Int
	public static Integer material(String s) {
		switch(s) {
	    	case "Stein": return (Integer) 0;
	    	case "Holz": return (Integer) 1;
	    	case "Papier": return (Integer) 2;
	    	default: return (Integer) 255;
	    }
	}

	// int to String
	public static String material(Integer i) {
		switch((int) i) {
    	case 0: return "Stein";
    	case 1: return "Holz";
    	case 2: return "Papier";
    	default: return "Missingno";
    	}
	}
	
	// Auftrag angenommen/abgelehnt oder Palette entsorgt/nicht entsorgt
	public static String RejectToStr(int i) {
		switch (i) {
		case 1: return "Angenommen";
		case 2: return "Abgelehnt";
		case 3: return "Verschrottet";
		default: return "Fehler";
		}
	}

	// Give Font type (not implemented)
	public static Color giveColor(int i) {
		switch (i) {
		case -1: return colors[0];
		case 0: return colors[1];
		case 1: return colors[2];
		case 2: return colors[3];
		default: return colors[0];
		}
	}
	
	public static Product createProduct(String[] orderLine) {
		Product p = null;
		switch( Helper.material( orderLine[2] ) ) {
		case 0: p = new Stone( orderLine[0], orderLine[1], orderLine[2], orderLine[5], orderLine[4], orderLine[3] ); return p;
		case 1: p = new Wood( orderLine[0], orderLine[1], orderLine[2], orderLine[5], orderLine[4], orderLine[3] ); return p;
		case 2: p = new Paper( orderLine[0], orderLine[1], orderLine[2], orderLine[5], orderLine[3], orderLine[4] ); return p;
		default: p = new Missingno( orderLine[0], orderLine[1], orderLine[2], orderLine[3], orderLine[4], orderLine[5] ); return p;}
	}
	
	
}
