package reindeer;

import java.awt.Dimension;

import org.springframework.stereotype.Component;

@Component(value="topDownMapping")
public class TopDownMapping implements TrackLocationMapping
{
	@Override
	public Dimension map(RaceTrackLocation location)
	{
		return new Dimension(0, 0);
	}
}
