package reindeerraces.updateloop;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import reindeerraces.guicomponents.ReindeerTableModel;
import reindeerraces.guicomponents.TopDownTrackView;
import reindeerraces.reindeer.Reindeers;

@Component
public class UpdaterThread extends Thread
{
	@Resource
	private Reindeers reindeers;

	@Resource
	private TopDownTrackView trackView;
	
	@Resource
	private ReindeerTableModel data;
	
	private FrameTimer frameTimer = new FrameTimer(12500000L);
	
	@Override
	public synchronized void run()
	{
		do
		{
			frameTimer.startFrame();
			reindeers.update();
			trackView.repaint(0);
			frameTimer.waitUntilExpiration();
		}
		while (!interrupted());
		
		notify();
	}
	
    public synchronized void waitForDeath() throws InterruptedException
    {
        while (isAlive())
        {
            wait();
        }
    }
}
