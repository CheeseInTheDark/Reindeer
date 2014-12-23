package reindeerraces.reindeer;

import static org.mockito.Mockito.verify;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


public class ReindeersTest
{
	@InjectMocks
	private Reindeers underTest;
	
	@Mock
	private Reindeer reindeer;
	
	@Mock
	private Reindeer anotherReindeer;
	
	@Spy
	private List<Reindeer> reindeerList = new ArrayList<Reindeer>();
	
	@Mock
	private Graphics canvas;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		reindeerList.add(reindeer);
		reindeerList.add(anotherReindeer);
	}
	
	@Test
	public void shouldDrawReindeer()
	{
		underTest.drawOn(canvas);
		
		verify(reindeer).drawOn(canvas);
		verify(anotherReindeer).drawOn(canvas);
	}
}
