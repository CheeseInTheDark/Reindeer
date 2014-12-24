package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


public class RaceTest
{

	private Race underTest = new Race();
	
	@Test
	public void raceShouldNotBeStarted()
	{
		boolean started = underTest.isInProgress();
		
		assertThat(started, is(false));
	}
	
	@Test
	public void raceShouldBeStarted()
	{
		underTest.mouseClicked(null);
		
		assertThat(underTest.isInProgress(), is(true));
	}
}
