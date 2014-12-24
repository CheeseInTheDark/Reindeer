package reindeerraces.reindeer.skill;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Race;

public class MovementBehaviorTest
{
	@InjectMocks
	private MovementBehavior underTest;
	
	@Mock
	private Distance distance;
	
	@Mock
	private Velocity velocity;
	
	@Mock
	private Race race;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		when(race.isInProgress()).thenReturn(true);
	}
	
	@Test
	public void shouldAddToDistance()
	{
		underTest.updateDistance(distance);
		
		verify(velocity).applyTo(distance);
	}

	@Test
	public void shouldChangeVelocity()
	{
		underTest.updateDistance(distance);
		
		verify(velocity).update();
	}
	
	@Test
	public void shouldNotUpdateAnythingIfRaceHasNotStarted()
	{
		when(race.isInProgress()).thenReturn(false);
		
		underTest.updateDistance(distance);
		
		verifyZeroInteractions(velocity);
	}
}
