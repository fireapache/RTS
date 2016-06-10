import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;

public class HeatSensor extends Sensor
{
	protected int heat = 0;

	public HeatSensor(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
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

			heat = boiler.getFire() * 2;

			boiler.setHeat(heat);
			boiler.addWater(-boiler.getFire());
		}
	}
}