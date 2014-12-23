package reindeerraces.main;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import reindeerraces.guicomponents.TopDownTrackView;
import reindeerraces.reindeer.Reindeers;
import reindeerraces.updateloop.FrameTimer;

public class UpdaterThreadTest
{
	@InjectMocks
	private UpdaterThread underTest;
	
	@Mock
	private Reindeers reindeers;
	
	@Mock
	private FrameTimer frameTimer;
	
	@Mock
	private TopDownTrackView topDownTrackView;
	
	private InOrder inOrder;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		
		inOrder = inOrder(frameTimer, reindeers, frameTimer);
	}
	
	@Test
	public void shouldRepaintTrackView() throws InterruptedException
	{
		doAnswer(new StopThreadAnswer(underTest)).when(frameTimer).waitUntilExpiration();
		
		underTest.start();
		underTest.waitForDeath();
		
		verify(topDownTrackView).repaint(0);
	}
	
	@Test
	public void shouldUpdateReindeer() throws InterruptedException
	{
		doAnswer(new StopThreadAnswer(underTest)).when(frameTimer).waitUntilExpiration();
		
		underTest.start();

		underTest.waitForDeath();
		
		verify(reindeers).update();
	}
	
	@Test
	public void shouldWaitUntilFrameTimeHasExpiredToContinue() throws InterruptedException
	{
		doAnswer(new StopThreadAnswer(underTest)).when(frameTimer).waitUntilExpiration();
		
		underTest.start();
		
		inOrder.verify(frameTimer).startFrame();
		inOrder.verify(reindeers).update();
		inOrder.verify(frameTimer).waitUntilExpiration();
		
		underTest.waitForDeath();
	}
	
	@Test
	public void shouldLoopUntilStopped() throws InterruptedException
	{
		doNothing().doAnswer(new StopThreadAnswer(underTest)).when(reindeers).update();
		
		underTest.start();
		
		underTest.waitForDeath();
		
		verify(reindeers, times(2)).update();
	}
}
