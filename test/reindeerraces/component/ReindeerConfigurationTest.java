package reindeerraces.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeerraces.configuration.ReindeerLauncherConfiguration;
import reindeerraces.reindeer.Reindeer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class ReindeerConfigurationTest
{
	@Resource(name="redReindeer")
	private Reindeer redReindeer;
	
	@Resource(name="blueReindeer")
	private Reindeer blueReindeer;
	
	@Resource(name="greenReindeer")
	private Reindeer greenReindeer;
	
	@Resource(name="yellowReindeer")
	private Reindeer yellowReindeer;
	
	@Resource(name="purpleReindeer")
	private Reindeer purpleReindeer;
	
	@Resource(name="pinkReindeer")
	private Reindeer pinkReindeer;
	
	@Test
	public void shouldSetReindeerData()
	{
		assertThat(redReindeer.getData(), is(notNullValue()));
		assertThat(blueReindeer.getData(), is(notNullValue()));
		assertThat(greenReindeer.getData(), is(notNullValue()));
		assertThat(yellowReindeer.getData(), is(notNullValue()));
		assertThat(purpleReindeer.getData(), is(notNullValue()));
		assertThat(pinkReindeer.getData(), is(notNullValue()));
	}
}
