package reindeerraces.track.functions;

import static java.lang.Math.PI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.Test;


public class HorizontalComponentTest
{
	private TwoParameterFunction underTest = new HorizontalComponent();
	
	private double input = 20.0;
	
	private double angle = PI/4;
	
	private double expectedResult = 14.1421356237;
	
	@Test
	public void shouldReturnHorizontalComponent()
	{
		double result = underTest.applyTo(input, angle);
		
		assertThat(result, closeTo(expectedResult, 0.0001));
	}
}
