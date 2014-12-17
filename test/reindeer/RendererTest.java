package reindeer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class RendererTest
{
	private Renderer underTest;
	
	@Mock
	private BufferedImage image;
	
	@Mock
	private Graphics canvas;
	
	@Mock
	private Dimension location;
	
	private int width = 5;
	
	private int height = 8;
	
	@Before
	public void setup()
	{
		underTest = new Renderer();
		
		MockitoAnnotations.initMocks(this);
		
		when(image.getWidth()).thenReturn(width);
		when(image.getHeight()).thenReturn(height);
		
		location.width = 3;
		location.height = 10;
	}
	
	@Test
	public void shouldDrawImageOnCanvasAtLocation()
	{
		underTest.draw(image).on(canvas).at(location);
		
		verify(canvas).drawImage(image, location.width, location.height, image.getWidth(), image.getHeight(), null);
	}
}
