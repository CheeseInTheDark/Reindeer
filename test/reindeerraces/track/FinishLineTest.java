package reindeerraces.track;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;
import reindeerraces.track.functions.OneParameterFunction;


public class FinishLineTest
{
	@Mock
	private OneParameterFunction finishLineBound;
	
	@InjectMocks
	private FinishLine underTest;
	
	@Mock
	private Distance distance;
	
	private double distanceValue = 2.0;
	
	@Mock
	private Lane lane;
	
	private double laneValue = 3.0;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		when(distance.getValue()).thenReturn(distanceValue);
		when(lane.getValue()).thenReturn(laneValue);
	}
	
	@Test
	public void shouldReturnCrossed()
	{
		when(finishLineBound.applyTo(laneValue)).thenReturn(2.0);
		
		boolean crossed = underTest.crossedBy(distance, lane);
		
		assertThat(crossed, is(true));
	}
	
	@Test
	public void shouldReturnNotCrossed()
	{
		when(finishLineBound.applyTo(laneValue)).thenReturn(2.1);
		
		boolean crossed = underTest.crossedBy(distance, lane);
		
		assertThat(crossed, is(false));
	}
}
