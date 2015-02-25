import java.util.Random;

/**
 * An instance of the class RandomPermutation is used to create a randomly 
 * generated permutation. The permutation consists of the numbers 0 to (row * columns - 1)
 * in random order, with the property that the 0 must always be the last element of the
 * permutation. In this application, 0 is the type of the empty cell, at the start of 
 * a new game the empty cell is always at the lower right corner.
 * 
 * @author Anthony Gbegan & Elijah Balogun, University of Ottawa
 */

public class RandomPermutation {
  
  /**
   * Number of rows of the grid.
   */
  
  private int row;
  
  /**
   * Number of columns of the grid.
   */
  
  private int column;
  
  /**
   * Two dimensional array, storring the IDs of the cells and which will
   * be used for the permutation of the order of the cells.
   */
  
  private int[][] permutation;
  
  /**
   * Creates a new RandomPermutation object for wich the newly created permutation
   * is the identity permutation, that is the cells are in the right order and
   * the empty cell is in the lower right corner of the board.
   */
  
  public RandomPermutation(int row, int column) {
    this.row = row;
    this.column = column;
    permutation = new int[row][column];
    int number = 1;
    for (int y = 0; y < row; y++) {
      for (int x = 0; x < column; x++) {
        permutation[y][x] = number;
        number++;
      }
    }
    permutation[row - 1][column - 1] = 0;
  }
  
  /**
   * Returns this permutation in an array, where the elements of the first 
   * row comes first, followed by the elements of the second row, etc.
   */
  
  public int[] toArray() {
    int[] pArray = new int[row * column];
    int index = 0;
    for (int y = 0; y < row; y++) {
      for (int x = 0; x < column; x++) {
        pArray[index] = permutation[y][x];
        index++;
      }
    }
    return pArray;
  }
  
 /** Simply generates a new permutation by randomly selecting two positions and
   * swaping the values of theses indexes. The permutation is not guaranteed to 
   * be solvable.
   */
  
  public void shuffle() {
    int[] p = toArray();
    Random random = new Random();
    int randomPosition1;
    int randomPosition2;
    for (int n = 0; n < 30; n++) {
      randomPosition1 = random.nextInt(p.length - 1);
      randomPosition2 = random.nextInt(p.length - 1);
      int temp = p[randomPosition1];
      p[randomPosition1] = p[randomPosition2];
      p[randomPosition2] = temp;
    }
    
    int index = 0;
    for (int y = 0; y < row; y++) {
      for (int x = 0; x < column; x++) {
        this.permutation[y][x] = p[index];
        index++;
      }
    }
  }
  
  /**
   * Returns a String representation of the permutation.
   */
  
  public String toString() {
    String representation = "";
    for (int y = 0; y < row; y++) {
      for (int x = 0; x < column; x++) {
        representation += "[" + this.permutation[y][x] + "]";
        if (x == column - 1 && y != row - 1) {
          representation += "\n";
        }
      }
    }
    return representation;
  }
}