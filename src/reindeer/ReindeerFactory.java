package reindeer;

import java.awt.image.BufferedImage;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReindeerFactory
{
	@Resource(name="topDownReindeerAppearanceBlue")
	private BufferedImage appearanceBlue;
	
	@Resource(name="topDownReindeerAppearanceGreen")
	private BufferedImage appearanceGreen;
	
	@Resource(name="topDownReindeerAppearancePink")
	private BufferedImage appearancePink;
	
	@Resource(name="topDownReindeerAppearancePurple")
	private BufferedImage appearancePurple;
	
	@Resource(name="topDownReindeerAppearanceRed")
	private BufferedImage appearanceRed;
	
	@Resource(name="topDownReindeerAppearanceYellow")
	private BufferedImage appearanceYellow;	

	@Resource(name="topDownMapping")
	private TrackLocationMapping mapping;

	@Resource(name="startingLocation")
	private RaceTrackLocation location;
	
	
	private ReindeerName reindeerNameBlue = new ReindeerName("Fred");
	private ReindeerName reindeerNameGreen = new ReindeerName("Billy");
	private ReindeerName reindeerNamePink = new ReindeerName("Herbie");
	private ReindeerName reindeerNamePurple = new ReindeerName("Gorbachev");
	private ReindeerName reindeerNameRed = new ReindeerName("Hector");
	private ReindeerName reindeerNameYellow = new ReindeerName("Wilhelmina");
	
	@Bean
	public Reindeer createBlue()
	{
		return new Reindeer(appearanceBlue, location, mapping, reindeerNameBlue);
	}
 
	public Reindeer createGreen()
	{
		return new Reindeer(appearanceGreen, location, mapping, reindeerNameGreen);
	}
 
	public Reindeer createPink()
	{
		return new Reindeer(appearancePink, location, mapping, reindeerNamePink);
	}
 
	public Reindeer createPurple()
	{
		return new Reindeer(appearancePurple, location, mapping, reindeerNamePurple);
	} 
	
	public Reindeer createRed()
	{
		return new Reindeer(appearanceRed, location, mapping, reindeerNameRed);
	}
 
	public Reindeer createYellow()
	{
		return new Reindeer(appearanceYellow, location, mapping, reindeerNameYellow);
	}

}
