package reindeerraces.reindeer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import reindeerraces.draw.Renderer;
import reindeerraces.track.TrackLocationMapping;

public class Reindeer 
{
	private BufferedImage appearance;
	
	private Renderer renderer = new Renderer();
	
	private RaceTrackLocation location;
	
	private TrackLocationMapping mapping;
	
	private ReindeerName reindeerName;
	
	private MovementBehavior movementBehavior;
	
	public Reindeer(BufferedImage reindeerAppearance,
			RaceTrackLocation location, 
			TrackLocationMapping topDownMapping, 
			ReindeerName reindeerName,
			MovementBehavior movementBehavior)
	{
		this.appearance = reindeerAppearance;
		this.location = location;
		this.mapping = topDownMapping;
		this.reindeerName = reindeerName;
		this.movementBehavior = movementBehavior;
	} 
	
	public void drawOn(Graphics canvas)
	{
		Dimension mappedLocation = location.mapTo(mapping);
		
		renderer.draw(appearance).on(canvas).at(mappedLocation);
	}

	public ReindeerName getReindeerName()
	{
		return reindeerName;
	}

	public void setReindeerName(ReindeerName reindeerName)
	{
		this.reindeerName = reindeerName;
	}

	public void update()
	{
		location.moveUsing(movementBehavior);
	}
}
