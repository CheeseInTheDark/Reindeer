package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.guicomponents.ReindeerTableModel;


public class RaceTest
{
	@Mock
	private FinishPosition position;
	
	@Mock
	private ReindeerTableModel model;
	
	@InjectMocks
	private Race underTest;
	
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
	public void shouldUpdateTableWhenPositionIsClaimed()
	{
		underTest.claimPosition(position);
		
		verify(model).fireTableDataChanged();
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
