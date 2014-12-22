package reindeerraces.track.functions; 

import static java.lang.Math.PI;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class PolarXTransformTest
{
	private int xOffset = 30;
	
	@InjectMocks
	private TwoParameterFunction underTest = new PolarXTransform(xOffset, null, null, null);
	
	@Mock
	private OneParameterFunction radiusFunction;
	
	@Mock
	private TwoParameterFunction angleCalculator;
	
	@Mock
	private TwoParameterFunction horizontalComponent;
	
	private double distance = 70.0;
	
	private double lane = 10.0;
	
	private double radius = 35.0;
	
	private double angle = PI/3;
	
	private double expectedResult = 75.23;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		when(radiusFunction.applyTo(lane)).thenReturn(radius);
		when(angleCalculator.applyTo(radius, distance)).thenReturn(angle);
		when(horizontalComponent.applyTo(radius, angle)).thenReturn(expectedResult);
	}
	
	@Test
	public void shouldTransformXCoordinate()
	{
		double result = underTest.applyTo(distance, lane);
		
		assertThat(result, is(expectedResult + xOffset));
	}
}
