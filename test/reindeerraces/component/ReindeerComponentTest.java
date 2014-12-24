package reindeerraces.component;

import static org.mockito.Mockito.verify;

import java.awt.Graphics;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeerraces.reindeer.Reindeer;
import reindeerraces.reindeer.Reindeers;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestReindeerConfiguration.class})
public class ReindeerComponentTest
{
	@Resource
	private Reindeers underTest;
	
	@Resource(name="redReindeer")
	private Reindeer redReindeer;
	
	@Resource(name="blueReindeer")
	private Reindeer blueReindeer;
	
	@Resource(name="greenReindeer")
	private Reindeer greenReindeer;
	
	@Resource(name="yellowReindeer")
	private Reindeer yellowReindeer;
	
	@Resource(name="purpleReindeer")
	private Reindeer purpleReindeer;
	
	@Resource(name="pinkReindeer")
	private Reindeer pinkReindeer;
	
	@Mock
	private Graphics canvas;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldDrawSixReindeer()
	{
		underTest.drawOn(canvas);
		
		verify(redReindeer).drawOn(canvas);
		verify(greenReindeer).drawOn(canvas);
		verify(yellowReindeer).drawOn(canvas);
		verify(pinkReindeer).drawOn(canvas);
		verify(blueReindeer).drawOn(canvas);
		verify(purpleReindeer).drawOn(canvas);
	}
}
