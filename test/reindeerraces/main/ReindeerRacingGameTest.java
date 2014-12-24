package reindeerraces.main;

import static org.mockito.Mockito.verify;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.reindeer.Reindeers;


public class ReindeerRacingGameTest
{
	@InjectMocks
	private ReindeerRacingGame underTest;
	
	@Mock
	private JFrame window;
	
	@Mock
	private UpdaterThread updaterThread;
	
	@Mock
	private Reindeers reindeers;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldDisplayWindow()
	{
		underTest.launch();
		
		verify(window).setVisible(true);
	}
	
	@Test
	public void shouldScrambleReindeerOdds()
	{
		underTest.launch();
		
		verify(reindeers).scrambleReindeerOdds();
	}
	
	@Test
	public void shouldStartUpdaterThread()
	{
		underTest.launch();
		
		verify(updaterThread).start();
	}
}
