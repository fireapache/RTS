import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;

public class FireControl extends Control
{
	protected int fire = 1;

	Sensor waterSensor;

	public FireControl(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
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
				fire = 5;
			}
			else if (waterSensor.getValue() < Boiler.minnorm)
			{
				fire = 2;
			}

			boiler.setFire(fire);

			System.out.println("Fire Control: Started");
		}
	}
}