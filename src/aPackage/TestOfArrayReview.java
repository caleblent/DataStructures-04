package aPackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * JUnit tests for Array Review Project 4
 * @author gosnat
 * @version Spring 2021
 *
 */
class TestOfArrayReview {

	@Test
	void testEquals() {
		Table t1 = new Table(5, 6, 42);
		Table t2 = new Table(5, 6, 42);
		assertEquals(t1, t2);
		int[][] data = {{-35, 9, -46, 39, -39, 6}, {-47, -26, 25, -20, 38, 25}, {-15, -35, 12, 2, 5, -4}, {-32, -28, 6, 45, 12, 46}, {28, 12, 13, -33, -22, 24}};
		Table t3 = new Table(data);
		assertEquals(t1, t3);
	}
	
	@Test
	void testEquals2() {
		Table t1 = new Table(7, 6, 56);
		Table t2 = new Table(new int[][]{{43, 1, 12, -26, 15, -14}, {34, -26, 23, 23, 42, -47}, {-32, -50, -15, 31, 41, 39}, {-12, 39, 38, 9, 2, -35}, {-20, 45, -5, -38, 9, -15}, {-25, 27, 19, -27, -43, -19}, {-8, 34, -29, 34, -41, -14}});
		assertEquals(t1, t2);
	}
	
	@Test
	void testEqualsZeroDimmension() {
		Table t1 = new Table(0, 0, 1);
		Table t2 = new Table(0, 0, 2);
		assertEquals(t1, t2);
		Table t3 = new Table(2, 0, 1);
		Table t4 = new Table(2, 0, 3);
		assertEquals(t3, t4);
		Table t5 = new Table(0, 3, 1);
		Table t6 = new Table(0, 3, 3);
		assertEquals(t5, t6);
	}
	
	@Test 
	void testNotEqualsZeroDimmension(){
		Table t1 = new Table(5, 6, 1);
		Table t2 = new Table(0, 0, 2);
		assertNotEquals(t1, t2);
		assertNotEquals(t2,t1);
		Table t3 = new Table(2, 0, 1);
		Table t4 = new Table(3, 0, 3);
		assertNotEquals(t1, t3);
		assertNotEquals(t3, t1);
		assertNotEquals(t3, t4);
		Table t5 = new Table(0, 3, 1);
		assertNotEquals(t1, t5);
		assertNotEquals(t5, t1);
	}
	
	@Test
	void testNotEqualsDiffRowCount() {
		Table t1 = new Table(5, 6, 42);
		Table t2 = new Table(7, 6, 56);
		assertNotEquals(t1, t2); //different dimensions
		assertNotEquals(t2, t1);
	}
	
	@Test
	void testNotEqualsDiffValues() {
		Table t1 = new Table(5, 6, 42);
		Table t2 = new Table(5, 6, 56);
		assertNotEquals(t1, t2); //same dimensions, different values
		assertNotEquals(t2, t1);
	}
	
	@Test
	void testNotEqualsDiffDimSimilarValues() {
		Table t1 = new Table(5, 6, 42);
		Table t2 = new Table(new int[][]{{-35, 9, -46, 39, -39, 6}, {-47, -26, 25, -20, 38, 25}, {-15, -35, 12, 2, 5, -4}, {-32, -28, 6, 45, 12, 46}});
		assertNotEquals(t1,t2); //different dimensions but similar values
		assertNotEquals(t2,t1);
	}
	
	@Test
	void testNotEqualsOtherType() {
		Table t1 = new Table(5, 6, 34);
		assertNotEquals(t1, "I'm not even a Table!");
		assertNotEquals("I'm not even a Table!", t1);
		
	}
	
	@Test
	void testNotEqualsDiffColumnCount() {
		Table t1 = new Table(5, 6, 42);
		Table t2 = new Table(5, 7, 42);
		assertNotEquals(t1, t2); //same rows, different columns
		assertNotEquals(t2, t1);
	}
	
