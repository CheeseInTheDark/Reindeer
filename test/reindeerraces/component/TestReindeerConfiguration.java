package reindeerraces.component;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import reindeerraces.configuration.ReindeerLauncherConfiguration;
import reindeerraces.reindeer.Reindeer;

@Configuration
@Import(ReindeerLauncherConfiguration.class)
public class TestReindeerConfiguration
{
	@Bean(name="redReindeer")
	public Reindeer redReindeer()
	{
		return mock(Reindeer.class);
	}
	
	@Bean(name="blueReindeer")
	public Reindeer blueReindeer()
	{
		return mock(Reindeer.class);
	}
	
	@Bean(name="greenReindeer")
	public Reindeer greenReindeer()
	{
		return mock(Reindeer.class);
	}
	
	@Bean(name="pinkReindeer")
	public Reindeer pinkReindeer()
	{
		return mock(Reindeer.class);
	}
	
	@Bean(name="yellowReindeer")
	public Reindeer yellowReindeer()
	{
		return mock(Reindeer.class);
	}
	
	@Bean(name="purpleReindeer")
	public Reindeer purpleReindeer()
	{
		return mock(Reindeer.class);
	}
}
