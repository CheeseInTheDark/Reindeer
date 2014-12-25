package reindeerraces.reindeer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import org.springframework.stereotype.Component;

@Component
public class Race implements MouseListener
{
	private boolean active;
	
	private int nextPosition = 1;
	
	private int racers = 6;
	
	public void start()
	{
		this.active = true;
	}

	public boolean isInProgress()
	{
		return active;
	}

	public void claimPosition(FinishPosition position)
	{
		position.setValue(nextPosition);
		nextPosition++;
		
		if (nextPosition > racers)
		{
			active = false;
		}
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
