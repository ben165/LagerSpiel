package orders;

import java.util.LinkedList;
import java.util.List;

import product.Helper;
import product.Product;

public class BalanceList{

	List<Product> balanceList = new LinkedList<>();
	
	final int ENTRIES = 19;
	Double costs = 0.0; // costs only negative numbers
	Double sales = 0.0; // only positive numbers (Umsatz)
	Double balance = 0.0; // summation of sales
	int page = 0; //pagesite
	
	public Double updateBalance() {
		return 0.0;
	}
	
	
	public boolean settle(Product p, Product order) {
		return false;
	}
	
	public void insert(Product p) {
		balanceList.add(p);
		sales += p.getPrice();
		balance += p.getPrice();
	}

	public void rejectContract(Product p) {
		p.setReject(2);
		costs += p.getPrice();
		p.setPrice( p.getPrice() * (-1) );
		balanceList.add(p);
		balance += p.getPrice();
	}

	public void scrappedStorage(Product p) {
		costs += 300.0;

		Product pcopy = p.copy();
		
		pcopy.setReject(3);
		pcopy.setPrice(-300.0);
		balanceList.add(pcopy);
		balance += pcopy.getPrice();
	}


	public String getList() {
		String s = new String();
		s += "Seite:     " + (page+1) + "\n";
		s += "Umsatz:    " + sales.toString() + "\n";
		s += "Ausgaben:  " + costs.toString() + "\n";
		s += "Bilanz:    " + balance.toString() + "\n\n";
		
		for (int i = 0 + ENTRIES*page; (i < balanceList.size() && i < ENTRIES*(page+1) ); i++) {
			s += balanceList.get(i).getId() + "  ";
			s += Helper.material( balanceList.get(i).getMaterial() ) + "  ";
			s += Helper.inOrOut( balanceList.get(i).isIn() ) + "  ";
			s += Helper.RejectToStr(balanceList.get(i).getReject()) + "  ";
			s += balanceList.get(i).getPrice() + "\n";
		}
		
		
		return s;
	}
	
	public Double getCosts() {
		return costs;
	}


	public void setCosts(Double costs) {
		this.costs = costs;
	}


	public Double getSales() {
		return sales;
	}


	public void setSales(Double sales) {
		this.sales = sales;
	}


	public String getBalance() {
		return balance.toString();
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		//System.out.println("Page" + page );
		//System.out.println( page * ENTRIES - balanceList.size() );
		if ( page < 0 ) {
			page = 0; }
		else if ( ((page+1) * ENTRIES - balanceList.size()) >= ENTRIES ) {
			return; }
		else {
			this.page = page; }
	}
	
	
	
}
