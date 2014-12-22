<<<<<<< HEAD:src/reindeer/GameWindow.java
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
		getContentPane().setPreferredSize(new Dimension(600, 260));
	}
}
=======
package reindeerraces.guicomponents;

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
		getContentPane().setPreferredSize(new Dimension(600, 260));
	}
}
>>>>>>> 0b70b010327ea78ea46fe09d3f8a02a0e0a6e0fe:src/reindeerraces/guicomponents/GameWindow.java