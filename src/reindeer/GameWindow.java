package reindeer;

import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("gameWindow")
public class GameWindow extends JFrame
{
	private static final long serialVersionUID = 1783078910378076898L;
	
	@Resource(name="topDownViewContainer")
	private JPanel topDownView;
	
	@Autowired
	public void ConfigureGameWindow()
	{
		getContentPane().add(topDownView);
		this.setSize(616, 301);
	}
}
