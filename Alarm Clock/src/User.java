
public class User {

 public static void main(String[] args) throws InterruptedException {
   
   // Please edit this method to interact with the Alarm clock by using the commands you find in
   // the Commands.java file
  
  AlarmClock ac = new AlarmClock();
  ac.cmd.setTime();
  ac.cmd.hours1();
  Thread.sleep(1000);
  ac.cmd.hours1();
  Thread.sleep(1000);
  ac.cmd.hours1();
  Thread.sleep(1000);
  ac.cmd.min1();
  Thread.sleep(1000);
  ac.cmd.min1();
  Thread.sleep(1000);
  ac.cmd.min1();
  ac.cmd.min1();
  Thread.sleep(1000);
  ac.cmd.min1();
  ac.cmd.min10();
  Thread.sleep(1000);
  ac.cmd.min10();
  ac.cmd.min10();
  Thread.sleep(1000);
  ac.cmd.min10();
  Thread.sleep(1000);
  ac.cmd.min10();
  Thread.sleep(1000);
  ac.cmd.min10();
  Thread.sleep(1000);
  ac.cmd.min10();
  ac.cmd.min10();
  ac.cmd.hours1();
  ac.cmd.setTime();

 }

}
