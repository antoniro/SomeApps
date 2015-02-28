
public class Display {

	private Clock clk;
	private Alarm a;

	public Display(Clock clk, Alarm a) {
		this.clk = clk;
		this.a = a;
	}

	public void displayCurrentTime() {
		System.out.println("Current Time: " + String.format("%02d",clk.getHours()) + "h" + String.format("%02d",clk.getMinutes()) + "\n");
	}

	public void displayAlarmTime() {
		System.out.println("Alarm Time: " + String.format("%02d", a.getHours()) + "h" + String.format("%02d", a.getMinutes()) + "\n");
	}

}
