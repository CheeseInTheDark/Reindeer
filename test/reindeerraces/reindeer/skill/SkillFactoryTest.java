package reindeerraces.reindeer.skill;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.reindeer.RaceTrackLocation;


public class SkillFactoryTest
{
	@InjectMocks
	private SkillFactory underTest;
	
	@Mock
	private SkillPointsGenerator generator;
	
	@Mock
	private SkillPointsToOddsConverter oddsConverter;
	
	private String expectedOdds = "Odds";
	
	private String otherExpectedOdds = "Other Odds";
	
	@Mock
	private SkillPointsToMovementConverter movementConverter;

	@Mock
	private MovementBehavior expectedMovementBehavior;
	
	@Mock
	private RaceTrackLocation location;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldPopulateOdds()
	{
		when(generator.generateSkillPoints(1)).thenReturn(asList(4));
		when(oddsConverter.convertFrom(4)).thenReturn(expectedOdds);
		
		List<Skill> result = underTest.generate(1);
		
		assertThat(result.get(0).getOdds(), is(expectedOdds));
	}
	
	@Test
	public void shouldPopulateDifferentOdds()
	{
		when(generator.generateSkillPoints(1)).thenReturn(asList(5));
		when(oddsConverter.convertFrom(5)).thenReturn(otherExpectedOdds);
		
		List<Skill> result = underTest.generate(1);
		
		assertThat(result.get(0).getOdds(), is(otherExpectedOdds));
	}
	
	@Test
	public void shouldPopulateMovementBehavior()
	{
		when(generator.generateSkillPoints(1)).thenReturn(asList(4));
		when(movementConverter.convertFrom(4)).thenReturn(expectedMovementBehavior);
		
		List<Skill> result = underTest.generate(1);
		
		result.get(0).update(location);
		
		verify(location).moveUsing(expectedMovementBehavior);
	}
	
	@Test
	public void shouldReturnMulipleSkills()
	{
		when(generator.generateSkillPoints(2)).thenReturn(asList(4, 4));
		when(movementConverter.convertFrom(4)).thenReturn(expectedMovementBehavior);
		when(oddsConverter.convertFrom(4)).thenReturn(expectedOdds);
		
		List<Skill> result = underTest.generate(2);
		
		assertThat(result.size(), is(2));
	}
}
