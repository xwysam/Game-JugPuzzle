package ca.utoronto.utm.jugpuzzle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ca.utoronto.utm.jugpuzzle.JugPuzzle;

public class JugPuzzleActionListener implements ActionListener{
	JFrame frame;
	JButton b1;
	JButton b2;
	JButton b3;
	JLabel sucess;
	int from;
	int to;
	int tamp;
	JugPuzzle jugPuzzle;
	
	public JugPuzzleActionListener(JFrame frame, JugPuzzle jugPuzzle, JButton b1, JButton b2, JButton b3, JLabel sucess) {
		this.frame = frame;
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
		this.sucess = sucess;
		this.jugPuzzle = jugPuzzle;
	}
		

	public void actionPerformed(ActionEvent e) {
		//Let us know which button are we pressed.
		if(e.getSource() == b1) {
			this.tamp = 0;
		}else if(e.getSource() == b2) {
			this.tamp = 1;
		}else if(e.getSource() == b3){
			this.tamp = 2;
		}
		jugPuzzle.setList(tamp);
		//Get the index which jug to which. And move one to the another.
		if(jugPuzzle.getList().size() == 2) {
			jugPuzzle.move(jugPuzzle.getList().get(0), jugPuzzle.getList().get(1));
			if(jugPuzzle.getIsPuzzleSolved()) {
				this.b1.setEnabled(false); //disable the button.
				this.b2.setEnabled(false);
				this.b3.setEnabled(false);
				sucess.setText("Congrats you solved it in " + jugPuzzle.getMoves() + " moves!!"); //show up the wining message.
			}
		}else if(jugPuzzle.getList().size() > 2) { //reset the counting list.
			jugPuzzle.setListEmpty(); 
			jugPuzzle.setList(tamp);
			
		}
	}
}
