package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Dimension;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.reindeer.skill.MovementBehavior;
import reindeerraces.track.FinishLine;
import reindeerraces.track.TrackLocationMapping;


public class RaceTrackLocationTest
{
	@InjectMocks
	private RaceTrackLocation underTest;
	
	@Mock
	private MovementBehavior movementBehavior;
	
	@Mock
	private Lane lane;
	
	@Mock
	private Distance distance;
	
	@Mock
	private TrackLocationMapping mapping;
	
	@Mock
	private Dimension expectedMappedPosition;
	
	@Mock
	private FinishLine finishLine;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		when(mapping.map(distance, lane)).thenReturn(expectedMappedPosition);
	}
	
	@Test
	public void shouldReturnMappedLocation()
	{
		Dimension mappedPosition = underTest.mapTo(mapping);
		
		assertThat(mappedPosition, sameInstance(expectedMappedPosition));
	}
	
	@Test
	public void shouldUpdateDistance()
	{
		underTest.moveUsing(movementBehavior);
		
		verify(movementBehavior).updateDistance(distance);
	}
	
	@Test
	public void shouldIndicateWhenFinishLineIsCrossed()
	{
		when(finishLine.crossedBy(distance, lane)).thenReturn(true);
		
		boolean result = underTest.isPastFinishLine();
		
		assertThat(result, is(true));
	}
	
	@Test
	public void shouldIndicateWhenFinishLineIsNotCrossed()
	{
		when(finishLine.crossedBy(distance,lane)).thenReturn(false);
		
		boolean result = underTest.isPastFinishLine();
		
		assertThat(result, is(false));
	}
}
