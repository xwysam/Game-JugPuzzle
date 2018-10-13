package ca.utoronto.utm.jugpuzzle;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import ca.utoronto.utm.jugpuzzle.Jug;

/**
 * A Jug Puzzle consists of three Jugs (numbered 0,1 and 2) with capacities 8,5
 * and 3 respectively. Initially, jug 0 is full, the other two are empty. The
 * player of the game spills liquid between the jugs (move) until both jugs 0
 * and 1 contain 4 units of liquid each. When a player makes a move, one Jug spills into
 * another. The JugPuzzle knows how many moves have taken place since the start
 * of the game. A spill ends as soon as one jug is empty or one jug is filled.
 * 
 * @author csc207student
 */

public class JugPuzzle extends Observable {
	private Jug[] jugs;
	private int moves;
	private ArrayList<Integer> list;

	/**
	 * Create a new JugPuzzle with three jugs, capacities 8,5,3
	 * and initial amounts 8,0,0. The goal is to achieve amounts
	 * 4,4,0. Initially the number of moves is 0.
	 */
	public JugPuzzle() {
		this.jugs = new Jug[3];
		this.jugs[0] = new Jug(8, 8);
		this.jugs[1] = new Jug(5);
		this.jugs[2] = new Jug(3);
		this.moves = 0;
		this.list = new ArrayList<Integer>();
	}

	/**
	 * 
	 * @return the number of moves since the start of the game
	 */
	public int getMoves() {
		return moves;
	}
	
	/**
	 * @return return the ArrayList.
	 */
	public  ArrayList<Integer> getList(){
		return list;
	}
	
	/**
	 * Add the number to the list.
	 * @param n is the number of each jug.
	 */
	public void setList(int n){
		list.add(n);
	}
	
	/**
	 * To make the list empty.
	 */
	public void setListEmpty() {
		list.clear();
	}

	/**
	 * 
	 * @return whether this is solved, that is 4 units in jugs 0 and 1 each.
	 */
	public boolean getIsPuzzleSolved() {
		return jugs[0].getAmount() == 4 && jugs[1].getAmount() == 4;
	}

	/**
	 * Make a single move of the JugPuzzle, that is spill Jug 'from' into Jug 'to'.
	 * This counts as a single move.
	 * 
	 * @param from an integer identifying a jug
	 * @param to an integer identifying a jug
	 */
	public void move(int from, int to) {
		if(0<=from && from<jugs.length && 0<=to && to<jugs.length){
			jugs[from].spillInto(jugs[to]);
			moves++;
		}
		this.setChanged();      //Check it changed or not.
		this.notifyObservers(); //If its changed tell the View to update.
	}
	
	/**
	 * To make the Jugs reset to the initial.
	 */
	public void reSet() {
		this.jugs[0].setAmount(8);;
		this.jugs[1].setAmount(0);
		this.jugs[2].setAmount(0);
		this.moves = 0;
		this.setChanged();      //Check it changed or not.
		this.notifyObservers(); //If its changed tell the View to update.
	}
	
	/**
	 * @return the whole jugs we have.
	 */
	public Jug[] getJug() {
		return jugs;
	}

	/**
	 * @return a string representation of this
	 */
	public String toString() {
		return moves + " " + " 0:" + jugs[0] + " 1:" + jugs[1] + " 2:" + jugs[2];
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		super.addObserver(o);
		this.setChanged();
		this.notifyObservers();
	}
}