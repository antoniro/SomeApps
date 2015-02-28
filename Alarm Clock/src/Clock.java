
import java.util.Timer;

public class Clock {

	private Timer clock;
	private Task timer;

	public Clock() {
		this.clock = new Timer();
		this.timer = new Task();
		this.clock.scheduleAtFixedRate(timer, 1000, 1000);
	}

	public void setTime(int hours, int minutes) {
		this.clock.cancel();
		this.clock = new Timer();
		this.timer = new Task(hours, minutes, 0);
		this.clock.scheduleAtFixedRate(timer, 1000, 1000);
	}

	public int getHours() {
		return this.timer.getHours();
	}

	public int getMinutes(){
		return this.timer.getMinutes();
	}

}
