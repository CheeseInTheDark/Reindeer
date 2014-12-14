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
	@Bean(name="trackImage")
	public BufferedImage trackImage() throws IOException
	{
		return ImageIO.read(ClassLoader.getSystemResource("RaceTrack.bmp"));
	}
}
