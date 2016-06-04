package edu.dtorres.corejava8.cp3.ex05;

/**
 * 
 * Sequences numbers in different implementations.
 * 
 * @author diego
 *
 */
public interface IntSequence {
	/**
	 * 
	 * @return true if sequence has a next value
	 */
	boolean hasNext();

	/**
	 * 
	 * @return next value in sequence
	 */
	int next();
	
	static IntSequence of(int... values){
		return new ArrSequence(values);
	}

	static class ArrSequence implements IntSequence {

		private int[] repo;
		private int arrPos = 0;

		private ArrSequence(int... values) {
			repo = values;
			arrPos = 0;
		}

		@Override
		public boolean hasNext() {
			return arrPos < repo.length;
		}

		@Override
		public int next() {
			return repo[arrPos++];
		}
	}
}
