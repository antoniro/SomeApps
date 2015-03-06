import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class Database {
  private int m;                        
  private int n;                        
  private String[] catArray;
  private Question[][] questArray;
  
  private Database(int m,int n){
    this.n = n;
    this.m = m;
    catArray = new String [m];
    questArray = new Question[m][n];
  }
  
  static Database readQuestions(String name){
    
    Scanner sc;
    int m;
    int n;
    
    try {  
      sc = new Scanner(new File(name));  
    } catch (java.io.FileNotFoundException e) {
      sc = null;
    }
    
    if (sc == null) {  
      System.err.println("Erreur en lisant: "+name);  
      return null;  
    }  
    
    if (sc.hasNextInt()) {
      m = sc.nextInt();
    } else {
      return null;
    }
    
    if (sc.hasNextInt()) {
      n = sc.nextInt();
    } else {
      return null;
    }
    
    Database database = new Database(m, n);
    sc.nextLine();
      
    for (int i = 0; i < database.m; i++) {
      if (sc.hasNextLine()) {
        database.catArray[i] = sc.nextLine();
      } else {
        return null;
      }
    }
    
    String response;
    String question;
    
    for (int i = 0; i < database.m; i++) {
      for (int j = 0; j < database.n; j++) {
        if (sc.hasNextLine()) {
          response = sc.nextLine();
        } else {
          return null;
        }
        
        if (sc.hasNextLine()) {
          question = sc.nextLine();
        } else {
          return null;
        }
        
        database.questArray[i][j] = new Question(question, response);
      }
    }
    
    return database;
  }
  
  public String getCategory(int index){
    return this.catArray[index];
  }
  
  public void setCategory(int index,String category){
    this.catArray[index] = category;
  }
  
  public Question getQuestion(int category,int index){
    return this.questArray[category][index];
  }
  
  public void setQuestion(int category,int index,Question question){
    this.questArray[category][index] = question;
  }
  
  public int getNumCategories(){
    return this.m;
  }
  
  public int getNumQuestions(){
    return this.n;
  }
}