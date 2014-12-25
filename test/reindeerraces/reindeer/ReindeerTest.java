package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.draw.Renderer;
import reindeerraces.draw.Renderer.RendererNeedingCanvas;
import reindeerraces.draw.Renderer.RendererNeedingLocation;
import reindeerraces.reindeer.skill.Skill;
import reindeerraces.track.TrackLocationMapping;


public class ReindeerTest
{
	@InjectMocks
	private Reindeer underTest = new Reindeer(null, null, null, null);
	
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
	private ReindeerData expectedData;
	
	@Mock
	private Skill skill;
	
	@Mock
	private Skill anotherSkill;
	
	@Mock
	private Race race;
	
	@Mock
	private FinishPosition position;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		underTest.setSkill(skill);
		
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
	public void shouldUpdateLocation()
	{
		underTest.update();
		
		verify(skill).update(location);
	}
	
	@Test
	public void shouldReturnReindeerData()
	{
		ReindeerData data = underTest.getData();
		
		assertThat(data, is(expectedData));
	}
	
	@Test
	public void shouldSetSkill()
	{
		underTest.setSkill(anotherSkill);
		
		underTest.update();
		
		verify(anotherSkill).update(location);
		verify(expectedData).setSkill(anotherSkill);
	}
	
	@Test
	public void shouldFinish()
	{
		when(location.isPastFinishLine()).thenReturn(true);
		
		underTest.update();
		
		verify(race).claimPosition(position);
	}
	
	@Test
	public void shouldNotFinish()
	{
		when(location.isPastFinishLine()).thenReturn(false);
		
		underTest.update();
		
		verifyZeroInteractions(race);
	}
}
