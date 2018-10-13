package ca.utoronto.utm.jugpuzzle;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JugPuzzleGUIController {
	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	protected static void createAndShowGUI() {
		// Create and hook up the Model, View and the controller
		
		JFrame frame = new JFrame("JugPuzzle"); // Frame with title
		frame.setSize(350, 250); // Set the frame size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setVisible(true);
		
		
		
		// Model
		JugPuzzle jugPuzzle = new JugPuzzle();
		panel.setLayout(null);
		
		// Create the buttons
		JButton b1, b2, b3,newgame ,quitgame;
		b1 = new JButton("8");
		b2 = new JButton("5");
		b3 = new JButton("3");
		newgame = new JButton("New Game");
		quitgame = new JButton("EXIT");
		
		//Create the view
		GUIview guiView1 = new GUIview();
		GUIview guiMoveView = (GUIview) new MoveView();
		//Create the label
		JLabel sucess = new JLabel();
		
		//Set the button size
		b1.setBounds(10, 80, 80, 25); 
		b2.setBounds(90, 80, 80, 25);
		b3.setBounds(170, 80, 80, 25);
		newgame.setBounds(50,200, 120, 25);
		quitgame.setBounds(160, 200, 120, 25);
		//Set the view size
		guiView1.setBounds(30, 20, 1000, 25);
		guiMoveView.setBounds(100, 50, 1000, 150);
		//Set the label size
		sucess.setBounds(30, 100, 300, 100);

		//Add them to the contentPane
		panel.add(b1); 
		panel.add(b2);
		panel.add(b3);
		panel.add(newgame);
		panel.add(quitgame);
		panel.add(guiView1);
		panel.add(guiMoveView);
		panel.add(sucess);

		//Hook the model to the view.
		jugPuzzle.addObserver(guiView1);
		jugPuzzle.addObserver(guiMoveView);
		
		//Make the action listener for the buttons.
		JugPuzzleActionListener mb1 = new JugPuzzleActionListener(frame,jugPuzzle,b1,b2,b3,sucess);
		JugPuzzleActionListener mb2 = new JugPuzzleActionListener(frame,jugPuzzle,b1,b2,b3,sucess);
		JugPuzzleActionListener mb3 = new JugPuzzleActionListener(frame,jugPuzzle,b1,b2,b3,sucess);
		JugPuzzleReSetActionListener n = new JugPuzzleReSetActionListener(jugPuzzle,newgame,b1,b2,b3,sucess);
		JugPuzzleQuitActionListener quit = new JugPuzzleQuitActionListener(frame,quitgame);
		
		// Tell the buttons who they should call when they are pressed
		b1.addActionListener(mb1);
		b2.addActionListener(mb2);
		b3.addActionListener(mb3);
		quitgame.addActionListener(quit);
		newgame.addActionListener(n);

		// Let the model tell the views to update
		jugPuzzle.notifyObservers();

	}
}
