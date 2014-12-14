package reindeer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component("topDownViewContainer")
public class TopDownTrackView extends JPanel
{
	@Resource(name="trackImage")
	private BufferedImage trackImage;
	
	private static final long serialVersionUID = 6096019962582538858L;
	
	@Override
	public void paint(Graphics canvas)
	{
		int width = trackImage.getWidth();
		int height = trackImage.getHeight();
		
		canvas.drawImage(trackImage, 0, 0, width, height, Color.WHITE, null);
	}
}
