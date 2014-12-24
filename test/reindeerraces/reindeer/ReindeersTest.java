package reindeerraces.reindeer;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import reindeerraces.reindeer.skill.MovementBehavior;
import reindeerraces.reindeer.skill.MovementBehaviorFactory;


public class ReindeersTest
{
	@InjectMocks
	private Reindeers underTest;
	
	@Mock
	private Reindeer reindeer;
	
	@Mock
	private Reindeer anotherReindeer;
	
	@Mock
	private MovementBehavior reindeerMovement;
	
	@Mock
	private MovementBehavior anotherReindeerMovement;
	
	@Mock
	private MovementBehaviorFactory behaviorFactory;
	
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
	
	@Test
	public void shouldUpdateReindeer()
	{
		underTest.update();
		
		verify(reindeer).update();
		verify(anotherReindeer).update();
	}
	
	@Test
	public void shouldScrambleOdds()
	{
		when(behaviorFactory.generate(reindeerList.size())).thenReturn(asList(reindeerMovement, anotherReindeerMovement));
		
		underTest.scrambleReindeerOdds();
		
		verify(reindeer).setMovementBehavior(reindeerMovement);
		verify(anotherReindeer).setMovementBehavior(anotherReindeerMovement);
	}
}
