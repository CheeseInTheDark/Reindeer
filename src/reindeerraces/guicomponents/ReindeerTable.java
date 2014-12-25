package reindeerraces.guicomponents;

import java.awt.Dimension;

import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="reindeerTable")
public class ReindeerTable extends JTable
{
	private static final long serialVersionUID = -3099339318652181184L;
	
	@Autowired
	public void configure(ReindeerTableModel model)
	{
		this.setModel(model);
		this.setPreferredScrollableViewportSize(new Dimension(500, 100));
		this.setFillsViewportHeight(true);
	}
}
