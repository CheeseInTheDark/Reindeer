package reindeerraces.track.functions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class BoundaryTest
{
	private Boundary underTest;
	
	@Mock
	private OneParameterFunction laneBoundaryUpperBound;

	@Mock
	private OneParameterFunction laneBoundaryLowerBound;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	
		underTest = new Boundary(laneBoundaryLowerBound, laneBoundaryUpperBound);
		
		when(laneBoundaryUpperBound.applyTo(5)).thenReturn(10.0);
		when(laneBoundaryLowerBound.applyTo(5)).thenReturn(2.0);
	}
	
	@Test
	public void shouldBeAboveUpperBound()
	{
		boolean result = underTest.contains(10.0, 5.0);
		
		assertThat(result, is(false));
	}
	
	@Test
	public void shouldBelowUpperBound()
	{
		boolean result = underTest.contains(9.999, 5.0);
		
		assertThat(result, is(true));
	}
	
	@Test
	public void shouldBeOnLowerBound()
	{
		boolean result = underTest.contains(2.0, 5.0);
		
		assertThat(result, is(true));
	}
	
	@Test
	public void shouldBeBelowLowerBound()
	{
		boolean result = underTest.contains(1.9, 5.0);
		
		assertThat(result, is(false));
	}
}
