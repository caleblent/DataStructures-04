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
	public boolean equals(Object otherObject) throws NullPointerException {
		// Check that otherObject is a Table object
		if (otherObject == null)
			return false;
		if (!(otherObject instanceof Table))
			return false;
		if (otherObject == this)
			return true;
		
		// Cast it as a Table object
		Table otherTable = (Table) otherObject;
		
		// Check the tables' row dimensions
		if (this.values.length != otherTable.values.length) {
			return false;
		}
		
		// Go through and compare each of the tables' values
		for (int i = 0; i < this.values.length; i++) {
			// Check column dimensions in each row
			if (this.values[i].length != otherTable.values[i].length) {
				return false;
			}
			// Check the individual column values within each row
			for (int j = 0; j < this.values[i].length; j++) {
				if (this.values[i][j] != otherTable.values[i][j])
					return false;
			}
		}
		
		// In the event it has passed every previous check, return true
		return true;
	}
	
	/**
	 * @return the smallest value stored in this table
	 * @throws IllegalStateException if zero dimension(s)
	 */
	public int smallestValue() throws IllegalStateException{
		// Checks to see if array has 0 dimensions
		if (this.values == null || this.values.length == 0 || this.values[0].length == 0)
			throw new IllegalStateException("Array has 0 dimensions");
		
		// Declare local variable to compare to the values in the table
		int smallestNum = this.values[0][0];
		
		// Search through table, if value is smaller than the current smallest,
		// set the smallest to that value instead
		for (int i = 0; i < this.values.length; i++) {
			for (int j = 0; j < this.values[i].length; j++) {
				if (smallestNum > this.values[i][j])
					smallestNum = this.values[i][j];
			}
		}
		
		// Return the smallest value found
		return smallestNum;
	}
	
	/**
	 * Alter the value at the specified coordinates
	 * @param number the new value to store at that location
	 * @param row the row where you want to make the change
	 * @param col the column where you want to make the change
	 * @throws IllegalArgumentException if coordinates are not a valid location
	 */
	public void setValueAt(int number, int row, int col) throws IllegalArgumentException {
		// Check to see if array is a 0 array
		if (this.values == null || this.values.length == 0 || this.values[0].length == 0)
			throw new IllegalStateException("Array has 0 dimensions");
		
		// Check to see if row exists
		if (row >= this.values.length || row < 0) 
			throw new IllegalArgumentException("Row given does not exist.");
		
		// Check to see if column in that row exists
		if (col >= this.values[row].length || col < 0) 
			throw new IllegalArgumentException("Column given for that row does not exist.");
		
		// Set the value at the coordinates listed
		this.values[row][col] = number;
	}
	
	/**
	 * Helper method for visualizing the data we're working with
	 */
	public void print() {
		// Check to see if array is a 0 array
		if (this.values == null || this.values.length == 0 || this.values[0].length == 0)
			throw new IllegalStateException("Array has 0 dimensions");
		
		// Prints the array's contents in a JSON-like format
		for (int i = 0; i < this.values.length; i++) {
			System.out.print("{ ");
			for (int j = 0; j < this.values[i].length; j++) {
				System.out.print(this.values[i][j]);
				if (j != this.values[i].length-1) 
					System.out.print(", ");
			}
			System.out.print(" }");
			if (i != this.values.length-1) 
				System.out.print(",");
			System.out.print("\n");
		}
		System.out.print("\n");
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