
public class AlarmClock {
 
 public Display d;
 private Alarm a;
 private Controller c;
 public Commands cmd;
 public Switch s;
 private Clock clk;
 
 public AlarmClock(){
    a = new Alarm();
    clk = new Clock();
    s = new Switch(a);
    d =new Display(clk,a);
  c= new Controller(a, clk, d);
  cmd = new Commands(c);
 }
 
}