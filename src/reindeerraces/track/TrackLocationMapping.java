package reindeerraces.track;

import java.awt.Dimension;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;

public interface TrackLocationMapping
{
	public Dimension map(Distance distance, Lane lane);
}
