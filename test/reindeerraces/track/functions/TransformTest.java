package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.mockito.Mockito.when;

import java.awt.Dimension;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;


public class TransformTest
{
	@InjectMocks
	private Transform underTest;
	
	@Mock
	private Boundary bounds;
	
	@Mock
	private Distance distance;

	private double distanceValue = 50;
	
	private double relativeDistanceValue = 30;
	
	@Mock
	private Lane lane;
	
	private double laneValue = 12;
	
	@Mock
	private LocationFunction transformFunction;
	
	@Mock
	private Dimension expectedLocation;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		when(transformFunction.applyTo(relativeDistanceValue, laneValue)).thenReturn(expectedLocation);
		
		when(bounds.relativeDistance(distanceValue, laneValue)).thenReturn(relativeDistanceValue);
		when(distance.getValue()).thenReturn(distanceValue);
		when(lane.getValue()).thenReturn(laneValue);
		
		distanceAndLaneAreInBounds();
	}

	private void distanceAndLaneAreInBounds()
	{
		whenCheckingBounds().thenReturn(true);
	}
	
	@Test
	public void shouldReturnFunctionResult()
	{
		Dimension location = underTest.applyTo(distance, lane);
		
		assertThat(location, sameInstance(expectedLocation));
	}
	
	@Test
	public void shouldReturnNullIfLocationIsNotInBounds()
	{
		distanceAndLaneAreOutOfBounds();
		
		Dimension location = underTest.applyTo(distance, lane);
		
		assertThat(location, is(nullValue()));
	}
	
	private void distanceAndLaneAreOutOfBounds()
	{
		whenCheckingBounds().thenReturn(false);
	}
	
	private OngoingStubbing<Boolean> whenCheckingBounds()
	{
		return when(bounds.contains(distanceValue, laneValue));
	}
}
