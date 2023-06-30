package product;

public class Missingno extends Product{
	
	// To catch one start to ask the guy in Vertania City...
	
	private String color; // Weiss, Blau, Gruen
	private String size; // A3, A4, A5
	
	public Missingno() {};
	
	public Missingno(String id, String in, String material, String price, String color, String size) {
		super(id, in, material, price);
		this.color = new String(color);
		this.size = new String(size);
		
		this.key = Helper.material(material).toString() + color + size;
	}

	
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	
	public int maxHigh() {
		// This item is not know therefore it will never be in the storage.
		return 4;
	}
	
	public String details() {
		return "";
	}
	
	public Product copy() {
		Product temp = new Missingno();
		temp.id = this.id;
		temp.material = this.material;
		temp.price = this.price;
		temp.in = this.in;
		temp.reject = this.reject;
		temp.key = this.key;
		return temp;
	}
	
}
