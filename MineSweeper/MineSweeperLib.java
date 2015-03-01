// ITI1120 (Fall 2013), Assignment 4
// Name: Oscar Anthony GEBGAN
// Name: Arash Lari

// Library class to complete.

public class MineSweeperLib
{

 // Q1: COMPLETED  
 // METHOD generateMineField: generates a mine field in the form of a
 //        matrix of boolean values where a cell set as "true" indicates a mine.
 // GIVENS: length and width of the field, and the desired number of mines (numberMines).
 // Hint: Consider using Math.random(), Math.floor()  
 //       and type casting to generate random positions for the mines. 

 public static boolean [][] generateMineField ( int length, int width, int numberMines) 
 {

  // RESULT DECLARATION

  boolean [][] mineField; 
  mineField = new boolean [length][width];

  // INTERMEDIATES DECLARATION

  int currentMines;   // Variable keeping track of the current number of mines put in the mine field
  int x;     // row position of a mine
  int y;     // column position of a mine

  // BODY
  // Generate random positions for the mines and set the values to 'true'
  currentMines = 0;
  while (currentMines < numberMines)
  {
   x = (int) Math.floor(Math.random() * length);
   y = (int) Math.floor(Math.random() * width);

   if (mineField[x][y] != true)
   {
    mineField[x][y]  = true;
    currentMines++;
   }  
  }

  // RETURN THE RESULT

  return (mineField);
 }



 // Q2: TO COMPLETE  
 // METHOD calculateProximity: generate a matrix of integers where each
 //         cell indicates the number of adjacent mines (i.e., those
 //         who touch this cell directly). Use 0 for a
 //         position corresponding to a cell for a mine.
 // GIVENS: a matrix of boolean values representing the mine field.

 // This method should call (multiple times) a helper method that is given the reference 
 // to the mineField matrix and two indexes (one for row and one for column), and checks 
 // if a mine exists at the position given by these indexes. The helper method also tests 
 // if the indexes are valid – if they are not, it returns zero.  
 // If they are valid, the matrix element is tested to return either 0 (the element is false, 
 // i.e., no mine) or 1 (the element is true, i.e., the mine exits at this element). 
 // Hint: Pay attention to the boundaries of the mine field!

 public static int [][] calculateProximity ( boolean [][] mineField ) 
 {
  // DECLARATION OF THE RESULT

  int [][] proximityMatrix;

  // DECLARATION OF VARIABLES

  int row;
  int col;
  int length;
  int width;
  int adjacentMines;

  // BODY

  length = mineField.length;
  width = mineField[0].length;
  proximityMatrix = new int[length][width];
  for (row = 0; row < length; row++)
  {
   for (col = 0; col < width; col++)
   {
    if (mineField[row][col] == true)
    {
     proximityMatrix[row][col] = 0;
    }
    else
    {
     adjacentMines = checkAdjacentMines(mineField, row, col);
     proximityMatrix[row][col] = adjacentMines;  
    } 
   }
  }

  return (proximityMatrix);
 }


 public static int checkAdjacentMines(boolean[][] mineField, int row, int col) 
 {
  /* Description: This method checks the number of mines which are adjacent 
   *              to a given cell.
   * Givens: mineField: matrix of boolean values representing the mine field.
   *               row: the row index of the cell.
   *               col: the column index of the cell.
   */

  // DECLARATION OF RESULT

  int adjacentMines;

  // DECLARATION OF VARIABLES

  int upRow;
  int downRow;
  int leftCol;
  int rightCol;
  int [] adjacentArray = new int[8];

  // BODY

  upRow = row - 1;
  downRow = row + 1;
  leftCol = col - 1;
  rightCol = col + 1;

  adjacentArray[0] = isMine(mineField, upRow, leftCol);
  adjacentArray[1] = isMine(mineField, upRow, col);
  adjacentArray[2] = isMine(mineField, upRow, rightCol);
  adjacentArray[3] = isMine(mineField, row, leftCol);
  adjacentArray[4] = isMine(mineField, row, rightCol);
  adjacentArray[5] = isMine(mineField, downRow, leftCol);
  adjacentArray[6] = isMine(mineField, downRow, col);
  adjacentArray[7] = isMine(mineField, downRow, rightCol);

  adjacentMines = sumArray(adjacentArray, 8);

  return adjacentMines;
 }


 public static int isMine(boolean[][] mineField, int r, int c) 
 {
  /* Description: The method checks the validity (between the boundaries of the mine field) 
   *              of a given cell and returns the value " 1 " if a mine exist at the position
   *              or the value " 0 " if the cell is invalid or if there is not any mine at the
   *              position.
   */

  // BODY

  int l = mineField.length;
  int w = mineField[0].length;

  if (r < 0 || c < 0 || r >= l || c >= w)
  {
   return 0;
  }
  else
  {
   if (mineField[r][c] == true)
   {
    return 1;
   }
   else
   {
    return 0;
   }
  }
 }


 public static int sumArray(int [] array, int n) 
 {
  // Recursive method to sum the values stored in an array
  int sum = 0;
  int i = n-1;

  if (i == 0)
  {
   sum = array[i];
  }
  else
  {
   sum = sumArray(array, n-1) + array[i];
  }

  return sum;
 }




 // Q3: TO COMPLETE  
 // METHOD allFound: determines if all the mines in the field were found.
 // GIVENS: mineField: matrix of boolean values representing the mine field.
 //        tentatives: matrix of booleans representing the guesses of a player
 //                    (true if a position represents a cell already clicked or a 
 //                     potential mine marked with an X in the game). 
 // The method returns true if all the cells non-clicked correspond to real mines.
 // ASSUMPTION: the two matrices have the same size (no need to verify).

 public static boolean allFound ( boolean[][] mineField, boolean[][] tentatives ) 
 {

  boolean found;

  found = compareMatrix(mineField, tentatives, 0, 0);

  return found; 
 }



 public static boolean compareMatrix(boolean[][] matrix1, boolean[][] matrix2, int row, int col) 
 {

  // This method compare two boolean matrices, assuming they have the same size

  boolean found = true;

  if (row < matrix1.length) 
  {
   if (col < matrix1[row].length) 
   {
    if (matrix1[row][col] != matrix2[row][col])
    {
     found = compareMatrix(matrix1, matrix2, row, col+1);
    }
    else
    {
     found = false;
    }
   } 
   else 
   {
    found = compareMatrix(matrix1, matrix2, row+1, 0);
   }
  }

  return found;
 }

}
