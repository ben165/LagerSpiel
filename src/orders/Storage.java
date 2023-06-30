package orders;

import product.Product;

public class Storage{

	private Product[][] shelf = new Product[4][4];
	
	// 1 = Einlagerung
	// 2 = Einlagerung passt auf Auslagerung
	public int insert(int row, int column, Product p) throws Exception {
		
		if ( p == null ) {
			throw new Exception("Kein Auftrag vorhanden.");
		}
				
		if ( !p.isIn() && shelf[row][column] != null) {
			if ( p.getKey().equals(shelf[row][column].getKey())) {
				return 2;
			} else {
				throw new Exception("Einlagerung passt nicht auf Auslagerung.");
			}
		}
		
		if ( !p.isIn() ) {
			throw new Exception("Eine Auslagerung kann nicht eingelagert werden.");
		}
		
		if ( shelf[row][column] != null ) {
			// Lagerplatz bereits belegt
			throw new Exception("Lagerplatz bereits belegt.");
		}
		
		
		if ( row > p.maxHigh()) {
			throw new Exception("Produkt zu schwer fuer diesen Lagerplatz.");
		}
		

		// 1 = Einlagerung
		shelf[row][column] = p;
		return 1;
	}
	
	// Debug
	public void print() {
		for ( int i=0; i<4; i++ ) {
			for (int j=0; j<4; j++) {
				Product p = shelf[i][j];
				if (p != null) {
					System.out.println( i + j + ":  " + p.toString() );
				}
				else {
					System.out.println( i + "" + j + ":  Empty");
				}
			}
		}
	}
	
	public void destroy(int row, int column) throws Exception {
			shelf[row][column] = null;
	}

	public Product getProduct( int row, int column ) {
		return shelf[row][column];
	}
	
	public void isEmpty(int row, int column) throws Exception {
		if (shelf[row][column] == null) {
			throw new Exception("Lagerplatz ist leer.");
		}
	}
	
	// War nicht gefragt in Aufgabenstellung
	public String findMatch( Product p ) {
		Product pShelf;
		
		// Es handelt sich um eine Einlagerung
		if (p.isIn() == true) {
			return "";
		}
		
		for ( int i=0; i<4; i++ ) {
			for (int j=0; j<4; j++) {
				pShelf = shelf[i][j];
				if (pShelf != null) {
					if (pShelf.getKey().equals(p.getKey())) {
						return "Neuer Vertrag passt auf Lagerplatz " + (i+1) + "" + (j+1);
					}
				}
			}
		}
		return "";
	}
	
}
