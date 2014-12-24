package reindeerraces.reindeer.skill;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Race;

public class MovementBehavior
{
	private Velocity velocity;
	
	private Race race;
	
	public MovementBehavior(Velocity velocity, Race race)
	{
		this.velocity = velocity;
		this.race = race;
	}

	public void updateDistance(Distance distance)
	{
		if (race.isInProgress())
		{
			velocity.update();
			velocity.applyTo(distance);
		}
	}
}
