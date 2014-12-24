package reindeerraces.reindeer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Race implements MouseListener
{
	private boolean active;
	
	public void start()
	{
		this.active = true;
	}

	public boolean isInProgress()
	{
		return active;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		start();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}
