package reindeerraces.reindeer;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MovementBehaviorTest
{
	@InjectMocks
	private MovementBehavior underTest;
	
	@Mock
	private Distance distance;
	
	@Mock
	private Velocity velocity;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
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
}
