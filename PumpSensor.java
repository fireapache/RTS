import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;

public class PumpSensor extends Sensor
{
	protected int force = 2;

	public PumpSensor(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
	{
		super(scheduling, release, ref);
	}

	public void run()
	{
		while (true)
		{
			waitForNextPeriod();

			if (boiler.getWater() > Boiler.maxlim || boiler.getWater() < Boiler.minlim)
			{
				break;
			}

			if (boiler.getWater() > Boiler.maxnorm)
			{
				force = 1;
			}
			else if (boiler.getWater() > Boiler.normal)
			{
				force = 2;
			}
			else if (boiler.getWater() > Boiler.minnorm)
			{
				force = 6;
			}

			boiler.addWater(force);
		}
	}
}