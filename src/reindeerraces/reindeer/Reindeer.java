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
	
	private Race race;
	
	private FinishPosition position;
	
	private boolean finished = false;
	
	public Reindeer(BufferedImage reindeerAppearance,
			RaceTrackLocation location, 
			TrackLocationMapping topDownMapping, 
			Race race,
			FinishPosition finishPosition,
			ReindeerData reindeerData)
	{
		this.appearance = reindeerAppearance;
		this.location = location;
		this.mapping = topDownMapping;
		this.race = race;
		this.position = finishPosition;
		this.data = reindeerData;
	} 
	
	public void drawOn(Graphics canvas)
	{
		Dimension mappedLocation = location.mapTo(mapping);
		
		renderer.draw(appearance).on(canvas).at(mappedLocation);
	}

	public void update()
	{
		if (!finished)
		{
			skillLevel.update(location);
			
			if (location.isPastFinishLine())
			{
				race.claimPosition(position);
				finished = true;
			}
		}
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
