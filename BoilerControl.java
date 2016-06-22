import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;

public class BoilerControl extends Control
{
	Sensor fireSensor;
	Sensor waterSensor;
	Sensor heatSensor;

	public BoilerControl(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
	{
		super(scheduling, release, ref);

		fireSensor = new FireSensor(ref);
		waterSensor = new WaterSensor(ref);
		heatSensor = new HeatSensor(ref);
	}

	public void run()
	{
		while (true)
		{
			waitForNextPeriod();

			//System.out.print("\033[H\033[2J");
			//System.out.flush();

			//System.out.println("Hello...");
			//System.out.println("           World!");

			System.out.println("====================");

			System.out.print("State: ");

			if (waterSensor.getValue() > Boiler.maxnorm)
			{
				System.out.println("Degradado");
			}
			else if (waterSensor.getValue() > Boiler.normal)
			{
				System.out.println("Normal");
			}
			else
			{
				System.out.println("Degradado");
			}

			System.out.println("Water: " + waterSensor.getValue());
			System.out.println("Fire: " + fireSensor.getValue());
			System.out.println("Heat: " + heatSensor.getValue());

			if (waterSensor.getValue() > Boiler.maxlim || waterSensor.getValue() < Boiler.minlim)
			{
				System.out.println("==============");
				System.out.println("Out of limits!");
				System.out.println("==============");
				break;
			}

			System.out.println("====================");
		}
	}
}