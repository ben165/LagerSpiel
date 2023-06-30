package product;

public class Stone extends Product{

	private String type; // Marmor, Granit, Sandstein
	private String weight; // Schwer, Mittel, Leicht
	
	public Stone() {};
	
	public Stone(String id, String in, String material, String price, String weight, String type) {
		super(id, in, material, price);
		this.type = type;
		this.weight = weight;
		
		this.key = Helper.material(material).toString() + type + weight;
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public int maxHigh() {
		if (weight == "Mittel") {
			return 2;
		} else if (weight == "Schwer") {
			return 0;
		} else {
			return 3;
		}
	}	
	
	public String details() {
		return "Stein" + "\n" + type + "\n" + weight + "\n";
	}
	
	public Product copy() {
		Product temp = new Stone();
		temp.id = this.id;
		temp.material = this.material;
		temp.price = this.price;
		temp.in = this.in;
		temp.reject = this.reject;
		temp.key = this.key;
		return temp;
	}
	
}
