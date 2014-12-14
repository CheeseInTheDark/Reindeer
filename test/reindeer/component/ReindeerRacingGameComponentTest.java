package reindeer.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.annotation.Resource;
import javax.swing.JFrame;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeer.ReindeerRacingGame;
import reindeer.ReindeerLauncherConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class ReindeerRacingGameComponentTest
{
	@Resource
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
