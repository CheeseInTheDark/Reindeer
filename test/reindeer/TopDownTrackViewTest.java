package reindeer;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class TopDownTrackViewTest
{
	@InjectMocks
	private TopDownTrackView underTest;

	@Mock
	private BufferedImage trackImage;
	private int width = 10;
	private int height = 10;
	
	@Mock
	private Graphics graphics;
	
	@Mock
	private Reindeer firstReindeer;
	
	@Mock
	private Reindeer secondReindeer;
	
	@Mock
	private Reindeer thirdReindeer;
	
	@Spy
	private List<Reindeer> reindeers = new ArrayList<Reindeer>();
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		stubReindeersList();
		
		reset(reindeers);
		
		when(trackImage.getWidth()).thenReturn(width);
		when(trackImage.getHeight()).thenReturn(height);
	}
	
	private void stubReindeersList()
	{
		reindeers.add(firstReindeer);
		reindeers.add(secondReindeer);
		reindeers.add(thirdReindeer);
	}
	
	@Test
	public void shouldPaintTrack()
	{
		underTest.paint(graphics);
		
		verify(graphics).drawImage(trackImage, 0, 0, width, height, Color.WHITE, null);
	}
	
	@Test
	public void shouldPaintAllReindeer()
	{
		underTest.setReindeer(reindeers);
		
		underTest.paint(graphics);
		
		verify(firstReindeer).drawOn(graphics);
		verify(secondReindeer).drawOn(graphics);
		verify(thirdReindeer).drawOn(graphics);
	}
	
	@Test
	public void shouldPaintNoReindeer()
	{
		underTest.setReindeer(null);
		
		underTest.paint(graphics);
		
		verifyZeroInteractions(reindeers);
	}

}
