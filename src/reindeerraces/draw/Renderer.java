package reindeerraces.draw;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Renderer
{

	public RendererNeedingCanvas draw(BufferedImage image)
	{
		return new RendererNeedingCanvas(image);
	}

	public class RendererNeedingCanvas
	{
		private BufferedImage image;
		
		private RendererNeedingCanvas(BufferedImage appearance)
		{
			this.image = appearance;
		}

		public RendererNeedingLocation on(Graphics canvas)
		{
			return new RendererNeedingLocation(image, canvas);
		}
	}
	
	public class RendererNeedingLocation
	{
		private BufferedImage image;
		private Graphics canvas;
		
		private RendererNeedingLocation(BufferedImage image, Graphics canvas)
		{
			this.image = image;
			this.canvas = canvas;
		}

		public void at(Dimension location)
		{
			canvas.drawImage(image, location.width, location.height, image.getWidth(), image.getHeight(), null);
		}
	}
}
