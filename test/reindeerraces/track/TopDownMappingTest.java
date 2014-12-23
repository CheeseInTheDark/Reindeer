package reindeerraces.track;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import reindeerraces.reindeer.Distance;
import reindeerraces.reindeer.Lane;
import reindeerraces.track.functions.Transform;


public class TopDownMappingTest
{
	@InjectMocks
	private TopDownMapping underTest;
	
	@Spy
	private List<Transform> transforms = new ArrayList<Transform>();
	
	@Mock
	private Lane lane; 
	
	@Mock
	private Distance distance;
	
	@Mock
	private Dimension expectedLocation;
	
	@Mock
	private Transform firstTransform;
	
	@Mock
	private Transform secondTransform;
	
	@Mock
	private Transform thirdTransform;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		transforms.add(firstTransform);
		transforms.add(secondTransform);
		transforms.add(thirdTransform);
	}
	
	@Test
	public void shouldMapUsingSecondTransform() 
	{
		when(secondTransform.applyTo(distance, lane)).thenReturn(expectedLocation);
		
		Dimension location = underTest.map(distance, lane);
		
		assertThat(location, is(expectedLocation));
	}
	
	@Test
	public void shouldMapUsingThirdTransform()
	{
		when(thirdTransform.applyTo(distance, lane)).thenReturn(expectedLocation);
		
		Dimension location = underTest.map(distance, lane);
		
		assertThat(location, is(expectedLocation));
	}
	
	@Test
	public void shouldReturnNullIfNoTransformsApply()
	{
		Dimension location = underTest.map(distance, lane);
		
		assertThat(location, is(nullValue()));
	}
}
