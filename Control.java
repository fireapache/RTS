import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.PriorityParameters;
import javax.realtime.PeriodicParameters;
import javax.realtime.RelativeTime;
import javax.realtime.RealtimeThread;

public class Control extends RealtimeThread
{
	protected Boiler boiler;

	public Control()
	{
		super();
	}

	public Control(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
	{
		super(scheduling, release);
		boiler = ref;
	}

	public void setBoiler(Boiler ref)
	{
		boiler = ref;
	}
}