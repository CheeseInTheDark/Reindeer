package reindeerraces.reindeer;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MovementBehaviorTest
{
	private double distanceToAdd = 0.4; 
	
	private MovementBehavior underTest = new MovementBehavior(0.4);
	
	@Mock
	private Distance distance;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldAddToDistance()
	{
		underTest.updateDistance(distance);
		
		verify(distance).increaseBy(distanceToAdd);
	}
}
