import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;

public class HeatControl extends Control
{
	protected int heat = 0;

	Sensor fireSensor;
	Sensor waterSensor;

	public HeatControl(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
	{
		super(scheduling, release, ref);

		fireSensor = new FireSensor(ref);
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

			heat = fireSensor.getValue() * 2;

			boiler.setHeat(heat);
			boiler.addWater(-boiler.getFire());

			System.out.println("Heat Control: Started");
		}
	}
}