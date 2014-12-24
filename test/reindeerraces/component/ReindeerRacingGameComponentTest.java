package reindeerraces.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

import javax.annotation.Resource;
import javax.swing.JFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeerraces.configuration.ReindeerLauncherConfiguration;
import reindeerraces.main.ReindeerRacingGame;
import reindeerraces.main.UpdaterThread;
import reindeerraces.reindeer.Reindeers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class ReindeerRacingGameComponentTest
{
	@Resource(name="gameWindow")
	private JFrame window;
	
	@Resource
	private ReindeerRacingGame game;
	
	@Resource
	private UpdaterThread updaterThread;
	
	@Test
	public void shouldShowWindow()
	{
		game.launch();
		
		assertThat(window.isVisible(), is(true));
		
		updaterThread.interrupt();
	}
}
