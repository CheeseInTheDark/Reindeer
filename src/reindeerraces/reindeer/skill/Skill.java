package reindeerraces.reindeer.skill;

import reindeerraces.reindeer.RaceTrackLocation;

public class Skill
{
	private String odds;
	private MovementBehavior movementBehavior;
	
	public Skill(String odds, MovementBehavior movementBehavior)
	{
		this.odds = odds;
		this.movementBehavior = movementBehavior;
	}

	public String getOdds()
	{
		return odds;
	}

	public void update(RaceTrackLocation location)
	{
		location.moveUsing(movementBehavior);
	}
}
