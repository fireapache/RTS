import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;

public class PumpControl extends Control
{
	protected int force = 2;

	Sensor waterSensor;

	public PumpControl(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
	{
		super(scheduling, release, ref);

		waterSensor = new WaterSensor(ref);
	}

	public void run()
	{
		while (true)
		{
			waitForNextPeriod();

			if (waterSensor.getValue() > Boiler.maxlim || waterSensor.getValue() < Boiler.minlim)
			{
				break;
			}

			if (waterSensor.getValue() > Boiler.maxnorm)
			{
				force = 1;
			}
			else if (waterSensor.getValue() > Boiler.normal)
			{
				force = 2;
			}
			else if (waterSensor.getValue() > Boiler.minnorm)
			{
				force = 6;
			}

			boiler.addWater(force);

			System.out.println("Water Pump: Started");
		}
	}
}