package reindeer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Reindeer 
{
	private BufferedImage appearance;
	
	private Renderer renderer = new Renderer();
	
	private RaceTrackLocation location;
	
	private TrackLocationMapping mapping;
	
	public Reindeer(BufferedImage reindeerAppearance,
			RaceTrackLocation location, TrackLocationMapping topDownMapping)
	{
		this.appearance = reindeerAppearance;
		this.location = location;
		this.mapping = topDownMapping;
	}

	public void drawOn(Graphics canvas)
	{
		Dimension mappedLocation = location.mapTo(mapping);
		
		renderer.draw(appearance).on(canvas).at(mappedLocation);
	}
}
