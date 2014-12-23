package reindeerraces.configuration;

import static java.util.Arrays.asList;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;
import reindeerraces.reindeer.MovementBehavior;
import reindeerraces.reindeer.RaceTrackLocation;
import reindeerraces.reindeer.Reindeer;
import reindeerraces.reindeer.ReindeerName;
import reindeerraces.reindeer.Reindeers;
import reindeerraces.track.TopDownMapping;

@Configuration
public class ReindeerConfiguration
{
	@Bean(name="reindeers")
	public Reindeers reindeers() throws IOException
	{
		return new Reindeers(reindeerList());
	}
	
	@Bean
	public List<Reindeer> reindeerList() throws IOException
	{
		return asList(createBlue(), createRed(), createPink(), createYellow(), createGreen(), createPurple());
	}
	
	@Bean(name="topDownReindeerAppearanceBlue")
	public BufferedImage blueReindeer() throws IOException
	{
		return ImageLoader.getImage("TopDownReindeerBlueDot.png");
	}
	
	@Bean(name="topDownReindeerAppearanceGreen")
	public BufferedImage greenReindeer() throws IOException
	{
		return ImageLoader.getImage("TopDownReindeerGreenDot.png");
	}
	
	@Bean(name="topDownReindeerAppearancePink")
	public BufferedImage pinkReindeer() throws IOException
	{
		return ImageLoader.getImage("TopDownReindeerPinkDot.png");
	}
	
	@Bean(name="topDownReindeerAppearancePurple")
	public BufferedImage purpleReindeer() throws IOException
	{
		return ImageLoader.getImage("TopDownReindeerPurpleDot.png");
	}
	
	@Bean(name="topDownReindeerAppearanceRed")
	public BufferedImage redReindeer() throws IOException
	{
		return ImageLoader.getImage("TopDownReindeerRedDot.png");
	}
	
	@Bean(name="topDownReindeerAppearanceYellow")
	public BufferedImage yellowReindeer() throws IOException
	{
		return ImageLoader.getImage("TopDownReindeerYellowDot.png");
	}
	
	private ReindeerName reindeerNameBlue = new ReindeerName("Fred");
	private ReindeerName reindeerNameGreen = new ReindeerName("Billy");
	private ReindeerName reindeerNamePink = new ReindeerName("Herbie");
	private ReindeerName reindeerNamePurple = new ReindeerName("Gorbachev");
	private ReindeerName reindeerNameRed = new ReindeerName("Hector");
	private ReindeerName reindeerNameYellow = new ReindeerName("Wilhelmina");
	
	@Bean
	public TopDownMapping topDownMapping()
	{
		return new TopDownMapping();
	}
	
	@Bean(name="blueReindeer")
	public Reindeer createBlue() throws IOException
	{
		return new Reindeer(blueReindeer(), location(-126, 2), topDownMapping(), reindeerNameBlue, new MovementBehavior(0.5));
	}
 
	@Bean(name="greenReindeer")
	public Reindeer createGreen() throws IOException
	{
		return new Reindeer(greenReindeer(), location(-101, 6), topDownMapping(), reindeerNameGreen, new MovementBehavior(0.5));
	}
 
	@Bean(name="pinkReindeer")
	public Reindeer createPink() throws IOException
	{
		return new Reindeer(pinkReindeer(), location(-75, 10), topDownMapping(), reindeerNamePink, new MovementBehavior(0.5));
	}
 
	@Bean(name="purpleReindeer")
	public Reindeer createPurple() throws IOException
	{
		return new Reindeer(purpleReindeer(), location(-50, 14), topDownMapping(), reindeerNamePurple, new MovementBehavior(0.5));
	} 
	
	@Bean(name="redReindeer")
	public Reindeer createRed() throws IOException
	{
		return new Reindeer(redReindeer(), location(-25, 18), topDownMapping(), reindeerNameRed, new MovementBehavior(0.5));
	}
 
	@Bean(name="yellowReindeer")
	public Reindeer createYellow() throws IOException
	{
		return new Reindeer(yellowReindeer(), location(0, 22), topDownMapping(), reindeerNameYellow, new MovementBehavior(0.5));
	}
	
	public RaceTrackLocation location(int distance, int lane)
	{
		return new RaceTrackLocation(new Distance(distance), new Lane(lane));
	}
}
