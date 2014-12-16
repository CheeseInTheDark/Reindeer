package reindeer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeer.Renderer.RendererNeedingCanvas;
import reindeer.Renderer.RendererNeedingLocation;


public class ReindeerTest
{
	@InjectMocks
	private Reindeer underTest = new Reindeer(null, null, null);
	
	@Mock
	private TrackLocationMapping mapping;
	
	@Mock
	private RaceTrackLocation location; 
	
	@Mock
	private Dimension mappedLocation;
	
	@Mock
	private BufferedImage appearance;
	
	@Mock
	private Graphics canvas;
	
	@Mock
	private Renderer renderer;
	
	@Mock
	private RendererNeedingCanvas rendererNeedingCanvas;
	
	@Mock
	private RendererNeedingLocation rendererNeedingLocation;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		when(location.mapTo(mapping)).thenReturn(mappedLocation);
		
		stubRenderer();
	}
	
	private void stubRenderer()
	{
		when(renderer.draw(appearance)).thenReturn(rendererNeedingCanvas);
		when(rendererNeedingCanvas.on(canvas)).thenReturn(rendererNeedingLocation);
	}
	
	@Test
	public void shouldDrawReindeer()
	{
		underTest.drawOn(canvas);
		
		verify(renderer).draw(appearance);
		verify(rendererNeedingCanvas).on(canvas);
		verify(rendererNeedingLocation).at(mappedLocation);
	}
}
