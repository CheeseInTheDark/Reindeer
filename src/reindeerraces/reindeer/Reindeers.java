package reindeerraces.reindeer;

import java.awt.Graphics;
import java.util.List;

import javax.annotation.Resource;

public class Reindeers
{
	private List<Reindeer> reindeerList;
	
	private MovementBehaviorFactory movementBehaviorFactory;
	
	public Reindeers(List<Reindeer> reindeerList, MovementBehaviorFactory behaviorFactory)
	{
		this.reindeerList = reindeerList;
		this.movementBehaviorFactory = behaviorFactory;
	}

	public void drawOn(Graphics canvas)
	{
		for(Reindeer reindeer : reindeerList)
		{
			reindeer.drawOn(canvas);
		}
	}

	public void update()
	{
		for(Reindeer reindeer : reindeerList)
		{
			reindeer.update();
		}
	}

	public void scrambleReindeerOdds()
	{
		List<MovementBehavior> behaviors = movementBehaviorFactory.generate(reindeerList.size());
		
		for (int reindeer = 0; reindeer < reindeerList.size(); reindeer++)
	    {
			reindeerList.get(reindeer).setMovementBehavior(behaviors.get(reindeer));
		}
	}

}
