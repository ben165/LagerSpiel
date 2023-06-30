package product;

public abstract class Product {

	protected Integer id; // 1,2,3,...
	protected Integer material; //stone (0), wood (1), paper (2), 
	protected Double price; // 200, 300, 1500...
	protected boolean in; // Einlagerung oder Auslagerung
	protected int reject = 1; // Angenommen(1) Abgelehnt (2) Verschrottet (3)
	protected String key; // Fuer den Vergleich
	
	public Product() {};
	
	public Product(String id, String in, String material, String price) {
		this.id = Integer.parseInt(id);
		this.in = Helper.inOrOut(in);
		this.material = Helper.material(material);
		this.price = Double.parseDouble(price);
	}
	
	// Max high of article (0,1,2,3)?
	public abstract int maxHigh();
	
	public abstract String details();
	
	public abstract Product copy();
		
	// for contract unit
	public String info() {
		return details() + price.toString() + " Euro\n\n" + Helper.inOrOut( isIn() ); //+ key +"\n" 
	}

	// for storage unit
	public String lessInfo() {
		return details() + price.toString() + " Euro\n" +"\n"; //+ key 
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMaterial() {
		return material;
	}

	public void setMaterial(Integer material) {
		this.material = material;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean isIn() {
		return in;
	}

	public void setIn(boolean in) {
		this.in = in;
	}

	public int getReject() {
		return reject;
	}

	public void setReject(int reject) {
		this.reject = reject;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", material=" + material + ", price=" + price + ", in=" + in + ", reject=" + reject
				+ ", key=" + key + "]";
	}
	
}
