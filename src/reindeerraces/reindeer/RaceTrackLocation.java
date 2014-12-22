package reindeerraces.reindeer;

import java.awt.Dimension;

import reindeerraces.track.TrackLocationMapping;

public class RaceTrackLocation
{
	private Lane lane;
	
	private Distance distance;
	
	public RaceTrackLocation(Distance distance, Lane lane)
	{
		this.distance = distance;
		this.lane = lane;
	}

	public Dimension mapTo(TrackLocationMapping locationMapper)
	{
		return locationMapper.map(distance, lane);
	}
}