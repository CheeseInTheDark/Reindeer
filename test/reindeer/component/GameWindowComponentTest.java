package reindeer.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeer.ReindeerLauncherConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class GameWindowComponentTest
{
	@Resource(name="gameWindow")
	private JFrame gameWindow;
	
	@Resource(name="topDownTrackView")
	private JPanel topDownView;
	
	@Test
	public void shouldHaveTopDownRaceTrackView()
	{
		assertThat(gameWindow.getContentPane().getComponent(0), is(topDownView));
	}
	
	@Test
	public void shouldPackWindow()
	{
		assertThat(gameWindow.getContentPane().getSize(), is(topDownView.getPreferredSize()));
	}
	
	@Test
	public void shouldExitOnClose()
	{
		assertThat(gameWindow.getDefaultCloseOperation(), is(JFrame.EXIT_ON_CLOSE));
	}
}
