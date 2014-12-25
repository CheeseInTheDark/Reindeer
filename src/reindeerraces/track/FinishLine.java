package reindeerraces.track;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;
import reindeerraces.track.functions.OneParameterFunction;

public class FinishLine
{
	private OneParameterFunction lineFunction;
	
	public FinishLine(OneParameterFunction finishLineBoundary)
	{
		this.lineFunction = finishLineBoundary;
	}

	public boolean crossedBy(Distance distance, Lane lane)
	{
		return distance.getValue() >= lineFunction.applyTo(lane.getValue());
	}

}
