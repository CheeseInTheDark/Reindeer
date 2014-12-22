package reindeerraces.track;

import java.awt.Dimension;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;
import reindeerraces.track.functions.Transform;

@Component(value="topDownMapping")
public class TopDownMapping implements TrackLocationMapping
{
	@Resource(name="topDownTransforms")
	private List<Transform> transforms;
	
	@Override
	public Dimension map(Distance distance, Lane lane)
	{
		for (Transform transform : transforms)
		{
			Dimension location = transform.applyTo(distance, lane);
			
			if (location != null)
			{
				return location;
			}
		}
		
		return null;
	}
}
