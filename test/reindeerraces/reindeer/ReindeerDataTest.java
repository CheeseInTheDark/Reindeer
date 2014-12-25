package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import javax.swing.ImageIcon;

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.reindeer.skill.Skill;


public class ReindeerDataTest
{
	private ReindeerData underTest;
	
	@Mock
	private ReindeerName name;
	
	private String expectedNameValue = "Name"; 
	
	@Mock
	private ImageIcon expectedIcon;
	
	@Mock
	private Skill skill;
	
	@Mock
	private Skill anotherSkill;
	
	private String expectedOddsValue = "Odds";
	
	@Mock
	private FinishPosition position;

	private String expectedPosition = "Position";
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		underTest = new ReindeerData(name, expectedIcon, skill, position);
		
		when(name.getValue()).thenReturn(expectedNameValue);
		when(skill.getOdds()).thenReturn(expectedOddsValue);
		when(position.getValue()).thenReturn(expectedPosition);
	}
	
	@Test
	public void shouldReturnName()
	{
		Object nameValue = underTest.get(0);
		
		MatcherAssert.assertThat(nameValue, is(expectedNameValue));
	}
	
	@Test
	public void shouldReturnColor()
	{
		Object icon = underTest.get(1);
		
		assertThat(icon, is(expectedIcon));
	}
	
	@Test
	public void shouldReturnOdds()
	{
		Object oddsValue = underTest.get(2);
		
		assertThat(oddsValue, is(expectedOddsValue));
	}
	
	@Test
	public void shouldReturnPosition()
	{
		Object position = underTest.get(3);
		
		assertThat(position, is(expectedPosition));
	}
	
	@Test
	public void shouldSetSkill()
	{
		when(skill.getOdds()).thenReturn(null);
		when(anotherSkill.getOdds()).thenReturn(expectedOddsValue);
		
		underTest.setSkill(anotherSkill);
		Object oddsValue = underTest.get(2);

		assertThat(oddsValue, is(expectedOddsValue));
	}
}
