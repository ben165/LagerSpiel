package product;

public class Wood extends Product{

	private String type; // Kiefer, Buche, Eiche
	private String shape; // Scheit, Bretter, Balken
	
	public Wood() {};
	
	public Wood(String id, String in, String material, String price, String type, String shape) {
		super(id, in, material, price);
		this.type = type;
		this.shape = shape;
		
		this.key = Helper.material(material).toString() + type + shape;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getShape() {
		return shape;
	}


	public void setShape(String shape) {
		this.shape = shape;
	}


	public int maxHigh() {
		return 3;
	}
	
	public String details() {
		return "Holz" + "\n" + type + "\n" + shape + "\n";
	}
	
	public Product copy() {
		Product temp = new Wood();
		temp.id = this.id;
		temp.material = this.material;
		temp.price = this.price;
		temp.in = this.in;
		temp.reject = this.reject;
		temp.key = this.key;
		return temp;
	}
	
}
