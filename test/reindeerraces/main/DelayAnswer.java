package reindeerraces.main;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class DelayAnswer implements Answer {

	private long time;
	
	public DelayAnswer(long time)
	{
		this.time = time;
	}

	@Override
	public Object answer(InvocationOnMock invocation) throws Throwable
	{
		Thread.sleep(time);
		return null;
	}

}
