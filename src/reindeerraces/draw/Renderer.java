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
			int imageWidth = image.getWidth();
			int imageHeight = image.getHeight();
			
			canvas.drawImage(image, location.width-imageWidth/2, location.height-imageHeight/2, imageWidth, imageHeight, null);
		}
	}
}
