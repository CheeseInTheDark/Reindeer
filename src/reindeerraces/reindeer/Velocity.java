package reindeerraces.reindeer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Velocity
{
	private RandomRange random;
	
	private double value;
	
	private double maximumVelocity;
	
	private double minimumVelocity;
	
	public Velocity(double initialVelocity, double maximumVelocity, double minimumVelocity, RandomRange random)
	{
		this.random = random;
		this.value = initialVelocity;
		this.maximumVelocity = maximumVelocity;
		this.minimumVelocity = minimumVelocity;
	}

	public void applyTo(Distance distance)
	{
		distance.increaseBy(value);
	}

	public void update()
	{
		value += random.next();
		
		value = min(maximumVelocity, value);
		value = max(value, minimumVelocity);
	}

}
