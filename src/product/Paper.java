package product;

public class Paper extends Product{
	private String color; // Weiss, Blau, Gruen
	private String size; // A3, A4, A5
	
	public Paper() {};
	
	public Paper(String id, String in, String material, String price, String color, String size) {
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
		return 3;
	}

	
	public String details() {
		return "Papier" + "\n" + color + "\n" + size + "\n";
	}
	
	public Product copy() {
		Product temp = new Paper();
		temp.id = this.id;
		temp.material = this.material;
		temp.price = this.price;
		temp.in = this.in;
		temp.reject = this.reject;
		temp.key = this.key;
		return temp;
	}
	
}
