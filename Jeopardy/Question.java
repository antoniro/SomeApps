public class Question{
  private String question;
  private String response;
  
  public Question(String question,String response)
  {
    this.question = question;
    this.response =  response;
  }
  
  public String getQuestion(){
    return this.question;
  }
  
  public String getResponse(){
    return this.response;
  }
}