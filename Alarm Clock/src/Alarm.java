/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5162 modeling language!*/


import java.util.*;

/**
 * Umple code for the State machine with hardware.
 */
// line 4 "model.ump"
// line 61 "model.ump"
public class Alarm
{

	//------------------------
	// MEMBER VARIABLES
	//------------------------

	//Alarm Attributes
	private int hours;
	private int minutes;
	private int seconds;
	private boolean radioOn;
	private boolean ringerOn;
	private boolean alarmOn;
	private int volume;

	//Alarm State Machines
	enum State { idle, ringing, snoozed, off }
	private State state;

	//Helper Variables
	private TimedEventHandler timeoutringingToidleHandler;
	private TimedEventHandler timeoutsnoozedToringingHandler;

	//------------------------
	// CONSTRUCTOR
	//------------------------

	public Alarm()
	{
		hours = 0;
		minutes = 0;
		seconds = 0;
		radioOn = false;
		ringerOn = false;
		alarmOn = false;
		volume = 3;
		setState(State.off);
	}

	//------------------------
	// INTERFACE
	//------------------------

	public boolean setHours(int aHours)
	{
		boolean wasSet = false;
		hours = aHours;
		wasSet = true;
		return wasSet;
	}

	public boolean setMinutes(int aMinutes)
	{
		boolean wasSet = false;
		minutes = aMinutes;
		wasSet = true;
		return wasSet;
	}

	public boolean setSeconds(int aSeconds)
	{
		boolean wasSet = false;
		seconds = aSeconds;
		wasSet = true;
		return wasSet;
	}

	public boolean setRadioOn(boolean aRadioOn)
	{
		boolean wasSet = false;
		radioOn = aRadioOn;
		wasSet = true;
		return wasSet;
	}

	public boolean setRingerOn(boolean aRingerOn)
	{
		boolean wasSet = false;
		ringerOn = aRingerOn;
		wasSet = true;
		return wasSet;
	}

	public boolean setAlarmOn(boolean aAlarmOn)
	{
		boolean wasSet = false;
		alarmOn = aAlarmOn;
		wasSet = true;
		return wasSet;
	}

	public boolean setVolume(int aVolume)
	{
		boolean wasSet = false;
		volume = aVolume;
		wasSet = true;
		return wasSet;
	}

	public int getHours()
	{
		return hours;
	}

	public int getMinutes()
	{
		return minutes;
	}

	public int getSeconds()
	{
		return seconds;
	}

	public boolean getRadioOn()
	{
		return radioOn;
	}

	public boolean getRingerOn()
	{
		return ringerOn;
	}

	public boolean getAlarmOn()
	{
		return alarmOn;
	}

	public int getVolume()
	{
		return volume;
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

	public boolean increaseVolume()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 16 "model.ump"
			if (this.volume < 5) {this.volume++;};
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm volume increased to " + this.volume);
			break;
		case off:
			// line 49 "model.ump"
			if (this.volume < 5) {this.volume++;};
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm volume increased to " + this.volume);
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean decreaseVolume()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 17 "model.ump"
			if (this.volume > 1) {this.volume--;};
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm volume decreased to " + this.volume);
			break;
		case off:
			// line 50 "model.ump"
			if (this.volume > 1) {this.volume--;};
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm volume decreased to " + this.volume);
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean setTime(int hours,int minutes,int seconds)
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 18 "model.ump"
			this.hours = hours;
			this.minutes = minutes; this.seconds = seconds;
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm time set to " + String.format("%02d", this.hours) + "h" + String.format("%05d", this.minutes));
			break;
		case off:
			// line 51 "model.ump"
			this.hours = hours;
			this.minutes = minutes; this.seconds = seconds;
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm time set to " + String.format("%02d", this.hours) + "h" + String.format("%05d", this.minutes));
			break;
		default:
			System.out.println("Unable to set alarm Time");
			break;
		}

