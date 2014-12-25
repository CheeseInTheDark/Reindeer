package reindeerraces.reindeer.skill;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class SkillPointsToOddsConverterTest
{
	@InjectMocks
	private SkillPointsToOddsConverter underTest;
	
	@Mock
	private Map<Integer, String> oddsMapping;
	
	private String expectedOdds = "Odds";
	
	private String otherExpectedOdds = "Other Odds";
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldConvertPointsToOdds()
	{
		when(oddsMapping.get(4)).thenReturn(expectedOdds);
		
		String odds = underTest.convertFrom(4);
		
		assertThat(odds, is(expectedOdds));
	}
	
	@Test
	public void shouldConvertPointsToOtherOdds()
	{
		when(oddsMapping.get(4)).thenReturn(otherExpectedOdds);
		
		String odds = underTest.convertFrom(4);
		
		assertThat(odds, is(otherExpectedOdds));
	}
}