	@Test
	void testSmallestValue() {
		Table t1 = new Table(new int[][]{{43, 1, 12, -26, 15, -14}, {34, -26, 23, 23, 42, -47}, {-32, -50, -15, 31, 41, 39}, {-12, 39, 38, 9, 2, -35}, {-20, 45, -5, -38, 9, -15}, {-25, 27, 19, -27, -43, -19}, {-8, 34, -29, 34, -41, -14}});
		assertEquals(-50, t1.smallestValue());
	}
	
	@Test
	void testSmallestValue2() {
		Table t1 = new Table(new int[][]{{-35, 9, -46, 39, -39, 6}, {-47, -26, 25, -20, 38, 25}, {-15, -35, 12, 2, 5, -4}, {-32, -28, 6, 45, 12, 46}, {28, 12, 13, -33, -22, 24}});
		assertEquals(-47, t1.smallestValue());
	}
	
	@Test
	void testSmallestValueAllNegative() {
		Table t1 = new Table(new int[][]{{-35, -9, -46, -39, -39, -6}, {-4, -26, -5, -20, -38, -25}, {-15, -35, -12, -2, -5, -4}, {-32, -28, -6, -45, -12, -46}, {-28, -12, -13, -33, -22, -24}});
		assertEquals(-46, t1.smallestValue());
	}
	
	@Test
	void testSmallestValueAllPositive() {
		Table t1 = new Table(new int[][]{{35, 9, 46, 39, 39, 6}, {4, 26, 5, 20, 38, 25}, {15, 35, 12, 2, 5, 4}, {32, 28, 6, 45, 12, 46}, {28, 12, 13, 33, 22, 24}});
		assertEquals(2, t1.smallestValue());
	}

	@Test
	void testSmallestValueAllZero() {
		Table t1 = new Table(new int[][]{{0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0},{0, 0, 0, 0, 0, 0}});
		assertEquals(0, t1.smallestValue());
	}
	
	@Test
	void testSmallestValueLarge() {
		Table t1 = new Table(new int[][]{{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE-1, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}});
		assertEquals(Integer.MAX_VALUE-1, t1.smallestValue());
	}
	
	@Test
	void testSmallestValueIllegal() {
		Table t1 = new Table(0,0,1);
		assertThrows(IllegalStateException.class,
				() -> t1.smallestValue());
		Table t2 = new Table(4,0,1);
		assertThrows(IllegalStateException.class,
				() -> t2.smallestValue());
	}
	
	@Test
	void testSetValueAtIllegal() {
		Table t1 = new Table(5, 6, 52);
		assertThrows(IllegalArgumentException.class,
				() -> t1.setValueAt(1, -1, 2));
		assertThrows(IllegalArgumentException.class,
				() -> t1.setValueAt(1, 1, -1));
		assertThrows(IllegalArgumentException.class,
				() -> t1.setValueAt(1, 5, 2));
		assertThrows(IllegalArgumentException.class,
				() -> t1.setValueAt(1, 1, 6));
	}
	
	@Test
	void testSetValueAt() {
		Table t1 = new Table(new int[][]{{43, 1, 12, -26, 15, -14}, {34, -26, 23, 23, 42, -47}, {-32, -50, -15, 31, 41, 39}, {-12, 39, 38, 9, 2, -35}, {-20, 45, -5, -38, 9, -15}, {-25, 27, 19, -27, -43, -19}, {-8, 34, -29, 34, -41, -14}});
		Table t2 = new Table(new int[][]{{43, 1, 12, -26, 15, -14}, {34, -26, 23, 23, 42, -47}, {-32, -50, -15, 3, 41, 39}, {-12, 39, 38, 9, 2, -35}, {-20, 45, -5, -38, 9, -15}, {-25, 27, 19, -27, -43, -19}, {-8, 34, -29, 34, -41, -14}});
		assertNotEquals(t1,t2);
		t1.setValueAt(3, 2, 3);
		assertEquals(t1,t2);
	}

}