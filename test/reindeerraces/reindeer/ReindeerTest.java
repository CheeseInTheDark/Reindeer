package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.draw.Renderer;
import reindeerraces.draw.Renderer.RendererNeedingCanvas;
import reindeerraces.draw.Renderer.RendererNeedingLocation;
import reindeerraces.reindeer.RaceTrackLocation;
import reindeerraces.reindeer.Reindeer;
import reindeerraces.track.TrackLocationMapping;


public class ReindeerTest
{
	@InjectMocks
	private Reindeer underTest = new Reindeer(null, null, null, null, null);
	
	@Mock
	private ReindeerName name;
	
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

	@Mock
	private MovementBehavior movementBehavior;
	
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
	
	@Test
	public void shouldHaveReindeerName()
	{
		assertThat(underTest.getReindeerName(), is(name));
	}
	
	@Test
	public void shouldSetReindeerName()
	{
		ReindeerName nameToUse = new ReindeerName("Bob");
		
		underTest.setReindeerName(nameToUse);
		
		assertThat(underTest.getReindeerName(), is(nameToUse));
	}
	
	@Test
	public void shouldUpdateLocation()
	{
		underTest.update();
		
		verify(location).moveUsing(movementBehavior);
	}
}
