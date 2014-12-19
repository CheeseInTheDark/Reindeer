package reindeer;

import java.awt.Dimension;

import javax.annotation.Resource;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("gameWindow")
public class GameWindow extends JFrame
{
	private static final long serialVersionUID = 1783078910378076898L;
	
	@Resource(name="topDownTrackView")
	private JPanel topDownView;
	
	@Autowired
	public void configureGameWindow()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setUpTopDownView();
		
		pack();
	}
	
	private void setUpTopDownView()
	{
		getContentPane().add(topDownView);
		getContentPane().setPreferredSize(new Dimension(1600, 1260));
	}
}
