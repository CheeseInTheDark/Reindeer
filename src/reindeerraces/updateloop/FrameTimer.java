package reindeerraces.updateloop;

import static java.lang.Thread.sleep;

public class FrameTimer
{
	private long frameTime;
	
	private long startTime;
	
	private long NanosecondsPerMillisecond = 1000000L; 
	
	public FrameTimer(long nanoseconds)
	{
		frameTime = nanoseconds;
	}

	public void startFrame()
	{
		startTime = System.nanoTime();
	}

	public void waitUntilExpiration()
	{
		long elapsed = startTime - System.nanoTime();
		if (elapsed < frameTime)
		{
			attemptSleep(frameTime - elapsed);
		}
	}

	private void attemptSleep(long time)
	{
		try 
		{
			sleep(1 + time/NanosecondsPerMillisecond);
		} 
		catch (InterruptedException e) {}
	}
}
