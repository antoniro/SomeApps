import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Jeopardy extends JFrame implements ActionListener {
  
  private Database database;
  
  public static void main(String[] args) {
    new Jeopardy(Database.readQuestions("lorem_ipsum.txt"));
  }
  
  public Jeopardy (Database database) {
    super("Jeopardy");
    
    this.database = database;
    
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBackground(Color.WHITE);
    setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    
    JPanel categories = new JPanel();
    categories.setVisible(true);
    categories.setLayout(new GridLayout(1,5));
    categories.setBackground(Color.YELLOW);
    
    for (int i = 0; i < database.getNumCategories(); i++) {
      categories.add(new JLabel("    " + database.getCategory(i) + "    ", SwingConstants.CENTER));
    }
    
    add(categories);
    
    JPanel buttons = new JPanel();
    buttons.setVisible(true);
    buttons.setLayout(new BorderLayout());
    JPanel panel = new JPanel();
    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    c.weightx = 1;
    c.weighty = 1;
    panel.setLayout(layout);
    JPanel category;
    
    for (int i = 0; i < database.getNumCategories(); i++) {
      category = new JPanel();
      category.setLayout(new BoxLayout(category, BoxLayout.Y_AXIS));
      
      for (int j = 0; j < database.getNumQuestions(); j++) {
        category.add(new JeopardyButton(this, i, j, (j+1)*100), c);
      }
      
      panel.add(category, c);
    }
    buttons.add(panel);
    
    add(buttons);
    
    pack();
  }
  
  public void actionPerformed(ActionEvent e) {
    
  }
}