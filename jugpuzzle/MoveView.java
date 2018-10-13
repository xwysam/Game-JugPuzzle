package ca.utoronto.utm.jugpuzzle;

import java.util.Observable;

public class MoveView extends GUIview {
	public void update(Observable o, Object arg) {
		JugPuzzle jugPuzzle = (JugPuzzle)o;
		this.setText("Moves: "+ jugPuzzle.getMoves());
	}

}
