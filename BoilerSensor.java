import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;

public class BoilerSensor extends Sensor
{
	public BoilerSensor(SchedulingParameters scheduling, ReleaseParameters release, Boiler ref)
	{
		super(scheduling, release, ref);
	}

	public void run()
	{
		while (true)
		{
			waitForNextPeriod();

			System.out.print("\033[H\033[2J");
			System.out.flush();

			//System.out.println("Hello...");
			//System.out.println("           World!");

			System.out.println("Water: " + boiler.getWater());
			System.out.println("Fire: " + boiler.getFire());
			System.out.println("Heat: " + boiler.getHeat());

			if (boiler.getWater() > Boiler.maxlim || boiler.getWater() < Boiler.minlim)
			{
				System.out.println("==============");
				System.out.println("Out of limits!");
				System.out.println("==============");
				break;
			}
		}
	}
}