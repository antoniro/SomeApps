import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * This is the main window of the game EightPuzzle. A <b>Board</b> object is placed
 * in the center of the frame. The "Start a new game" button is placed at the bottom.
 * 
 * @author Anthony Gbegan & Elijah Balogun, University of Ottawa
 */

public class EightPuzzle extends JFrame implements ActionListener {
  
  /**
   * Keeps a reference to the object <b>board</b> in order to call the method
   * init() whenever the user clicks the "Start a new game" button.
   */
  
  private Board board;
  
  /**
   * Creates the layout of the application.
   */
  
  public EightPuzzle() {
    super("Eight Puzzle");
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.WHITE);
    
    board = new Board();
    add(board, BorderLayout.CENTER);
    
    JButton button = new JButton("Start a new game");
    button.setFocusPainted(false);
    button.addActionListener(this);
    
    JPanel control = new JPanel();
    control.setBackground(Color.WHITE);
    control.add(button);
    add(control, BorderLayout.SOUTH);
    
    pack();
    setResizable(false);
    setVisible(true);
  }
  
  /**
   * This method must be implemented as part of the contract specified by
   * ActionListener. When the user clicks the "Start a new game" button, it calls the
   * method <b>init()</b> of the object designated by <b>board</b>.
   * 
   * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
   */
  
  public void actionPerformed(ActionEvent e) {
    board.init();
  }
  
  /**
   * Java programs start by executing the main method. Here, this main method
   * creates the main window of the application.
   * 
   * @param args
   *            the command line arguments
   */
  
  public static void main(String[] args) {
    StudentInfo.display();
    new EightPuzzle();
  }
}