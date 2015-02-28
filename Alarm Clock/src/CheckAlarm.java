import java.util.TimerTask;

public class CheckAlarm extends TimerTask{

	public Clock c;
	public Alarm a;

	public CheckAlarm(Clock c, Alarm a) {
		this.c = c;
		this.a = a;
	}

	public void run() {
		if ((this.a.getHours() == this.c.getHours()) && (this.a.getMinutes() == this.c.getMinutes())) {
			this.a.start();
			cancel();}
	}

}
