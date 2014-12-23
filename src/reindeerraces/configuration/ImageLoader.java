package reindeerraces.configuration;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader
{
	public static BufferedImage getImage(String path) throws IOException
	{
		return ImageIO.read(ClassLoader.getSystemResource(path));
	}
}
