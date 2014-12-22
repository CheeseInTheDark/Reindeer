package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.awt.Dimension;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LocationFunctionTest
{
	@InjectMocks
	private LocationFunction underTest;
	
	@Mock
	private TwoParameterFunction xTransform;
	
	@Mock
	private TwoParameterFunction yTransform;
	
	private int lane = 10;
	
	private int distance = 12;
	
	private double expectedX = 50;
	
	private double expectedY = 30;
	
	private double unroundedX = 49.9;
	
	private double unroundedY = 29.8;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnXResult()
	{
		when(xTransform.applyTo(distance, lane)).thenReturn(expectedX);
		
		Dimension result = underTest.applyTo(distance, lane);
		
		assertThat(result.getWidth(), is(expectedX));
	}
	
	@Test
	public void shouldReturnYResult()
	{
		when(yTransform.applyTo(distance, lane)).thenReturn(expectedY);
		
		Dimension result = underTest.applyTo(distance, lane);
		
		assertThat(result.getHeight(), is(expectedY));
	}
	
	@Test
	public void shouldRoundXResult()
	{
		when(xTransform.applyTo(distance, lane)).thenReturn(unroundedX);
		
		Dimension result = underTest.applyTo(distance, lane);
		
		assertThat(result.getWidth(), is(expectedX));
	}
	
	@Test
	public void shouldRoundYResult()
	{
		when(yTransform.applyTo(distance, lane)).thenReturn(unroundedY);
		
		Dimension result = underTest.applyTo(distance, lane);
		
		assertThat(result.getHeight(), is(expectedY));
	}
	
//	@Test
//	public void shouldReturn10And5()
//	{
//		underTest = new ParallelogramTransformFunction(0, 0, 0);
//		stubDistanceAndLane(10, 5);
//		
//		verifyResultIs(10, 5);
//	}
//	
//	@Test
//	public void shouldReturn7And9()
//	{
//		underTest = new ParallelogramTransformFunction(0, 0, 0);
//		stubDistanceAndLane(7, 9);
//		
//		verifyResultIs(7, 9);
//	}
//	
//	@Test
//	public void shouldAddXOffset()
//	{
//		underTest = new ParallelogramTransformFunction(50, 0, 0);
//		stubDistanceAndLane(7, 9);
//		
//		verifyResultIs(57, 9);
//	}
	
	
//	@Test
//	public void shouldAddYOffset()
//	{
//		underTest = new ParallelogramTransformFunction(0, 30, 0);
//		stubDistanceAndLane(7, 9);
//		
//		verifyResultIs(7, 39);
//	}
//	
//	@Test
//	public void shouldApplyLaneSkew()
//	{
//		underTest = new ParallelogramTransformFunction(0, 0, 0.5);
//		stubDistanceAndLane(10, 10);
//		
//		verifyResultIs(15, 10);
//	}
//	
//	private void verifyResultIs(int x, int y)
//	{
//		Dimension location = underTest.applyTo(distance, lane);
//		
//		assertThat(location, is(new Dimension(x, y)));
//	}
//	
//	private void stubDistanceAndLane(int distanceValue, int laneValue)
//	{
//		distance = distanceValue;
//		lane = laneValue;
//	}
}
