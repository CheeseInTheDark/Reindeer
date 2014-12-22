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
@Import({TransformsConfiguration.class, TopDownTransformsConfiguration.class, TopDownBoundariesConfiguration.class})
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
	
	@Bean(name="topDownReindeerAppearance")
	public BufferedImage topDownReindeerAppearance() throws IOException
	{
		return getImage("TopDownReindeer.bmp");
	}
	
	private BufferedImage getImage(String path) throws IOException
	{
		return ImageIO.read(ClassLoader.getSystemResource(path));
	}
}
