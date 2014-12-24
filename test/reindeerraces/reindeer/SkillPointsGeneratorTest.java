package reindeerraces.reindeer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class SkillPointsGeneratorTest
{
	@Mock
	private Random random;
	
	@InjectMocks
	private SkillPointsGenerator underTest;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnFour()
	{
		when(random.nextInt(9)).thenReturn(4);
		
		List<Integer> points = underTest.generateSkillPoints(1);
		
		assertThat(points, contains(4));
	}
	
	@Test
	public void shouldReturnTwoAndSix()
	{
		when(random.nextInt(9)).thenReturn(2).thenReturn(6);
		
		List<Integer> points = underTest.generateSkillPoints(2);
		
		assertThat(points, contains(2, 6));
	}
	
	@Test
	public void shouldReturnFourForWrongRandomValue()
	{
		when(random.nextInt(9)).thenReturn(6);
		
		List<Integer> points = underTest.generateSkillPoints(1);
				
		assertThat(points, contains(4));
	}
	
	@Test
	public void shouldLeaveEnoughPointsForRemainingAssignments()
	{
		when(random.nextInt(9)).thenReturn(8).thenReturn(8);
		
		List<Integer> points = underTest.generateSkillPoints(2);
		
		assertThat(points, contains(8, 0));
	}
}
