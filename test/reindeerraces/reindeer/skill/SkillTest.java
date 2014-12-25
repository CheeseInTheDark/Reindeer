package reindeerraces.reindeer.skill;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.reindeer.RaceTrackLocation;


public class SkillTest
{
	private Skill underTest;
	
	@Mock
	private RaceTrackLocation location;
	
	@Mock
	private MovementBehavior movementBehavior;
	
	private String odds = "Odds";
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		underTest = new Skill(odds, movementBehavior);
	}
	
	@Test
	public void shouldReturnOdds()
	{
		assertThat(underTest.getOdds(), is(odds));
	}
	
	@Test
	public void shouldApplyMovementBehavior()
	{
		underTest.update(location);
		
		verify(location).moveUsing(movementBehavior);
	}
}
