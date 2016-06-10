

public class WaterSensor extends Sensor
{
	WaterSensor(Boiler ref)
	{
		super(ref);
	}

	public int getValue()
	{
		return boiler.getWater();
	}
}