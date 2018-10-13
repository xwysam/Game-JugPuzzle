package ca.utoronto.utm.jugpuzzle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

public class GUIview extends JLabel implements Observer  {
	public void update(Observable o, Object arg) {
		JugPuzzle jugPuzzle = (JugPuzzle)o;
		this.setText("0: " + jugPuzzle.getJug()[0] + "      1:"+ jugPuzzle.getJug()[1]+"      2:"+jugPuzzle.getJug()[2]);	
	}
}

