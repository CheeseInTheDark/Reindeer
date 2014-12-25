package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;


public class ReindeerNameTest 
{
	@Test
	public void shouldReturnName()
	{
		ReindeerName underTest = new ReindeerName("Bob");
		
		assertThat(underTest.getValue(), is("Bob"));
	}
}
