
public class Commands {

	private Controller c;

	public Commands(Controller c) {
		this.c = c;
	}

	public void volUp() {
		c.volUpPressed();
	}

	public void volDown() {
		c.volDownPressed();
	}

	public void min1() {
		c.min1Pressed();
	}

	public void min10() {
		c.min10Pressed();
	}

	public void hours1() {
		c.hours1Pressed();
	}

	public void stop() {
		c.stopPressed();
	}

	public void snooze() {
		c.snoozePressed();
	}

	public void setTime() {
		c.setTimePressed();
	}

	public void setAlarm() {
		c.setAlarmPressed();
	}

	public Controller getController() {
		return this.c;
	}

}
