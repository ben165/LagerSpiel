package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BalanceGui implements ActionListener{

	JFrame frame = new JFrame();
	Font font = new Font(Font.MONOSPACED, Font.PLAIN, 14);

	JTextArea balanceArea = new JTextArea();
	JButton nextPage = new JButton("-->");
	JButton lastPage = new JButton("<--");
	JButton reload = new JButton("Reload");
	
	public BalanceGui() {
	
		frame = new JFrame("Lager Bilanz");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(450, 600);
		frame.setLayout(null);
		
		// Area
		balanceArea.setBounds(0, 0, 450, 500);
		balanceArea.setEditable(false);
		balanceArea.setFont(font);
		frame.add(balanceArea);
		
		//first page
		balanceArea.setText( LagerGui.balanceList.getList() );
		
		reload.addActionListener(this);
		reload.setFocusable(false);
		reload.setBounds(0, 500, 100, 25);
		frame.add( reload );
		
		lastPage.addActionListener(this);
		lastPage.setFocusable(false);
		lastPage.setBounds(100, 500, 100, 25);
		frame.add( lastPage );
		
		nextPage.addActionListener(this);
		nextPage.setFocusable(false);
		nextPage.setBounds(200, 500, 100, 25);
		frame.add( nextPage );
		
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		
		if (s == "-->") {
			LagerGui.balanceList.setPage( LagerGui.balanceList.getPage()+1 );
			balanceArea.setText(null);
			balanceArea.setText( LagerGui.balanceList.getList() );
		} else if (s == "<--") {
			LagerGui.balanceList.setPage( LagerGui.balanceList.getPage()-1 );
			balanceArea.setText(null);
			balanceArea.setText( LagerGui.balanceList.getList() );
		} else {
			balanceArea.setText(null);
			balanceArea.setText( LagerGui.balanceList.getList() );
		}
		
	}
	
}
