package reindeerraces.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import javax.annotation.Resource;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeerraces.configuration.ReindeerLauncherConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class GameWindowComponentTest
{
	@Resource(name="gameWindow")
	private JFrame gameWindow;
	
	@Resource(name="gameView")
	private JPanel gameView;
	
	@Resource(name="topDownTrackView")
	private JPanel topDownTrackView;
	
	@Resource(name="startRace")
	private JButton startRaceButton;
	
	@Resource(name="reindeerInfo")
	private JScrollPane reindeerInfo;
	
	@Test
	public void shouldHaveGameView()
	{
		assertThat(gameWindow.getContentPane().getComponent(0), is(gameView));
	}
	
	@Test
	public void shouldPackWindow()
	{
		assertThat(gameWindow.getContentPane().getSize(), is(gameView.getPreferredSize()));
	}
	
	@Test
	public void shouldExitOnClose()
	{
		assertThat(gameWindow.getDefaultCloseOperation(), is(JFrame.EXIT_ON_CLOSE));
	}
	
	@Test
	public void shouldHaveRaceTrackViewAsSubComponent()
	{
		assertThat(gameView.getComponent(0), is(topDownTrackView));
	}
	
	@Test
	public void shouldHaveStartRaceButtonAsSubComponent()
	{
		assertThat(gameView.getComponent(1), is(startRaceButton));
	}
	
	@Test
	public void shouldHaveOddsAsSubComponent()
	{
		assertThat(gameView.getComponent(2), is(reindeerInfo));
	}
}
