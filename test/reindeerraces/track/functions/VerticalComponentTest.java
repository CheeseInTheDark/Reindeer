package reindeerraces.track.functions;

import static java.lang.Math.PI;
import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Test;


public class VerticalComponentTest 
{
	private double radius = 20.0;
	
	private double angle = PI/4;
	
	private TwoParameterFunction underTest = new VerticalComponent();
	
	private double expectedResult = 14.1421356237;
	
	@Test
	public void shouldReturnVerticalComponent()
	{
		double result = underTest.applyTo(radius, angle);
		
		assertThat(result, Matchers.closeTo(expectedResult, 0.0001));
	}
}
