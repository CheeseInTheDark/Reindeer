package reindeer;

import static java.util.Arrays.asList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("topDownTrackView")
public class TopDownTrackView extends JPanel
{
	@Resource(name="trackImage")
	private BufferedImage trackImage;
	
	private List<Reindeer> reindeers;
	
	private static final long serialVersionUID = 6096019962582538858L;
	
	@Autowired
	public void configureTopDownTrackView(Reindeer reindeer)
	{
		reindeers = asList(reindeer);
		
		Dimension preferredSize = new Dimension(trackImage.getWidth(), trackImage.getHeight());
		setPreferredSize(preferredSize);
	}
	
	@Override
	public void paint(Graphics canvas)
	{
		int width = trackImage.getWidth();
		int height = trackImage.getHeight();
		
		canvas.drawImage(trackImage, 0, 0, width, height, Color.WHITE, null);
		
		for(Reindeer reindeer : nullsafe(reindeers))
		{
			reindeer.drawOn(canvas);
		}
	}

	private List<Reindeer> nullsafe(List<Reindeer> reindeer)
	{
		return reindeer != null ? reindeer : new ArrayList<Reindeer>();
	}

	public void setReindeer(List<Reindeer> reindeers)
	{
		this.reindeers = reindeers;
	}
}
