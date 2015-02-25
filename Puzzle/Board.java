import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JOptionPane; 

/**
 * In the application <b>EightPuzzle<b>, <b>Board</b> is a specialized type of <b>JPanel</b> that
 * holds cells (Tiles). The board also implements the interface <b>ActionListener<b>
 * and holds the higher level logic of the game for moving Tiles.
 * 
 * @author Anthony Gbegan & Elijah Balogun, University of Ottawa
 * 
 */

public class Board extends JPanel implements ActionListener {
  
  /**
   * The total number of rows.
   */
  
  public static final int NUMBER_OF_ROWS = 3;
  
  /**
   * The total number of columns.
   */
  
  public static final int NUMBER_OF_COLUMNS = 3;
  
  /**
   * A two dimensional array to keep references to all the cells of the board.
   */
  
  private Cell[][] board;
  
  /**
   * An integer variable to keep track of the number of moves performed by the user.
   */
  
  private int numberOfMoves;
  
  /**
   * Displays all the Tiles on a two dimensional grid.
   */
  
  public Board() {
    setBackground(Color.WHITE);
    setLayout(new GridLayout(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS));
    setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
    board = new Cell[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
    
    for (int row = 0; row < NUMBER_OF_ROWS; row++) {
      for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
        board[row][column] = new Cell(this, row, column);
        add(board[row][column]);
      }
    }
    this.init();
  }
  
  /**
   * Initialize a new game with mixed tiles order and reset the number of moves to zero.
   */
  
  public void init() {
    this.numberOfMoves = 0;
    RandomPermutation p;
    p = new RandomPermutation(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS);
    p.shuffle();       
    int[] permutationArray = p.toArray();
    int index = 0;
    
    for (int row = 0; row < NUMBER_OF_ROWS; row++) {
      for (int column = 0; column < NUMBER_OF_COLUMNS; column++) {
        board[row][column].setId(permutationArray[index]);
        index++;
      }
    }
  }
  
  /**
   * This method must be implemented as part of the contract specified by
   * ActionListener. This method will be called each time the user clicks a
   * button (Tile). When the user clicks a tile, the method checks if this tile 
   * is adjacent to the empty tile (blank tile). If it is the case, the cliked 
   * tile and the empty tile are swaped. 
   * 
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  
  
  public void actionPerformed(ActionEvent e) {
    
    if (e.getSource() instanceof Cell) {
      Cell src = (Cell) e.getSource();
      int row = src.getRow();
      int column = src.getColumn();
      int id = src.getId();
      
      if (src.getId() != 0) {
        if (row - 1 >= 0 && this.board[row - 1][column].getId() == 0) {
          src.setId(0);
          this.board[row - 1][column].setId(id);
          numberOfMoves++;
        } else if (row + 1 < NUMBER_OF_ROWS && this.board[row + 1][column].getId() == 0) {
          src.setId(0);
          this.board[row + 1][column].setId(id);
          numberOfMoves++;
        } else if (column - 1 >= 0 && this.board[row][column - 1].getId() == 0) {
          src.setId(0);
          this.board[row][column - 1].setId(id);
          numberOfMoves++;
        } else if (column + 1 < NUMBER_OF_COLUMNS && this.board[row][column + 1].getId() == 0) {
          src.setId(0);
          this.board[row][column + 1].setId(id);
          numberOfMoves++;
        }
        
        if (solved()) {
          JOptionPane.showMessageDialog(null, "You solved the Puzzle after " + numberOfMoves + " moves!",
                                        "CONGRATULATIONS!", JOptionPane.INFORMATION_MESSAGE);
          init();
        }
      }
    }
  }
  
  public String toString(){
    String representation = "";
    for (int y = 0; y < NUMBER_OF_ROWS; y++) {
      for (int x = 0; x < NUMBER_OF_COLUMNS; x++) {
        representation += "[" + this.board[y][x].getId() + "]";
        if (x == NUMBER_OF_COLUMNS - 1) {
          representation += "\n";
        }
      }
    }
    representation += "Number of moves is " + this.numberOfMoves;
    return representation;
  }
  
  /**
   * Returns <b>true</b> if and only if all the tiles are in the rigth order and
   * the empty cell is on the lower right corner of the board.
   */
  
  private boolean solved() {
    boolean flag = true;
    int row = NUMBER_OF_ROWS;
    int column = NUMBER_OF_COLUMNS;
    int [][] identity = new int[row][column];
    int number = 1;
    
    for (int y = 0; y < row; y++) {
      for (int x = 0; x < column; x++) {
        identity[y][x] = number;
        number++;
      }
    }
    
    identity[row - 1][column - 1] = 0;
    
    for (int y = 0; y < NUMBER_OF_ROWS && flag; y++) {
      for (int x = 0; x < NUMBER_OF_COLUMNS && flag; x++) {
        if (this.board[y][x].getId() != identity[y][x]) {
          flag = false;
        }
      }
    }
    return flag;
  }
}