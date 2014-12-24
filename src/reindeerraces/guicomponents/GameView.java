package reindeerraces.guicomponents;

import java.awt.Dimension;

import javax.annotation.Resource;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="gameView")
public class GameView extends JPanel
{
	private static final long serialVersionUID = -1572676903507466269L;

	@Resource(name="topDownTrackView")
	private JPanel topDownTrackView;
	
	@Resource(name="startRace")
	private JButton startRace;
	
	@Autowired
	public void configure()
	{
		this.add(topDownTrackView);
		this.add(startRace);
		
		this.setPreferredSize(new Dimension(600, 460));
	}
}
