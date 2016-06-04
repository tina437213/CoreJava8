package edu.dtorres.corejava8.cp3.ex05;

/**
 * Implement a static of method of the IntSequence class that yields a sequence
 * with the arguments. For example, IntSequence.of(3,1,4,1,5,9) yields a
 * sequence with six values. Extra credit if you return an instance of an
 * anonymous inner class.
 * 
 * @author diego
 *
 */
public class Program {
	public static void main(String[] args) {
		System.out.println("SEQUENCE EXERCISE BEGIN.");
		IntSequence seq = IntSequence.of(3,1,4,1,5,9);
		while(seq.hasNext()){
			System.out.printf("got sequence %d \n", seq.next());
		}
		System.out.println("SEQUENCE EXERCISE END.");
	}
}
