package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class JugPuzzleReSetActionListener implements ActionListener {
	JButton newgame;
	JButton b1;
	JButton b2; 
	JButton b3;
	JugPuzzle jugPuzzle;
	JLabel sucess;

	public JugPuzzleReSetActionListener(JugPuzzle jugPuzzle, JButton newgame, JButton b1, JButton b2, JButton b3, JLabel sucess) {
		this.newgame = newgame;
		this.jugPuzzle = jugPuzzle;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.sucess = sucess;
	}
	
	public void actionPerformed(ActionEvent e) {
		this.jugPuzzle.reSet();	 
		this.b1.setEnabled(true);
		this.b2.setEnabled(true);
		this.b3.setEnabled(true);
		sucess.setText("");
		
	}
	

}
