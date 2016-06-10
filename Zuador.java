import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;

public class Zuador extends Control
{
	public Zuador(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
	{
		super(scheduling, release, ref);
	}

	public void run()
	{
		while (true)
		{
			waitForNextPeriod();

			boiler.setFire(30);
		}
	}
}