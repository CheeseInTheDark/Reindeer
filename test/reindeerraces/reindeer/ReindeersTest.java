package reindeerraces.reindeer;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import reindeerraces.reindeer.skill.Skill;
import reindeerraces.reindeer.skill.SkillFactory;


public class ReindeersTest
{
	@InjectMocks
	private Reindeers underTest;
	
	@Mock
	private Reindeer reindeer;
	
	@Mock
	private Reindeer anotherReindeer;
	
	@Mock
	private Skill reindeerMovement;
	
	@Mock
	private Skill anotherReindeerMovement;
	
	@Mock
	private SkillFactory behaviorFactory;
	
	@Spy
	private List<Reindeer> reindeerList = new ArrayList<Reindeer>();
	
	@Mock
	private Graphics canvas;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		reindeerList.add(reindeer);
		reindeerList.add(anotherReindeer);
	}
	
	@Test
	public void shouldDrawReindeer()
	{
		underTest.drawOn(canvas);
		
		verify(reindeer).drawOn(canvas);
		verify(anotherReindeer).drawOn(canvas);
	}
	
	@Test
	public void shouldUpdateReindeer()
	{
		underTest.update();
		
		verify(reindeer).update();
		verify(anotherReindeer).update();
	}
	
	@Test
	public void shouldScrambleOdds()
	{
		when(behaviorFactory.generate(reindeerList.size())).thenReturn(asList(reindeerMovement, anotherReindeerMovement));
		
		underTest.scrambleReindeerOdds();
		
		verify(reindeer).setSkill(reindeerMovement);
		verify(anotherReindeer).setSkill(anotherReindeerMovement);
	}
}
