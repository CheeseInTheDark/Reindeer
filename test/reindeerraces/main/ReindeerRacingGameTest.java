package reindeerraces.main;

import static org.mockito.Mockito.verify;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import reindeerraces.main.ReindeerRacingGame;


public class ReindeerRacingGameTest
{
	@InjectMocks
	private ReindeerRacingGame underTest;
	
	@Mock
	private JFrame window;
	
	@Mock
	private UpdaterThread updaterThread;
	
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
	public void shouldStartUpdaterThread()
	{
		underTest.launch();
		
		verify(updaterThread).start();
	}

}
