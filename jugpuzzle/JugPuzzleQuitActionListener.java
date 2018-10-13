package ca.utoronto.utm.jugpuzzle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JugPuzzleQuitActionListener implements ActionListener{
	JFrame frame;
	JButton quitgame;

	public JugPuzzleQuitActionListener(JFrame frame, JButton quitgame) {
		this.frame = frame;
		this.quitgame = quitgame;
	}
	public void actionPerformed(ActionEvent e) {
		this.frame.dispose();
	}
	

}
