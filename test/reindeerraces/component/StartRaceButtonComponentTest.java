package reindeerraces.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;

import javax.annotation.Resource;
import javax.swing.JButton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeerraces.configuration.ReindeerLauncherConfiguration;
import reindeerraces.reindeer.Race;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class StartRaceButtonComponentTest
{
	@Resource(name="startRace")
	private JButton startRaceButton;
	
	@Resource
	private Race race;
	
	@Test
	public void shouldHaveMouseActionListener()
	{
		assertThat(startRaceButton.getMouseListeners(), hasItemInArray(race));
	}
	
	@Test
	public void shouldHaveText()
	{
		assertThat(startRaceButton.getText(), is("Start"));
	}
}
