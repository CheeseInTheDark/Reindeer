package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


public class RadiusOffsetTest
{
	private double radius = 5;
	
	private double toAdd = 8;
	
	private double expectedResult = 13.0;
	
	private OneParameterFunction underTest = new RadiusOffset(radius);
	
	@Test
	public void shouldAddRadius()
	{
		double result = underTest.applyTo(toAdd);
		
		assertThat(result, is(expectedResult));
	}
}
