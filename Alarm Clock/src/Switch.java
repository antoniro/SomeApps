
public class Switch {

	private Alarm a;

	public Switch(Alarm a) {
		this.a = a;
	}

	public void radio() {
		a.selectRadio();
	}

	public void ringer() {
		a.selectRinger();
	}

	public void off() {
		a.turnOff();
	}

	public Alarm getAlarm() {
		return this.a;
	}

}
