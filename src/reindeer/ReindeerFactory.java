package reindeer;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReindeerFactory
{
	@Resource(name="topDownReindeerAppearance")
	private BufferedImage appearance;
	
	@Resource(name="topDownMapping")
	private TrackLocationMapping mapping;

	@Resource(name="startingLocation")
	private RaceTrackLocation location;
	
	@Bean
	public Reindeer create()
	{
		return new Reindeer(appearance, location, mapping);
	}
}
