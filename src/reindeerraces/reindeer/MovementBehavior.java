package reindeerraces.reindeer;

public class MovementBehavior
{
	private Velocity velocity;
	
	public MovementBehavior(Velocity velocity)
	{
		this.velocity = velocity;
	}

	public void updateDistance(Distance distance)
	{
		velocity.update();
		velocity.applyTo(distance);
	}
}
