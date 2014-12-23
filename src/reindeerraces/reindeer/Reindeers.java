package reindeerraces.reindeer;

import java.awt.Graphics;
import java.util.List;

public class Reindeers
{
	private List<Reindeer> reindeerList;
	
	public Reindeers(List<Reindeer> reindeerList)
	{
		this.reindeerList = reindeerList;
	}

	public void drawOn(Graphics canvas)
	{
		for(Reindeer reindeer : reindeerList)
		{
			reindeer.drawOn(canvas);
		}
	}

}
