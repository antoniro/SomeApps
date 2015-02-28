import java.util.Timer;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5162 modeling language!*/



/**
 * Umple code for the State machine Controller
 */
// line 4 "model.ump"
// line 51 "model.ump"
public class Controller
{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//Controller Attributes
	private Alarm a;
	private Clock clk;
	private Display d;
	private Timer timer;
	private CheckAlarm task;
	private int h;
	private int m;

	//Controller State Machines
	enum State { idle, settingTime, settingAlarm }
	private State state;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Controller(Alarm aA, Clock aClk, Display aD)
	{
		a = aA;
		clk = aClk;
		d = aD;
		h = 0;
		m = 0;
		setState(State.idle);
	}

	//------------------------
	// INTERFACE
	//------------------------

	public boolean setA(Alarm aA)
	{
		boolean wasSet = false;
		a = aA;
		wasSet = true;
		return wasSet;
	}

	public boolean setClk(Clock aClk)
	{
		boolean wasSet = false;
		clk = aClk;
		wasSet = true;
		return wasSet;
	}

	public boolean setD(Display aD)
	{
		boolean wasSet = false;
		d = aD;
		wasSet = true;
		return wasSet;
	}

	public boolean setH(int aH)
	{
		boolean wasSet = false;
		h = aH;
		wasSet = true;
		return wasSet;
	}

	public boolean setM(int aM)
	{
		boolean wasSet = false;
		m = aM;
		wasSet = true;
		return wasSet;
	}

	public Alarm getA()
	{
		return a;
	}

	public Clock getClk()
	{
		return clk;
	}

	public Display getD()
	{
		return d;
	}

	public int getH()
	{
		return h;
	}

	public int getM()
	{
		return m;
	}

	public String getStateFullName()
	{
		String answer = state.toString();
		return answer;
	}

	public State getState()
	{
		return state;
	}

	public boolean volUpPressed()
	{
		boolean wasEventProcessed = false;
		
		System.out.println("User Pressed Vol Up button");

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 14 "model.ump"
			this.a.increaseVolume();
			setState(State.idle);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}
		

		return wasEventProcessed;
	}

	public boolean volDownPressed()
	{
		boolean wasEventProcessed = false;
		
		System.out.println("User Pressed Vol Down button");

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 15 "model.ump"
			this.a.decreaseVolume();
			setState(State.idle);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}
		

		return wasEventProcessed;
	}

	public boolean stopPressed()
	{
		boolean wasEventProcessed = false;
		
		System.out.println("User Pressed Stop button");

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 16 "model.ump"
			this.a.stop();
			setState(State.idle);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean snoozePressed()
	{
		boolean wasEventProcessed = false;
		
		System.out.println("User Pressed Snooze button");

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 17 "model.ump"
			this.a.snooze();
			setState(State.idle);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean setTimePressed()
	{
		boolean wasEventProcessed = false;
		
		System.out.println("User Pressed Set Time button");

		State aState = state;
		switch (aState)
		{
		case idle:
			setState(State.settingTime);
			wasEventProcessed = true;
			break;
		case settingTime:
			// line 31 "model.ump"
			this.clk.setTime(h, m);
			setState(State.idle);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean setAlarmPressed()
	{
		boolean wasEventProcessed = false;
		
		System.out.println("User Pressed Set Alarm button");

		State aState = state;
		switch (aState)
		{
		case idle:
			setState(State.settingAlarm);
			wasEventProcessed = true;
			break;
		case settingAlarm:
			// line 43 "model.ump"
			this.a.setTime(h, m, 0);
			setState(State.idle);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean min1Pressed()
	{
		boolean wasEventProcessed = false;
		
		System.out.println("User Pressed M+1 button");

		State aState = state;
		switch (aState)
		{
		case settingTime:
			// line 25 "model.ump"
			m = (m+1)%60;
			this.clk.setTime(h, m);
			setState(State.settingTime);
			wasEventProcessed = true;
			break;
		case settingAlarm:
			// line 37 "model.ump"
			m = (m+1)%60;
			this.a.setTime(h, m, 0);
			setState(State.settingAlarm);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean min10Pressed()
	{
		boolean wasEventProcessed = false;
		
		System.out.println("User Pressed M+10 button");

		State aState = state;
		switch (aState)
		{
		case settingTime:
			// line 27 "model.ump"
			m = (m+10)%60;
			this.clk.setTime(h, m);
			setState(State.settingTime);
			wasEventProcessed = true;
			break;
		case settingAlarm:
			// line 39 "model.ump"
			m = (m+10)%60;
			this.a.setTime(h, m, 0);
			setState(State.settingAlarm);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean hours1Pressed()
	{
		boolean wasEventProcessed = false;
		
		System.out.println("User Pressed H+1 button");

		State aState = state;
		switch (aState)
		{
		case settingTime:
			// line 29 "model.ump"
			h = (h+1)%24;
			this.clk.setTime(h, m);
			setState(State.settingTime);
			wasEventProcessed = true;
			break;
		case settingAlarm:
			// line 41 "model.ump"
			h = (h+1)%24;
			this.a.setTime(h, m, 0);
			setState(State.settingAlarm);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	private void setState(State aState)
	{
		state = aState;

		// entry actions and do activities
		switch(state)
		{
		case settingTime:
			// line 23 "model.ump"
			d.displayCurrentTime();
			h = this.clk.getHours();
			m = this.clk.getMinutes();
			break;
		case settingAlarm:
			// line 35 "model.ump"
			d.displayAlarmTime();
			h = this.a.getHours();
			m = this.a.getMinutes();
			break;
		case idle:
			d.displayCurrentTime();
			this.timer = new Timer();
			this.task = new CheckAlarm(this.clk, this.a);
			timer.scheduleAtFixedRate(this.task, 1000, 1000);
			break;
		}
	}

	public void delete()
	{}


	public String toString()
	{
		return "";
	}
}