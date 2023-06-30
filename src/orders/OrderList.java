package orders;
import product.Product;

public class OrderList{

	private Product[] orderList = new Product[3];
	private int emptySlot = 0;
	
	
	public boolean hasSpace() {
		for (int i=0; i<3; i++) { 
			if (orderList[i] == null) {
				emptySlot = i;
				return true;
			}
		}
		return false;
	}


	public int accept( Product p ) throws Exception {
		
		if ( !hasSpace() ) {
			throw new Exception("Auftragsliste voll.");
		} else {
			orderList[emptySlot] = p;
			return emptySlot;
		}
		
	}
	
	public void delete(int nr){
			orderList[nr] = null;
	}
	
	
	public Product get(int nr) throws Exception {
		if (orderList[nr] == null) {
			throw new Exception("Ablage nicht gefuellt.");
		} else {
			Product p = orderList[nr];
			return p;
		}
	}
	
	public void print() {
		for (int i=0; i<orderList.length; i++) {
			Product p = orderList[i];
			
			if (p != null) {
				System.out.println( i + ": " + p.toString() );
			} else {
				System.out.println( i + ": " + "empty" );
			}
			
		}
	}
	
	public int getEmptySlot() {
		// isEmpty() need to be run before
		// function is not so important
		return emptySlot;
	}
	
	
	public boolean isEmpty(int slot) {
		if (orderList[slot] == null) {
			return true;
		}
		return false;
	}
	
	
	
}
