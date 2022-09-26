package aPackage;

import java.util.Random;

/**
 * Reviewing working with Arrays
 * @author gosnat/albing
 * @author Caleb Lent (github.com/caleblent)
 * @version Fall 2021
 *
 */
public class Table {
	
	/** The actual 2D array of values */
	private int[][] values;
	
	/**
	 * Fill this in to determine whether this object is equivalent to the
	 * object being passed in as a paramter
	 * Rules:
	 * 1) If otherObject isn't even a Table object, not equal
	 * 2) If this Table and the other table have different dimensions, not equal
	 * 3) If this Table and the other Table have different values, not equal
	 */
	@Override
	public boolean equals(Object otherObject) {
		//TODO delete the return statement below and implement this method
		return false;
	}
	
	/**
	 * @return the smallest value stored in this table
	 * @throws IllegalStateException if zero dimension(s)
	 */
	public int smallestValue() throws IllegalStateException{
		//TODO delete return statement below and implement this method
		return Integer.MIN_VALUE;
	}
	
	/**
	 * Alter the value at the specified coordinates
	 * @param number the new value to store at that location
	 * @param row the row where you want to make the change
	 * @param col the column where you want to make the change
	 * @throws IllegalArgumentException if coordinates are not a valid location
	 */
	public void setValueAt(int number, int row, int col) throws IllegalArgumentException {
		//TODO implement this method
		
	}
	
	/**
	 * A constructor that populates array based on "random" number seed
	 * @param rows the row count of the 2D array
	 * @param cols the column count of the 2D array
	 * @param seed the seed value for the psuedo-random number generator
	 * 		(ensures we get the same set of values each time)
	 */
	public Table(int rows, int cols, int seed) {
		Random rGen = new Random(seed);
		values = new int[rows][cols];
		for(int r = 0; r < rows; r++) {
			for(int c = 0; c < cols; c++) {
				values[r][c] = rGen.nextInt(101) - 50; //random value between -50 and 50
			}
		}
	}
	
	/**
	 * A second (overloaded) constructor where all values are manually supplied
	 * @param data
	 */
	public Table(int[][] data) {
		values = data.clone(); //Should result in deep copy for Java primitive arrays
	}

} // class Table