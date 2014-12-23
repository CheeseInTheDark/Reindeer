package reindeerraces.main;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class StopThreadAnswer implements Answer<Thread>
{
	private Thread thread;
	
	public StopThreadAnswer(Thread thread)
	{
		this.thread = thread;
	}
	
	@Override
	public Thread answer(InvocationOnMock invocation) throws Throwable
	{
		thread.interrupt();
		
		return null;
	}

}
