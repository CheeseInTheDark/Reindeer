package reindeerraces.reindeer;

import java.awt.Dimension;

import reindeerraces.reindeer.skill.MovementBehavior;
import reindeerraces.track.FinishLine;
import reindeerraces.track.TrackLocationMapping;

public class RaceTrackLocation
{
	private Lane lane;
	
	private Distance distance;
	
	private FinishLine finish;
	
	public RaceTrackLocation(Distance distance, Lane lane, FinishLine finish)
	{
		this.distance = distance;
		this.lane = lane;
		this.finish = finish;
	}

	public Dimension mapTo(TrackLocationMapping locationMapper)
	{
		return locationMapper.map(distance, lane);
	}

	public void moveUsing(MovementBehavior movementBehavior)
	{
		movementBehavior.updateDistance(distance);
	}

	public boolean isPastFinishLine()
	{
		return finish.crossedBy(distance, lane);
	}
}
