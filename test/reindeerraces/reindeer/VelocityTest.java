package reindeerraces.reindeer;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;


public class VelocityTest
{
	private Velocity underTest;
	
	@Mock
	private Distance distance;
	
	@Mock
	private RandomRange random;

	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		underTest = new Velocity(1.0, 2.0, 1.0, random);
	}
	
	@Test
	public void shouldRandomlyUpdateVelocity()
	{
		whenGettingRandomNumber().thenReturn(0.5);
		
		updateAndApply();
		
		verify(distance).increaseBy(1.5);
	}
	
	@Test
	public void shouldNotIncreaseVelocityAboveMaximum()
	{
		whenGettingRandomNumber().thenReturn(2.0);
		
		updateAndApply();
		
		verify(distance).increaseBy(2.0);
	}
	
	@Test
	public void shouldNotDecreaseVelocityBelowMinimum()
	{
		whenGettingRandomNumber().thenReturn(-1.0);
		
		updateAndApply();
		
		verify(distance).increaseBy(1.0);
	}
	
	private OngoingStubbing<Double> whenGettingRandomNumber()
	{
		return when(random.next());
	}
	
	private void updateAndApply()
	{
		underTest.update();
		underTest.applyTo(distance);
	}
	
}
