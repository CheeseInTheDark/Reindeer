package reindeer.component;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.annotation.Resource;
import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import reindeer.ReindeerLauncherConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ReindeerLauncherConfiguration.class})
public class TopDownTrackViewComponentTest
{
	@Resource(name="topDownViewContainer")
	private JPanel underTest;
	
	@Resource(name="trackImage")
	private BufferedImage trackImage;
	
	@Mock
	private Graphics canvas;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldPaint()
	{
		underTest.paint(canvas);
		
		verify(canvas).drawImage(eq(trackImage), Matchers.anyInt(), Matchers.anyInt(), Matchers.anyInt(), Matchers.anyInt(), any(Color.class), eq(null));
	}
}
