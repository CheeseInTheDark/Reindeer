package reindeerraces.updateloop;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

import org.hamcrest.Matchers;
import org.junit.Test;


public class FrameTimerTest
{
	private long frameTime = 50000000L;
	
	private FrameTimer underTest = new FrameTimer(frameTime);
	
	@Test
	public void oneFrameShouldTakeAtLeastOneTwentiethOfASecond() throws InterruptedException
	{
		long startTime = System.nanoTime();
		
		underTest.startFrame();
		underTest.waitUntilExpiration();
		
		assertThat(System.nanoTime() - startTime, greaterThanOrEqualTo(frameTime));
	}
}
