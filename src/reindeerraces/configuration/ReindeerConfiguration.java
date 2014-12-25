package reindeerraces.configuration;

import static java.lang.Math.PI;
import static java.util.Arrays.asList;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.swing.ImageIcon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.FinishPosition;
import reindeerraces.reindeer.Lane;
import reindeerraces.reindeer.Race;
import reindeerraces.reindeer.RaceTrackLocation;
import reindeerraces.reindeer.Reindeer;
import reindeerraces.reindeer.ReindeerData;
import reindeerraces.reindeer.ReindeerName;
import reindeerraces.reindeer.Reindeers;
import reindeerraces.reindeer.skill.MovementBehavior;
import reindeerraces.reindeer.skill.RandomRange;
import reindeerraces.reindeer.skill.SkillFactory;
import reindeerraces.reindeer.skill.Velocity;
import reindeerraces.track.FinishLine;
import reindeerraces.track.TopDownMapping;
import reindeerraces.track.functions.LinearFunction;

@Configuration
@Component
public class ReindeerConfiguration
{
	@Bean
	public Race race()
	{
		return new Race();
	}
	
	@Bean(name="skillPointsMapping")
	public Map<Integer, MovementBehavior> movementMap()
	{
		Map<Integer, MovementBehavior> behaviors = new HashMap<Integer, MovementBehavior>();
		
		RandomRange accelerationRange = new RandomRange(new Random(), -0.001, 0.001);
		
		behaviors.put(0, new MovementBehavior(new Velocity(0.42, 0.6, 0.5, accelerationRange), race()));
		behaviors.put(1, new MovementBehavior(new Velocity(0.43, 0.63, 0.5, accelerationRange), race()));
		behaviors.put(2, new MovementBehavior(new Velocity(0.44, 0.66, 0.5, accelerationRange), race()));
		behaviors.put(3, new MovementBehavior(new Velocity(0.45, 0.69, 0.5, accelerationRange), race()));
		behaviors.put(4, new MovementBehavior(new Velocity(0.46, 0.72, 0.5, accelerationRange), race()));
		behaviors.put(5, new MovementBehavior(new Velocity(0.47, 0.75, 0.5, accelerationRange), race()));
		behaviors.put(6, new MovementBehavior(new Velocity(0.48, 0.78, 0.5, accelerationRange), race()));
		behaviors.put(7, new MovementBehavior(new Velocity(0.49, 0.81, 0.5, accelerationRange), race()));
		behaviors.put(8, new MovementBehavior(new Velocity(0.5, 0.84, 0.5, accelerationRange), race()));
		
		return behaviors;
	}
	
	@Bean(name="oddsMapping")
	public Map<Integer, String> oddsMapping()
	{
		Map<Integer, String> odds = new HashMap<Integer, String>();
		
		odds.put(0, "1:10, 1:5");
		odds.put(1, "1:8, 1:4");
		odds.put(2, "1:7, 1:4");
		odds.put(3, "1:6, 1:3");
		odds.put(4, "1:5, 1:3");
		odds.put(5, "1:4, 1:2");
		odds.put(6, "1:3, 1:2");
		odds.put(7, "1:2, 1:1");
		odds.put(8, "1:1, 1:2");
		
		return odds;
	}
	
	@Bean(name="reindeers")
	public Reindeers reindeers() throws IOException
	{
		return new Reindeers(reindeerList(), skillFactory);
	}
	
	@Resource
	public SkillFactory skillFactory;
	
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
	
	@Bean(name="bluePosition")
	public FinishPosition bluePosition()
	{
		return new FinishPosition();
	}
	
	@Bean(name="greenPosition")
	public FinishPosition greenPosition()
	{
		return new FinishPosition();
	}
	
	@Bean(name="pinkPosition")
	public FinishPosition pinkPosition()
	{
		return new FinishPosition();
	}
	
	@Bean(name="purplePosition")
	public FinishPosition purplePosition()
	{
		return new FinishPosition();
	}
	
	@Bean(name="redPosition")
	public FinishPosition redPosition()
	{
		return new FinishPosition();
	}
	
	@Bean(name="yellowPosition")
	public FinishPosition yellowPosition()
	{
		return new FinishPosition();
	}
	
	@Bean(name="blueReindeer")
	public Reindeer createBlue() throws IOException
	{
		return new Reindeer(blueReindeer(), location(-126, 2), topDownMapping(), race(), bluePosition(), blueReindeerData());
	}
 
	public ReindeerData blueReindeerData() throws IOException
	{
		return new ReindeerData(reindeerNameBlue, new ImageIcon(blueReindeer()), null, bluePosition());
	}
	
	@Bean(name="greenReindeer")
	public Reindeer createGreen() throws IOException
	{
		return new Reindeer(greenReindeer(), location(-101, 6), topDownMapping(), race(), greenPosition(), greenReindeerData());
	}
 
	public ReindeerData greenReindeerData() throws IOException
	{
		return new ReindeerData(reindeerNameGreen, new ImageIcon(greenReindeer()), null, greenPosition());
	}
	
	@Bean(name="pinkReindeer")
	public Reindeer createPink() throws IOException
	{
		return new Reindeer(pinkReindeer(), location(-75, 10), topDownMapping(), race(), pinkPosition(), pinkReindeerData());
	}
 
	public ReindeerData pinkReindeerData() throws IOException
	{
		return new ReindeerData(reindeerNamePink, new ImageIcon(pinkReindeer()), null, pinkPosition());
	}
	
	@Bean(name="purpleReindeer")
	public Reindeer createPurple() throws IOException
	{
		return new Reindeer(purpleReindeer(), location(-50, 14), topDownMapping(), race(), purplePosition(), purpleReindeerData());
	} 
	
	public ReindeerData purpleReindeerData() throws IOException
	{
		return new ReindeerData(reindeerNamePurple, new ImageIcon(purpleReindeer()), null, purplePosition());
	}
	
	@Bean(name="redReindeer")
	public Reindeer createRed() throws IOException
	{
		return new Reindeer(redReindeer(), location(-25, 18), topDownMapping(), race(), redPosition(), redReindeerData());
	}
	
	public ReindeerData redReindeerData() throws IOException
	{
		return new ReindeerData(reindeerNameRed, new ImageIcon(redReindeer()), null, redPosition());
	} 
	
	@Bean(name="yellowReindeer")
	public Reindeer createYellow() throws IOException
	{
		return new Reindeer(yellowReindeer(), location(0, 22), topDownMapping(), race(), yellowPosition(), yellowReindeerData());
	}
	
	public ReindeerData yellowReindeerData() throws IOException
	{
		return new ReindeerData(reindeerNameYellow, new ImageIcon(yellowReindeer()), null, yellowPosition());
	} 
	
	public RaceTrackLocation location(int distance, int lane)
	{
		return new RaceTrackLocation(new Distance(distance), new Lane(lane), finishLine());
	}
	
	@Bean
	public FinishLine finishLine()
	{
		return new FinishLine(new LinearFunction(945.017672706, PI * 2));
	}
}
