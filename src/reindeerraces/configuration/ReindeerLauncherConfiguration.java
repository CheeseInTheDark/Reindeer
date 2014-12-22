package reindeerraces.configuration;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;
import reindeerraces.reindeer.RaceTrackLocation;

@Configuration
@Import({TopDownBoundariesConfiguration.class, TopDownTransformsConfiguration.class, TransformsConfiguration.class})
@ComponentScan("reindeerraces")
public class ReindeerLauncherConfiguration
{
	@Bean(name="startingLocation")
	public RaceTrackLocation startingLocation()
	{
		return new RaceTrackLocation(new Distance(), new Lane());
	}
	
	@Bean(name="trackImage")
	public BufferedImage trackImage() throws IOException
	{
		return getImage("RaceTrack.bmp");
	}
	
	@Bean(name="topDownReindeerAppearanceBlue")
	public BufferedImage topDownReindeerAppearanceBlue() throws IOException
	{
		return getImage("TopDownReindeerBlueSmall.png");
	}
	
	@Bean(name="topDownReindeerAppearanceGreen")
	public BufferedImage topDownReindeerAppearanceGreen() throws IOException
	{
		return getImage("TopDownReindeerGreenSmall.png");
	}
	
	@Bean(name="topDownReindeerAppearancePink")
	public BufferedImage topDownReindeerAppearancePink() throws IOException
	{
		return getImage("TopDownReindeerPinkSmall.png");
	}
	
	@Bean(name="topDownReindeerAppearancePurple")
	public BufferedImage topDownReindeerAppearancePurple() throws IOException
	{
		return getImage("TopDownReindeerPurpleSmall.png");
	}
	
	@Bean(name="topDownReindeerAppearanceRed")
	public BufferedImage topDownReindeerAppearanceRed() throws IOException
	{
		return getImage("TopDownReindeerRedSmall.png");
	}
	
	@Bean(name="topDownReindeerAppearanceYellow")
	public BufferedImage topDownReindeerAppearanceYellow() throws IOException
	{
		return getImage("TopDownReindeerYellowSmall.png");
	}
	
	private BufferedImage getImage(String path) throws IOException
	{
		return ImageIO.read(ClassLoader.getSystemResource(path));
	}
}
