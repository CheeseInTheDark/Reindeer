package reindeerraces.guicomponents;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.swing.ImageIcon;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.reindeer.Reindeer;
import reindeerraces.reindeer.ReindeerData;


public class ReindeerTableModelTest
{
	private ReindeerTableModel underTest;
	
	@Mock
	private Reindeer reindeer;
	
	@Mock
	private Reindeer anotherReindeer;
	
	@Mock
	private ReindeerData data;
	
	@Mock
	private Object expectedValue; 
	
	private List<Reindeer> reindeers;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		reindeers = asList(reindeer, anotherReindeer);
		underTest = new ReindeerTableModel(reindeers);
	}
	
	@Test
	public void dataShouldBeRetreivedFromReindeer()
	{
		when(reindeer.getData()).thenReturn(data);
		when(data.get(0)).thenReturn(expectedValue);
		
		Object value = underTest.getValueAt(0, 0);
		
		assertThat(value, is(expectedValue));
	}
	
	@Test
	public void dataShouldBeRetrievedFromAnotherReindeer()
	{
		when(anotherReindeer.getData()).thenReturn(data);
		when(data.get(2)).thenReturn(expectedValue);
		
		Object value = underTest.getValueAt(1, 2);
		
		assertThat(value, is(expectedValue));
	}
	
	@Test
	public void shouldReturnNumberOfRows()
	{
		int rowCount = underTest.getRowCount();
		
		assertThat(rowCount, is(reindeers.size()));
	}
	
	@Test
	public void cellsShouldNotBeEditable()
	{
		boolean editable = underTest.isCellEditable(0, 0);
		
		assertThat(editable, is(false));
	}
	
	@Test
	public void shouldHaveFourColumns()
	{
		int count = underTest.getColumnCount();
		
		assertThat(count, is(4));
	}
	
	@Test
	public void secondColumnShouldBeAnIconImage()
	{
		Class<?> classType = underTest.getColumnClass(1);
		
		assertThat(classType, equalTo(ImageIcon.class));
	}
	
	@Test
	public void shouldReturnObjectForNullValue()
	{
		when(reindeer.getData()).thenReturn(data);
		when(data.get(0)).thenReturn(null);
		
		Class<?> classType = underTest.getColumnClass(0);
		
		assertThat(classType, equalTo(Object.class));
	}
}
