package reindeer.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeer.RaceTrackLocation;
import reindeer.Reindeer;
import reindeer.ReindeerLauncherConfiguration;
import reindeer.TopDownTrackView;
import reindeer.TrackLocationMapping;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class TopDownTrackViewComponentTest
{
	@Resource(name="topDownTrackView")
	private TopDownTrackView underTest;
	
	@Resource(name="trackImage")
	private BufferedImage trackImage;
	
	@Resource(name="topDownReindeerAppearance")
	private BufferedImage reindeerAppearance;
	
	@Resource(name="topDownMapping")
	private TrackLocationMapping topDownMapping;
	
	@Mock
	private Graphics canvas;
	
	private List<Reindeer> reindeers = new ArrayList<Reindeer>();
	
	private RaceTrackLocation location = new RaceTrackLocation();
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		createReindeer();
		
		underTest.setReindeer(reindeers);
	}
	
	private void createReindeer()
	{
		Reindeer reindeer = new Reindeer(reindeerAppearance, location, topDownMapping);
		
		reindeers.add(reindeer);
	}
	
	@Test
	public void shouldSetPreferredSize()
	{
		Dimension expectedSize = new Dimension(trackImage.getWidth(), trackImage.getHeight());
		
		assertThat(underTest.getPreferredSize(), is(expectedSize));
	}
	
	@Test
	public void shouldPaint()
	{
		underTest.paint(canvas);
		
		verify(canvas).drawImage(eq(trackImage), anyInt(), anyInt(), anyInt(), anyInt(), any(Color.class), eq(null));
	}
	
	@Test
	public void shouldPaintReindeers()
	{
		underTest.paint(canvas);
		
		Dimension expectedLocation = location.mapTo(topDownMapping);
		
		verify(canvas).drawImage(reindeerAppearance, expectedLocation.width, expectedLocation.height, reindeerAppearance.getWidth(), reindeerAppearance.getHeight(), null);
	}
}