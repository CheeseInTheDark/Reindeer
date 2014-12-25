package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class RaceTest
{
	@Mock
	private FinishPosition position;
	
	private Race underTest = new Race();
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
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
	
	@Test
	public void shouldPopulatePositions()
	{
		underTest.claimPosition(position);
		
		verify(position).setValue(1);
		
		underTest.claimPosition(position);
		
		verify(position).setValue(2);
	}
	
	@Test
	public void shouldStopRaceOnceAllPositionsAreClaimed()
	{
		underTest.start();
		
		claimAllPositions();
		
		boolean inProgress = underTest.isInProgress();
		
		assertThat(inProgress, is(false));
	}

	private void claimAllPositions()
	{
		for (int finisher = 0; finisher < 6; finisher++)
		{
			underTest.claimPosition(position);
		}
	}
}
