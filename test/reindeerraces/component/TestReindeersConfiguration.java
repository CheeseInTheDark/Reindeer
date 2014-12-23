package reindeerraces.component;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import reindeerraces.configuration.ReindeerLauncherConfiguration;
import reindeerraces.reindeer.Reindeers;

@Configuration
@Import(ReindeerLauncherConfiguration.class)
public class TestReindeersConfiguration
{
	@Bean(name="reindeers")
	public Reindeers reindeers()
	{
		return mock(Reindeers.class);
	}
}
