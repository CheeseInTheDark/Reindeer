package reindeerraces.reindeer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import reindeerraces.guicomponents.ReindeerTableModel;

@Component
public class Race implements MouseListener
{
	private boolean active;
	
	private int nextPosition = 1;
	
	private int racers = 6;
	
	@Resource
	private ReindeerTableModel model;
	
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
		
		model.fireTableDataChanged();

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
