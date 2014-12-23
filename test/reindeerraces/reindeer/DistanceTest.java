package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

import org.junit.Test;


public class DistanceTest
{
	private Distance underTest = new Distance(3);
	
	@Test
	public void shouldIncreaseDistance()
	{
		underTest.increaseBy(1.6);
		
		assertThat(underTest.getValue(), closeTo(4.6, 0.0001));
	}
}
