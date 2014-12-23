package reindeerraces.reindeer;

public class MovementBehavior
{
	private double increment;
	
	public MovementBehavior(double increment)
	{
		this.increment = increment;
	}

	public void updateDistance(Distance distance)
	{
		distance.increaseBy(increment);
	}
}
