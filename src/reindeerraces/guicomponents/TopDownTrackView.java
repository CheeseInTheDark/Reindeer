package reindeerraces.guicomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reindeerraces.reindeer.Reindeers;

@Component("topDownTrackView")
public class TopDownTrackView extends JPanel
{
	@Resource(name="trackImage")
	private BufferedImage trackImage;
	
	private Reindeers reindeers;
	
	private static final long serialVersionUID = 6096019962582538858L;
	
	@Autowired
	public void configureTopDownTrackView(Reindeers reindeers)
	{
		this.reindeers = reindeers;
		
		Dimension preferredSize = new Dimension(trackImage.getWidth(), trackImage.getHeight());
		setPreferredSize(preferredSize);
	}
	
	@Override
	public void paint(Graphics canvas)
	{
		int width = trackImage.getWidth();
		int height = trackImage.getHeight();
		
		canvas.drawImage(trackImage, 0, 0, width, height, Color.WHITE, null);
		
		reindeers.drawOn(canvas);
	}
}
