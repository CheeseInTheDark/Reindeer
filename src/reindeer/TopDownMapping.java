package reindeer;

import java.awt.Dimension;

public class TopDownMapping implements TrackLocationMapping
{
	@Override
	public Dimension map(RaceTrackLocation location)
	{
		return new Dimension(0, 0);
	}
}
