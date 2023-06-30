package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import product.*;

public class StorageUnit implements ActionListener{

	// Storage Unit Number (Matrix)
	int x;
	int y;
	
	// Screen position
	int posX;
	int posY;
	
	JLabel unitLabel;
	JTextArea unitArea = new JTextArea();
	
	JButton[] compareToContract = new JButton[3];
	JButton deleteProduct = new JButton("X");
	
	public StorageUnit(int x, int y, int posX, int posY, JFrame frame) {
		this.x = x;
		this.y = y;
		this.posX = posX;
		this.posY = posY;
	
		unitLabel = new JLabel("Lagerplatz " + (x+1) + "" + (y+1));
		
		// Positioning elements
		// Label
		unitLabel.setBounds(posX, posY, 100, 25);
		frame.add(unitLabel);
		
		// Area
		unitArea.setBounds(posX, posY+25, 100, 120);
		unitArea.setEditable(false);
		frame.add(unitArea);
		
		// Contract Buttons
		for (int i=0; i<3; i++) {
			compareToContract[i] = new JButton("" + (i+1));
			compareToContract[i].addActionListener(this);
			compareToContract[i].setFocusable(false);
			compareToContract[i].setBounds(posX + 100, posY+25+i*30, 45, 30);
			frame.add( compareToContract[i] );
		}
		
		// Delete Button
		deleteProduct.addActionListener(this);
		deleteProduct.setFocusable(false);
		deleteProduct.setBounds(posX + 100, posY+25+90, 45, 30);
		frame.add( deleteProduct );
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Product p;
		// Palette entsorgen
		if ( e.getActionCommand() == "X" ) {
			try {
				LagerGui.shelf.isEmpty(x, y);
				p = LagerGui.shelf.getProduct(x, y);
				LagerGui.shelf.destroy(x, y);
				unitArea.setText(null);
				LagerGui.balanceList.scrappedStorage(p);
				LagerGui.balanceField.setText( LagerGui.balanceList.getBalance() );
			} catch (Exception e1) {
				LagerGui.errorField.setText( e1.getMessage() );
			}
			
		} else {
		// Button 1, 2 oder 3
		int contractNr = (int) Integer.parseInt(e.getActionCommand()) - 1;
			try {
				p = LagerGui.orderList.get( contractNr );
				
				try {
					int action = LagerGui.shelf.insert(x, y, p);
					
					// Einlagerung
					if (action == 1) {
						LagerGui.balanceList.insert(p);
						unitArea.setText(p.lessInfo());
						LagerGui.contractUnit[contractNr].setText(null);
						LagerGui.orderList.delete(contractNr);
						LagerGui.balanceField.setText( LagerGui.balanceList.getBalance() );
					}
					// Auslagerung passt auf Lagerware
					else {
						LagerGui.balanceList.insert(p);
						unitArea.setText(null);
						LagerGui.shelf.destroy(x, y);
						LagerGui.contractUnit[contractNr].setText(null);
						LagerGui.orderList.delete(contractNr);
						LagerGui.balanceField.setText( LagerGui.balanceList.getBalance() );
					}
				}
				catch (Exception e1) {
					LagerGui.errorField.setText( e1.getMessage() );
				}
				
			} catch (Exception e1) {
				LagerGui.errorField.setText( e1.getMessage() );}

		}
	}
	
}
