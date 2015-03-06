import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class JeopardyButton extends JButton
  
{
  private int category;
  private int question;
  
  
  public JeopardyButton(ActionListener listener, int category, int question, int amount)
  {
    this.category = category;
    this.question = question;
    this.setText("$" + amount);
    
    
  }
  public int getCategeory(){
    return category;
  }
  public int getQuestion(){
    
    return question;
  }
}