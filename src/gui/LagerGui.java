package gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import orders.*;
import product.*;

public class LagerGui implements ActionListener {

	// Margin
	final int TOP = 10;
	final int LEFT = 10;
	
	// Class Inits
	public static OrderList orderList = new OrderList();
	public static Orders orders = new Orders();
	public static Storage shelf = new Storage();
	public static BalanceList balanceList = new BalanceList();
	public static Font font;
	
	JFrame frame;
	
	// Left site GUI
	StorageUnit[][] unit = new StorageUnit[4][4];
	
	// Right site GUI
	public static ContractUnit[] contractUnit = new ContractUnit[3];
	JButton getContract;
	
	JLabel balanceLabel;
	public static JTextField balanceField;
	
	JButton balanceInfo;
	
	JLabel errorLabel;
	public static JTextField errorField;
	
	public LagerGui() {
		frame = new JFrame("Lager Software");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1440, 900);
		frame.setLayout(null);
		
		// Left Site
		// Drawing Storage Units (shelf)
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				unit[i][j] = new StorageUnit(3-i, j, LEFT + 170*j, TOP + 200*i, frame);
			}
		}
		
		// Right site
		// Drawing Contract Units
		for (int i=0; i<3; i++) {
			contractUnit[i] = new ContractUnit(i, LEFT+720+180*i, TOP, frame);
		}
		
		getContract = new JButton("Neuer Auftrag");
		getContract.addActionListener(this);
		getContract.setFocusable(false);
		getContract.setBounds(720 + LEFT, TOP+225, 150, 50);
		frame.add(getContract);
		
		// balance field		
		balanceLabel = new JLabel();
		balanceLabel.setText("Bilanz:");
		balanceLabel.setBounds(LEFT + 720, TOP + 200*2, 100, 25);
		frame.add(balanceLabel);
		
		balanceField = new JTextField();
		balanceField.setBounds(LEFT + 720, TOP + 200*2 + 25, 400, 25);
		balanceField.setEditable(false);
		frame.add(balanceField);
		
		balanceInfo = new JButton("Bilanz aufrufen");
		balanceInfo.addActionListener(this);
		balanceInfo.setFocusable(false);
		balanceInfo.setBounds(LEFT + 720, TOP + 200*2 + 60, 150, 50);
		frame.add(balanceInfo);
		
		// info / error field
		// label
		errorLabel = new JLabel();
		errorLabel.setText("Info:");
		errorLabel.setBounds(LEFT + 720, TOP + 200*3, 100, 25);
		frame.add(errorLabel);

		// Error Field text field
		errorField = new JTextField();
		errorField.setBounds(LEFT + 720, TOP + 200*3 + 25, 400, 25);
		errorField.setEditable(false);
		frame.add(errorField);
				
		frame.setVisible(true);
	}

		
	public static void main(String[] args) {		
		new LagerGui();
			}
	
	public static void test() {
		System.out.println("Test 2");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		if ( s == "Neuer Auftrag") {			
			if ( orders.hasNext() ) {
				String[] orderLine = orders.getNextOrder();
				Product p = Helper.createProduct(orderLine);
					
				try {
					int nr = orderList.accept(p);
					
					contractUnit[nr].setText(p.info());

					// Check for matching in shelf only
					// Kleine Hilfe weil ich ohne Farben 
					// und Bilder gearbeitet habe.
					errorField.setText(shelf.findMatch(p));
					
				} catch (Exception ex) {
					orders.decrementOrder();
					errorField.setText(ex.getMessage());
				}
					
				}
			else {
				errorField.setText("Auftragliste leer (Spiel beendet).");
			}
		} 
		
		if (s == "Bilanz aufrufen") {
			new BalanceGui();			
		}
		
	}

}
