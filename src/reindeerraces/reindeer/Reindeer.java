package reindeerraces.reindeer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import reindeerraces.draw.Renderer;
import reindeerraces.reindeer.skill.Skill;
import reindeerraces.track.TrackLocationMapping;

public class Reindeer 
{
	private BufferedImage appearance;
	
	private Renderer renderer = new Renderer();
	
	private RaceTrackLocation location;
	
	private TrackLocationMapping mapping;
	
	private Skill skillLevel;
	
	private ReindeerData data;
	
	public Reindeer(BufferedImage reindeerAppearance,
			RaceTrackLocation location, 
			TrackLocationMapping topDownMapping, 
			ReindeerData reindeerData)
	{
		this.appearance = reindeerAppearance;
		this.location = location;
		this.mapping = topDownMapping;
		this.data = reindeerData;
	} 
	
	public void drawOn(Graphics canvas)
	{
		Dimension mappedLocation = location.mapTo(mapping);
		
		renderer.draw(appearance).on(canvas).at(mappedLocation);
	}

	public void update()
	{
		skillLevel.update(location);
	}

	public void setSkill(Skill skill)
	{
		this.skillLevel = skill;
		this.data.setSkill(skill);
	}

	public ReindeerData getData()
	{
		return data;
	}
}
