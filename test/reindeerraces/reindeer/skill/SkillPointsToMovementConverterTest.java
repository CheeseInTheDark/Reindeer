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


public class SkillPointsToMovementConverterTest
{
	@InjectMocks
	private SkillPointsToMovementConverter underTest;
	
	@Mock
	private Map<Integer, MovementBehavior> skillToMovementMap;
	
	@Mock
	private MovementBehavior expectedMovementBehavior;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		when(skillToMovementMap.get(4)).thenReturn(expectedMovementBehavior);
	}
	
	@Test
	public void shouldGetMapValue()
	{
		MovementBehavior behavior = underTest.convertFrom(4);
		
		assertThat(behavior, is(expectedMovementBehavior));
	}
}
