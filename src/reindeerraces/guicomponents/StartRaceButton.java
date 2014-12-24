package reindeerraces.guicomponents;

import javax.annotation.Resource;
import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reindeerraces.reindeer.Race;

@Component(value="startRace")
public class StartRaceButton extends JButton
{
	private static final long serialVersionUID = -410659088814962950L;

	@Resource
	private Race race;
	
	@Autowired
	public void configure()
	{
		this.addMouseListener(race);
		this.setText("Start");
	}
}
