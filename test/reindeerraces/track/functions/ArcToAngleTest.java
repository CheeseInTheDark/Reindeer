package reindeerraces.track.functions;

import static java.lang.Math.PI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


public class ArcToAngleTest
{
	int radius = 10;
	int arc = 10;
	double offset = PI/2;
	
	double expectedResult = (arc/radius) + offset;
	
	private TwoParameterFunction underTest = new ArcToAngle(offset);
	
	@Test
	public void shouldApplyOffset()
	{
		double result = underTest.applyTo(radius, arc);
		
		assertThat(result, is(expectedResult));
	}
}
