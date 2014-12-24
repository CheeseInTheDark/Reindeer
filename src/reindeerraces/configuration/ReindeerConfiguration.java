package reindeerraces.configuration;

import static java.util.Arrays.asList;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;
import reindeerraces.reindeer.RaceTrackLocation;
import reindeerraces.reindeer.Reindeer;
import reindeerraces.reindeer.ReindeerName;
import reindeerraces.reindeer.Reindeers;
import reindeerraces.reindeer.skill.MovementBehavior;
import reindeerraces.reindeer.skill.MovementBehaviorFactory;
import reindeerraces.reindeer.skill.RandomRange;
import reindeerraces.reindeer.skill.Velocity;
import reindeerraces.track.TopDownMapping;

@Configuration
public class ReindeerConfiguration
{
	@Bean(name="skillPointsMapping")
	public Map<Integer, MovementBehavior> movementMap()
	{
		Map<Integer, MovementBehavior> behaviors = new HashMap<Integer, MovementBehavior>();
		
		RandomRange accelerationRange = new RandomRange(new Random(), -0.001, 0.001);
		
		behaviors.put(0, new MovementBehavior(new Velocity(0.5, 0.6, 0.5, accelerationRange)));
		behaviors.put(1, new MovementBehavior(new Velocity(0.5, 0.62, 0.5, accelerationRange)));
		behaviors.put(2, new MovementBehavior(new Velocity(0.5, 0.64, 0.5, accelerationRange)));
		behaviors.put(3, new MovementBehavior(new Velocity(0.5, 0.66, 0.5, accelerationRange)));
		behaviors.put(4, new MovementBehavior(new Velocity(0.5, 0.68, 0.5, accelerationRange)));
		behaviors.put(5, new MovementBehavior(new Velocity(0.5, 0.7, 0.5, accelerationRange)));
		behaviors.put(6, new MovementBehavior(new Velocity(0.5, 0.72, 0.5, accelerationRange)));
		behaviors.put(7, new MovementBehavior(new Velocity(0.5, 0.74, 0.5, accelerationRange)));
		behaviors.put(8, new MovementBehavior(new Velocity(0.5, 0.76, 0.5, accelerationRange)));
		
		return behaviors;
	}
	
	@Resource
	private MovementBehaviorFactory movementBehaviorFactory;
	
	@Bean(name="reindeers")
	public Reindeers reindeers() throws IOException
	{
		return new Reindeers(reindeerList(), movementBehaviorFactory);
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
		return new Reindeer(blueReindeer(), location(-126, 2), topDownMapping(), reindeerNameBlue);
	}
 
	@Bean(name="greenReindeer")
	public Reindeer createGreen() throws IOException
	{
		return new Reindeer(greenReindeer(), location(-101, 6), topDownMapping(), reindeerNameGreen);
	}
 
	@Bean(name="pinkReindeer")
	public Reindeer createPink() throws IOException
	{
		return new Reindeer(pinkReindeer(), location(-75, 10), topDownMapping(), reindeerNamePink);
	}
 
	@Bean(name="purpleReindeer")
	public Reindeer createPurple() throws IOException
	{
		return new Reindeer(purpleReindeer(), location(-50, 14), topDownMapping(), reindeerNamePurple);
	} 
	
	@Bean(name="redReindeer")
	public Reindeer createRed() throws IOException
	{
		return new Reindeer(redReindeer(), location(-25, 18), topDownMapping(), reindeerNameRed);
	}
 
	@Bean(name="yellowReindeer")
	public Reindeer createYellow() throws IOException
	{
		return new Reindeer(yellowReindeer(), location(0, 22), topDownMapping(), reindeerNameYellow);
	}
	
	public RaceTrackLocation location(int distance, int lane)
	{
		return new RaceTrackLocation(new Distance(distance), new Lane(lane));
	}
}
