package reindeer;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("reindeer")
public class ReindeerLauncherConfiguration
{
	@Bean(name="startingLocation")
	public RaceTrackLocation startingLocation()
	{
		return new RaceTrackLocation();
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
