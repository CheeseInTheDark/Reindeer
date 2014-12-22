package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.Test;


public class LinearFunctionTest
{
	private LinearFunction underTest;
	
	@Test
	public void shouldAlwaysReturnIntercept()
	{
		underTest = new LinearFunction(100.5, 0);
		
		double result = underTest.applyTo(0);
		assertThat(result, closeTo(100.5, 0.0001));
		
		result = underTest.applyTo(1000);
		assertThat(result, closeTo(100.5, 0.0001));
		
		underTest = new LinearFunction(200, 0);
		
		result = underTest.applyTo(0);
		assertThat(result, closeTo(200, 0.0001));
	}
	
	@Test
	public void shouldApplySlopeOfOne()
	{
		underTest = new LinearFunction(0, 1);
		
		double result = underTest.applyTo(1);
		assertThat(result, closeTo(1, 0.0001));
	}

}
