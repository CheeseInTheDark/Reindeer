package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


public class NegativeFunctionTest
{
	private NegativeFunction underTest = new NegativeFunction();
	
	@Test
	public void shouldReturnNegativeSeven()
	{
		assertThat(underTest.applyTo(7), is(-7));
	}
	
	@Test
	public void shouldReturnNegativeFive()
	{
		assertThat(underTest.applyTo(5), is(-5));
	}
}
