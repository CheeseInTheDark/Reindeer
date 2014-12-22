package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.Test;


public class TrapezoidalXTransformTest
{
	private int distance = 20;
	
	private int lane = 10;
	
	private int xOffset = 123;
	
	private double laneSkew = 0.5;
	
	private TwoParameterFunction underTest = new TrapezoidalXTransform(xOffset, laneSkew);
	
	@Test
	public void shouldApplyOffset()
	{
		underTest = new TrapezoidalXTransform(xOffset, 0);
		
		double result = underTest.applyTo(distance, 0);
		
		assertThat(result, closeTo(xOffset + distance, 0.0001));
	}
	
	@Test
	public void shouldApplyLaneSkew()
	{
		underTest = new TrapezoidalXTransform(0, laneSkew);
		
		double result = underTest.applyTo(0, lane);
		
		assertThat(result, closeTo(-lane * laneSkew, 0.0001));
	}
}
