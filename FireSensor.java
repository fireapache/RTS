import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;

public class FireSensor extends Sensor
{
	protected int fire = 1;

	public FireSensor(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
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
				fire = 5;
			}
			else if (boiler.getWater() < Boiler.minnorm)
			{
				fire = 2;
			}

			boiler.setFire(fire);
		}
	}
}