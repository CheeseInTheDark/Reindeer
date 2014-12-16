package reindeer;

import org.junit.Test;
import org.mockito.Mock;


public class TopDownReindeerMapperTest
{
	private TopDownReindeerMapper underTest = new TopDownReindeerMapper();
	
	@Mock
	private Reindeer reindeer;
	
	@Mock
	private RaceTrackLocation trackLocation;
	
	@Test
	public void shouldMapLocation()
	{
		underTest.mapPositionOf(reindeer);
	}
}
