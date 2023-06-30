package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import product.Product;

public class ContractUnit implements ActionListener{

	// Contract Number
	int x;
	
	// Screen position
	int posX;
	int posY;
	
	JLabel contractLabel;
	JTextArea contractArea = new JTextArea();
	JButton declineContract = new JButton();
	
	public ContractUnit(int x, int posX, int posY, JFrame frame) {
		this.x = x;
		this.posX = posX;
		this.posY = posY;
	
		contractLabel = new JLabel("Ablage " + (x+1));
		
		// Positioning elements
		// Label
		contractLabel.setBounds(posX, posY, 100, 25);
		frame.add(contractLabel);
		
		// Area
		contractArea.setBounds(posX, posY+25, 120, 100);
		contractArea.setEditable(false);
		frame.add(contractArea);

		// Decline Button
		declineContract = new JButton("Ablehnen");
		declineContract.addActionListener(this);
		declineContract.setFocusable(false);
		declineContract.setBounds(posX, posY+130, 120, 45);
		frame.add( declineContract );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Vertrag ablehnen
		try {
			Product p = LagerGui.orderList.get(x);
			LagerGui.orderList.delete(x);
			LagerGui.balanceList.rejectContract(p);
			LagerGui.contractUnit[x].setText(null);
			LagerGui.balanceField.setText( LagerGui.balanceList.getBalance() );
		} catch (Exception e1) {
			LagerGui.errorField.setText(e1.getMessage());
		}
	}
	
	public void setText(String s) {
		contractArea.setText(null);
		contractArea.setText(s);
	}	
}
