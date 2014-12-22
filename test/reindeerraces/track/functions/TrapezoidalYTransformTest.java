package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.Test;

public class TrapezoidalYTransformTest
{
	private int yOffset = 30;

	private TwoParameterFunction underTest = new TrapezoidalYTransform(yOffset);
	
	private int distance = 50;
	
	private int lane = 20;
	
	@Test
	public void shouldAddOffset() 
	{
		double result = underTest.applyTo(distance, lane);
		
		assertThat(result, closeTo(yOffset + lane, 0.0001));
	}
}
