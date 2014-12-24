package reindeerraces.guicomponents;

import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("gameWindow")
public class GameWindow extends JFrame
{
	private static final long serialVersionUID = 1783078910378076898L;
	
	@Resource(name="gameView")
	private JPanel gameView;
	
	@Autowired
	public void configureGameWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setUpTopDownView();
		
		pack();
	}
	
	private void setUpTopDownView()
	{
		getContentPane().add(gameView);
		getContentPane().setPreferredSize(gameView.getPreferredSize());
	}
}
