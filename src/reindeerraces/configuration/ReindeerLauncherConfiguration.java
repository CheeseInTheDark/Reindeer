package reindeerraces.configuration;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ReindeerConfiguration.class, TopDownBoundariesConfiguration.class, TopDownTransformsConfiguration.class, TransformsConfiguration.class})
@ComponentScan("reindeerraces")
public class ReindeerLauncherConfiguration
{
	@Bean(name="trackImage")
	public BufferedImage trackImage() throws IOException
	{
		return ImageLoader.getImage("RaceTrack.bmp");
	}
}
