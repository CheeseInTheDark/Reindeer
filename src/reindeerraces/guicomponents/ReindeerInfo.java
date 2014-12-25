package reindeerraces.guicomponents;

import javax.annotation.Resource;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="reindeerInfo")
public class ReindeerInfo extends JScrollPane
{
	private static final long serialVersionUID = 323309904321700807L;

	@Resource(name="reindeerTable")
	private JTable reindeerTable;
	
	@Autowired
	public ReindeerInfo(ReindeerTable table)
	{
		super(table);
	}
}
