package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class RandomRangeTest
{
	private RandomRange underTest;
	
	@Mock
	private Random random;

	private double minimumValue = 1.0;
	
	private double maximumValue = 4.0;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		underTest = new RandomRange(random, minimumValue, maximumValue);
	}
	
	@Test
	public void shouldReturnMaximumValue()
	{
		when(random.nextDouble()).thenReturn(1.0);
		
		double result = underTest.next();
		
		assertThat(result, is(maximumValue));
	}
	
	@Test
	public void shouldReturnMinimumValue()
	{
		when(random.nextDouble()).thenReturn(0.0);
		
		double result = underTest.next();
		
		assertThat(result, is(minimumValue));
	}
}
