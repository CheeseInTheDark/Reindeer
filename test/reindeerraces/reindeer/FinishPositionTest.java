package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


public class FinishPositionTest
{
	@Test
	public void shouldGetValue()
	{
		FinishPosition underTest = new FinishPosition();
		
		underTest.setValue(3);
		
		String result = underTest.getValue();
		
		assertThat(result, is("3"));
	}
}
