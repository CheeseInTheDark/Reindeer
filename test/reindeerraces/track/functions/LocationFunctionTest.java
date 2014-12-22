package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.awt.Dimension;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class LocationFunctionTest
{
	private LocationFunction underTest;
	
	@Mock
	private TwoParameterFunction xTransform;
	
	@Mock
	private TwoParameterFunction yTransform;
	
	private double lane = 10;
	
	private double distance = 12;
	
	private double anotherLane = 11;
	
	private double anotherDistance = 13;
	
	private double expectedX = 50;
	
	private double expectedY = 30;
	
	private double unroundedX = 49.9;
	
	private double unroundedY = 29.8;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);

		underTest = new LocationFunction(xTransform, yTransform);
		
		when(xTransform.applyTo(distance, lane)).thenReturn(expectedX);
		when(yTransform.applyTo(distance, lane)).thenReturn(expectedY);
		
		when(xTransform.applyTo(anotherDistance, anotherLane)).thenReturn(unroundedX);
		when(yTransform.applyTo(anotherDistance, anotherLane)).thenReturn(unroundedY);
	}
	
	@Test
	public void shouldReturnXResult()
	{
		Dimension result = underTest.applyTo(distance, lane);
		
		assertThat(result.getWidth(), is(expectedX));
	}
	
	@Test
	public void shouldReturnYResult()
	{
		Dimension result = underTest.applyTo(distance, lane);
		
		assertThat(result.getHeight(), is(expectedY));
	}
	
	@Test
	public void shouldRoundXResult()
	{
		Dimension result = underTest.applyTo(anotherDistance, anotherLane);
		
		assertThat(result.getWidth(), is(expectedX));
	}
	
	@Test
	public void shouldRoundYResult()
	{
		Dimension result = underTest.applyTo(anotherDistance, anotherLane);
		
		assertThat(result.getHeight(), is(expectedY));
	}

}
