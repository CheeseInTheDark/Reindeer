package reindeerraces.track.functions;

import java.awt.Dimension;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;

public class Transform
{
	private LocationFunction function;
	
	private Boundary bounds;
	
	public Transform(LocationFunction function,
			Boundary bounds)
	{
		this.function = function;
		this.bounds = bounds;
	}

	public Dimension applyTo(Distance distance, Lane lane)
	{
		if (bounds.contains(distance.getValue(), lane.getValue()))
		{
			return function.applyTo(distance.getValue(), lane.getValue());
		}
		
		return null;
	}
}
