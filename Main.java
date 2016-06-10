

import javax.realtime.SchedulingParameters;
import javax.realtime.ReleaseParameters;
import javax.realtime.PriorityScheduler;
import javax.realtime.PriorityParameters;
import javax.realtime.PeriodicParameters;
import javax.realtime.RelativeTime;
import javax.realtime.RealtimeThread;

public class Main
{
	public static void main(String[] args)
	{
		Boiler boiler = new Boiler();

		PriorityParameters priorityFire = new PriorityParameters(1);
		RelativeTime periodFire = new RelativeTime(2000,0);
		RelativeTime startFire = new RelativeTime(500,0);
		PeriodicParameters parametersFire = new PeriodicParameters(startFire, periodFire, null, null, null, null);
		FireControl fireControl = new FireControl(priorityFire, parametersFire, boiler);

		PriorityParameters priorityPump = new PriorityParameters(2);
		RelativeTime periodPump = new RelativeTime(1000,0);
		PeriodicParameters parametersPump = new PeriodicParameters(null, periodPump, null, null, null, null);
		PumpControl pumpControl = new PumpControl(priorityPump, parametersPump, boiler);

		PriorityParameters priorityHeat = new PriorityParameters(3);
		RelativeTime periodHeat = new RelativeTime(2000,0);
		RelativeTime startHeat = new RelativeTime(1000,0);
		PeriodicParameters parametersHeat = new PeriodicParameters(startHeat, periodHeat, null, null, null, null);
		HeatControl heatControl = new HeatControl(priorityHeat, parametersHeat, boiler);

		PriorityParameters priorityBoiler = new PriorityParameters(4);
		RelativeTime periodBoiler = new RelativeTime(2200,0);
		RelativeTime startBoiler = new RelativeTime(0,0);
		PeriodicParameters parametersBoiler = new PeriodicParameters(startBoiler, periodBoiler, null, null, null, null);
		BoilerControl boilerControl = new BoilerControl(priorityBoiler, parametersBoiler, boiler);

		PriorityParameters priorityZuador = new PriorityParameters(5);
		RelativeTime periodZuador = new RelativeTime(10200,0);
		RelativeTime startZuador = new RelativeTime(0,0);
		PeriodicParameters parametersZuador = new PeriodicParameters(startZuador, periodZuador, null, null, null, null);
		Zuador zuador = new Zuador(priorityZuador, parametersZuador, boiler);

		fireControl.start();
		pumpControl.start();
		heatControl.start();
		boilerControl.start();
		zuador.start();
	}
}