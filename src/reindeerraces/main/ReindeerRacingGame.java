package reindeerraces.main;

import javax.annotation.Resource;
import javax.swing.JFrame;

import org.springframework.stereotype.Component;

@Component
public class ReindeerRacingGame
{
	@Resource
	private JFrame window;
	
	public void launch()
	{
		window.setVisible(true);
	}
}
