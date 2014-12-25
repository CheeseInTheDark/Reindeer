package reindeerraces.component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsArrayContaining.hasItemInArray;

import java.awt.Dimension;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeerraces.configuration.ReindeerLauncherConfiguration;
import reindeerraces.reindeer.Reindeer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class ReindeerInfoComponentTest
{
	@Resource(name="reindeerInfo")
	private JScrollPane underTest;
	
	@Resource(name="reindeerTable")
	private JTable reindeerTable;
	
	@Resource(name="reindeerTableModel")
	private TableModel reindeerTableModel;
	
	@Resource
	private List<Reindeer> reindeerList;
	
	@Test
	public void shouldHaveReindeerTableAsChild()
	{
		assertThat(underTest.getViewport().getComponents(), hasItemInArray(reindeerTable));
	}
	
	@Test
	public void shouldHaveReindeerModel()
	{
		assertThat(reindeerTable.getModel(), is(reindeerTableModel));
	}
	
	@Test
	public void shouldSetViewPortFill()
	{
		assertThat(reindeerTable.getFillsViewportHeight(), is(true));
	}
	
	@Test
	public void shouldSetPreferredSize()
	{
		assertThat(reindeerTable.getPreferredScrollableViewportSize(), is(new Dimension(500, 100)));
	}
	
	@Test
	public void shouldSetReindeers()
	{
		assertThat(reindeerTableModel.getRowCount(), is(reindeerList.size()));
	}
}
