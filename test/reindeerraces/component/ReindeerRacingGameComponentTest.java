package reindeerraces.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.annotation.Resource;
import javax.swing.JFrame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeerraces.configuration.ReindeerLauncherConfiguration;
import reindeerraces.main.ReindeerRacingGame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class ReindeerRacingGameComponentTest
{
	@Resource(name="gameWindow")
	private JFrame window;
	
	@Resource
	private ReindeerRacingGame game;
	
	@Test
	public void shouldShowWindow()
	{
		game.launch();
		
		assertThat(window.isVisible(), is(true));
	}
}
