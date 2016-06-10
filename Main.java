

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

		PriorityParameters priorityFire = new PriorityParameters(2);
		RelativeTime periodFire = new RelativeTime(200,0);
		RelativeTime startFire = new RelativeTime(50,0);
		PeriodicParameters parametersFire = new PeriodicParameters(startFire, periodFire, null, null, null, null);
		FireSensor fireSensor = new FireSensor(priorityFire, parametersFire, boiler);

		PriorityParameters priorityPump = new PriorityParameters(1);
		RelativeTime periodPump = new RelativeTime(100,0);
		PeriodicParameters parametersPump = new PeriodicParameters(null, periodPump, null, null, null, null);
		PumpSensor pumpSensor = new PumpSensor(priorityPump, parametersPump, boiler);

		PriorityParameters priorityHeat = new PriorityParameters(2);
		RelativeTime periodHeat = new RelativeTime(200,0);
		RelativeTime startHeat = new RelativeTime(100,0);
		PeriodicParameters parametersHeat = new PeriodicParameters(startHeat, periodHeat, null, null, null, null);
		HeatSensor heatSensor = new HeatSensor(priorityHeat, parametersHeat, boiler);

		PriorityParameters priorityBoiler = new PriorityParameters(2);
		RelativeTime periodBoiler = new RelativeTime(100,0);
		RelativeTime startBoiler = new RelativeTime(0,0);
		PeriodicParameters parametersBoiler = new PeriodicParameters(startBoiler, periodBoiler, null, null, null, null);
		BoilerSensor boilerSensor = new BoilerSensor(priorityBoiler, parametersBoiler, boiler);

		PriorityParameters priorityZuador = new PriorityParameters(2);
		RelativeTime periodZuador = new RelativeTime(5050,0);
		RelativeTime startZuador = new RelativeTime(0,0);
		PeriodicParameters parametersZuador = new PeriodicParameters(startZuador, periodZuador, null, null, null, null);
		Zuador zuador = new Zuador(priorityZuador, parametersZuador, boiler);

		fireSensor.start();
		pumpSensor.start();
		heatSensor.start();
		boilerSensor.start();
		zuador.start();
	}
}