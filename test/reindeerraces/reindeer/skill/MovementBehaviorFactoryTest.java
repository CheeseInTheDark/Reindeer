package reindeerraces.reindeer.skill;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class MovementBehaviorFactoryTest
{
	@InjectMocks
	private MovementBehaviorFactory underTest;
	
	@Mock
	private RandomRange random;
	
	@Mock
	private MovementBehavior firstBehavior;
	
	@Mock
	private MovementBehavior secondBehavior;
	
	@Mock
	private SkillPointsToMovementConverter converter;
	
	@Mock
	private SkillPointsGenerator generator;

	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldCreateOneReindeerBehavior()
	{
		when(generator.generateSkillPoints(1)).thenReturn(asList(4));
		when(converter.convertFrom(4)).thenReturn(firstBehavior);
		
		List<MovementBehavior> behaviors = underTest.generate(1);
		
		assertThat(behaviors, contains(firstBehavior));
	}
	
	@Test
	public void shouldCreateTwoReindeerBehaviors()
	{
		when(generator.generateSkillPoints(2)).thenReturn(asList(2, 6));
		when(converter.convertFrom(2)).thenReturn(firstBehavior);
		when(converter.convertFrom(6)).thenReturn(secondBehavior);
		
		List<MovementBehavior> behaviors = underTest.generate(2);
		
		assertThat(behaviors, contains(firstBehavior, secondBehavior));
	}
}
