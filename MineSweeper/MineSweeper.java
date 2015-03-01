// ITI1120 (Fall 2013), Assignment 4

// This program starts the game of MineSweeper in a field of a given size
// and a given number of mines.

import java.io.* ;

class MineSweeper
{
  public static void main (String[] args)
  { 
    // DÉCLARATIONS DES VARIABLES ET DICTIONNAIRE DE DONNÉES 
    int length;       // GIVEN: length of the field (number of rows)
    int width;        // GIVEN: width of the field (number of column)
    int numberMines;  // GIVEN: number of mines in the field
    int maxSize = 20; // INTERMEDIATE: maximum length and witdh.
    
    // PRINT IDENTIFICATION INFO
    System.out.println();
    System.out.println("ITI1120, Assignment 4");
    System.out.println("MineSweeper Game!");
    System.out.println("----------------");
    System.out.println();
    
    // READING INPUT
    // Valides the given data.
    length = validInteger("the length of the field", 1, maxSize);
    width = validInteger("the width of the field", 1, maxSize);
    // Use length and width to determine the upper limit.
    numberMines = validInteger("the number of mines", 1, length * width);

    // BODY OF THE ALGORITHM
    System.out.println("Super! We can start...") ;    
    new MineSweeperGUI ( length, width, numberMines ) ;    
    
    // DISPLAYS RESULTS
  }

  // DEFINITIONS OF METHODS INVOKED BY "MAIN".
  
  // Method valideInteger: returns an integer between min and max, inclusively
  // GIVENS: message: Message to didplay to the user
  //         min: acceptable lower limit
  //         max: acceptable upper limit
  // ASSUMPTION: min < max (no need to verify)
  private static int validInteger(String message, int min, int max)
  {
    // DECLARATIONS OF INTERMEDIATES AND RESULTS 
    int result; // validated RESULT

    // ’ALGORITH BODY.
    System.out.print("Please enter " + message);
    System.out.print (" (between " + min + " and " + max + ") :");
    result = ITI1120.readInt();
    
    while ( (result < min) || (result > max) )
    {
      System.out.println ("Invalid value...");
      System.out.print("Please enter " + message);
      System.out.print (" (between " + min + " and " + max + ") :");
      result = ITI1120.readInt();
    }
    
    // RETURNED RESULT
    return result;
  }
  
} // end of the class
