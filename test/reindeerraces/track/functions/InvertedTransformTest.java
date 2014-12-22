package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class InvertedTransformTest
{
	@Mock
	private TwoParameterFunction function;
	
	@InjectMocks
	private TwoParameterFunction underTest = new InvertedTransform(null);
	
	private double distance = 7.0;
	
	private double lane = 3.5;
	
	private double functionResult = 20.0;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		when(function.applyTo(-distance, -lane)).thenReturn(functionResult);
	}
	
	@Test
	public void shouldInvert()
	{
		double result = underTest.applyTo(distance, lane);
		
		assertThat(result, closeTo(functionResult, 0.0001));
	}
}
