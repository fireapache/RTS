

public class FireSensor extends Sensor
{
	FireSensor(Boiler ref)
	{
		super(ref);
	}

	public int getValue()
	{
		return boiler.getFire();
	}
}