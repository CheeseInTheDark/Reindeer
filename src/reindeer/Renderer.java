package reindeer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Renderer
{

	public RendererNeedingCanvas draw(BufferedImage appearance)
	{
		return new RendererNeedingCanvas(appearance);
	}

	public class RendererNeedingCanvas
	{
		private BufferedImage appearance;
		
		private RendererNeedingCanvas(BufferedImage appearance)
		{
			this.appearance = appearance;
		}

		public RendererNeedingLocation on(Graphics canvas)
		{
			return new RendererNeedingLocation(appearance, canvas);
		}
	}
	
	public class RendererNeedingLocation
	{
		private BufferedImage appearance;
		private Graphics canvas;
		
		private RendererNeedingLocation(BufferedImage appearance, Graphics canvas)
		{
			this.appearance = appearance;
			this.canvas = canvas;
		}

		public void at(Dimension mappedLocation)
		{
			
		}
	}
}
