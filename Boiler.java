


public class Boiler
{
	protected int water = 10;
	protected int heat = 0;
	protected int fire = 0;

	public static int maxlim = 90;
	public static int maxnorm = 70;
	public static int normal = 50;
	public static int minnorm = 30;
	public static int minlim = 10;

	public synchronized void addWater(int value)
	{
		water += value;
	}

	public synchronized void setHeat(int value)
	{
		heat = value;
	}

	public synchronized void setFire(int value)
	{
		fire = value;
	}

	public int getFire()
	{
		return fire;
	}

	public int getWater()
	{
		return water;
	}

	public int getHeat()
	{
		return heat;
	}
}
