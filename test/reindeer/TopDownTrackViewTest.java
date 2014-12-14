package reindeer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		when(trackImage.getWidth()).thenReturn(width);
		when(trackImage.getHeight()).thenReturn(height);
	}
	
	@Test
	public void shouldPaintTrack()
	{
		underTest.paint(graphics);
		
		verify(graphics).drawImage(trackImage, 0, 0, width, height, Color.WHITE, null);
	}
}
