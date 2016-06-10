

public class HeatSensor extends Sensor
{
	public HeatSensor(Boiler ref)
	{
		super(ref);
	}

	public int getValue()
	{
		return boiler.getHeat();
	}
}