		return wasEventProcessed;
	}

	public boolean start()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case idle:
			setState(State.ringing);
			wasEventProcessed = true;
			System.out.println("Alarm is ringing");
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean selectRadio()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 21 "model.ump"
			this.radioOn = true;
			this.ringerOn = false;
			this.alarmOn = true;
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm Radio selected");
			break;
		case off:
			// line 43 "model.ump"
			this.radioOn = true;
			this.ringerOn = false;
			this.alarmOn = true;
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm Radio selected");
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean selectRinger()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 24 "model.ump"
			this.ringerOn = true;
			this.radioOn = false;
			this.alarmOn = true;
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm Ringer selected");
			break;
		case off:
			// line 46 "model.ump"
			this.ringerOn = true;
			this.radioOn = false;
			this.alarmOn = true;
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm Ringer selected");
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean turnOff()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case idle:
			// line 27 "model.ump"
			this.radioOn = false;
			this.ringerOn = false;
			this.alarmOn = false;
			setState(State.off);
			wasEventProcessed = true;
			System.out.println("Alarm Function is Off");
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean stop()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case ringing:
			exitState();
			setState(State.idle);
			wasEventProcessed = true;
			System.out.println("Alarm stoped");
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean snooze()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case ringing:
			exitState();
			setState(State.snoozed);
			wasEventProcessed = true;
			System.out.println("Alarm snoozed");
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean timeoutringingToidle()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case ringing:
			exitState();
			setState(State.idle);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	public boolean timeoutsnoozedToringing()
	{
		boolean wasEventProcessed = false;

		State aState = state;
		switch (aState)
		{
		case snoozed:
			exitState();
			setState(State.ringing);
			wasEventProcessed = true;
			break;
		default:
			// Other states do respond to this event
		}

		return wasEventProcessed;
	}

	private void exitState()
	{
		switch(state)
		{
		case ringing:
			stopTimeoutringingToidleHandler();
			break;
		case snoozed:
			stopTimeoutsnoozedToringingHandler();
			break;
		case idle:
			break;
		case off:
			break;
		default:
			break;
		}
	}

	private void setState(State aState)
	{
		state = aState;

		// entry actions and do activities
		switch(state)
		{
		case ringing:
			startTimeoutringingToidleHandler();
			break;
		case snoozed:
			startTimeoutsnoozedToringingHandler();
			break;
		case idle:
			break;
		case off:
			break;
		default:
			break;
		}
	}

	private void startTimeoutringingToidleHandler()
	{
		timeoutringingToidleHandler = new TimedEventHandler(this,"timeoutringingToidle",2*60);
	}

	private void stopTimeoutringingToidleHandler()
	{
		timeoutringingToidleHandler.stop();
	}

	private void startTimeoutsnoozedToringingHandler()
	{
		timeoutsnoozedToringingHandler = new TimedEventHandler(this,"timeoutsnoozedToringing",5*60);
	}

	private void stopTimeoutsnoozedToringingHandler()
	{
		timeoutsnoozedToringingHandler.stop();
	}

	public static class TimedEventHandler extends TimerTask  
	{
		private Alarm controller;
		private String timeoutMethodName;
		private double howLongInSeconds;
		private Timer timer;

		public TimedEventHandler(Alarm aController, String aTimeoutMethodName, double aHowLongInSeconds)
		{
			controller = aController;
			timeoutMethodName = aTimeoutMethodName;
			howLongInSeconds = aHowLongInSeconds;
			timer = new Timer();
			timer.schedule(this, (long)howLongInSeconds*1000);
		}

		public void stop()
		{
			timer.cancel();
		}

		public void run ()
		{
			if ("timeoutringingToidle".equals(timeoutMethodName))
			{
				boolean shouldRestart = !controller.timeoutringingToidle();
				if (shouldRestart)
				{
					controller.startTimeoutringingToidleHandler();
				}
				return;
			}
			if ("timeoutsnoozedToringing".equals(timeoutMethodName))
			{
				boolean shouldRestart = !controller.timeoutsnoozedToringing();
				if (shouldRestart)
				{
					controller.startTimeoutsnoozedToringingHandler();
				}
				return;
			}
		}
	}

	public void delete()
	{}


	public String toString()
	{
		String outputString = "";
		return super.toString() + "["+
		"hours" + ":" + getHours()+ "," +
		"minutes" + ":" + getMinutes()+ "," +
		"seconds" + ":" + getSeconds()+ "," +
		"radioOn" + ":" + getRadioOn()+ "," +
		"ringerOn" + ":" + getRingerOn()+ "," +
		"alarmOn" + ":" + getAlarmOn()+ "," +
		"volume" + ":" + getVolume()+ "]"
		+ outputString;
	}
}