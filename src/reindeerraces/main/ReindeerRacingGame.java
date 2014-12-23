package reindeerraces.main;

import javax.annotation.Resource;
import javax.swing.JFrame;

import org.springframework.stereotype.Component;

@Component
public class ReindeerRacingGame
{
	@Resource
	private JFrame window;
	
	@Resource
	private UpdaterThread updaterThread;
	
	public void launch()
	{
		window.setVisible(true);
		updaterThread.start();
	}
}
