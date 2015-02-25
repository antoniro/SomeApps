import java.util.Random;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 * In the application <b>EightPuzzle</b>, a <b>Cell</b> is a specialized type of
 * <b>JButton</b> that represents a Tile in the game. When the user clicks a tile, 
 * the method checks if this tile is adjacent to the empty tile (blank tile). 
 * If it is the case, the cliked tile and the empty tile are swaped.
 * 
 * @author Anthony Gbegan & Elijah Balogun, University of Ottawa
 */

public class Cell extends JButton {
  
  /**
   * The y coordinate of this cell on the <b>Board</b>.
   */
  
  private int row;
  
  /**
   * The x coordinate of this cell on the <b>Board</b>.
   */
  
  private int column;
  
  /**
   * The id of a cell: This id represents the image that should
   * be used to represent the button.
   */
  
  private int id;
  
  /**
   * The number of tiles in the board.
   * Notice that the empty tile is not considered.
   */
  
  public static final int NUM_TILES = 8;
  
  /**
   * A an array is used to cache all the images. Since the images are not
   * modified. All the cells that display the same image reuse the same
   * <b>ImageIcon</b> object. Notice the use of the keyword <b>static</b>.
   */
  
  private static final ImageIcon[] icons = new ImageIcon[NUM_TILES + 1];
  
  /**
   * Constructor used for initializing a cell (Tile) on the board.
   * 
   * @param board
   *            the grid that holds all the Tiles
   * @param row
   *            the row of this Tile
   * @param column
   *            the column of this Tile
   */
  
  public Cell(Board board, int row, int column) {
    this.row = row;
    this.column = column;
    setBackground(Color.WHITE);
    Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
    setBorder(emptyBorder);
    setBorderPainted(false);
    addActionListener(board);
  }
  
  /**
   * Returns an integer representing the id of this cell.
   */
  
  public int getId() {
    return this.id;
  }
  
  /**
   * Change the id of this Cell to the given id, and update the Icon of the corresponding Tile.
   */
  
  public void setId(int id) {
    this.id = id;
    setIcon(getImageIcon());
  }
  
  /**
   * Determine the image to use based on the cell id. Uses
   * <b>getResource</b> to locate the image file, either on the file system or
   * the .jar file. Implements a caching mechanism.
   * 
   * @return the image to be displayed by the button
   */
  
  private ImageIcon getImageIcon() {
    if (icons[id] == null) {
      String strId = Integer.toString(this.id);
      icons[id] = new ImageIcon("data/img-0" + strId + ".png");
    }
    return icons[id];
  }
  
  /**
   * Getter method for the attribute row.
   * 
   * @return the value of the attribute row
   */
  
  public int getRow() {
    return this.row;
  }
  
  /**
   * Getter method for the attribute column.
   * 
   * @return the value of the attribute column
   */
  
  public int getColumn() {
    return this.column;
  }
  
  public String toString() {
    String strId = Integer.toString(this.id);
    return strId;
  }
}