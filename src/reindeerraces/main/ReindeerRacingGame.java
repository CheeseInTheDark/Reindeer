package reindeerraces.main;

import javax.annotation.Resource;
import javax.swing.JFrame;

import org.springframework.stereotype.Component;

import reindeerraces.reindeer.Reindeers;

@Component
public class ReindeerRacingGame
{
	@Resource
	private JFrame window;
	
	@Resource
	private UpdaterThread updaterThread;
	
	@Resource
	private Reindeers reindeers;
	
	public void launch()
	{
		window.setVisible(true);
		reindeers.scrambleReindeerOdds();
		updaterThread.start();
	}
}
