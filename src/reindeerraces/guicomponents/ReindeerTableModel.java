package reindeerraces.guicomponents;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reindeerraces.reindeer.Reindeer;

@Component(value="reindeerTableModel")
public class ReindeerTableModel extends AbstractTableModel
{
	private static final long serialVersionUID = -849297642775216941L;

	private List<Reindeer> reindeers;
	
	private String[] columnNames = { "Reindeer Name", "Color", "Odds", "Place"};
	
	@Autowired
	public ReindeerTableModel(List<Reindeer> reindeers)
	{
		this.reindeers = reindeers;
	}

	public int getColumnCount()
	{
		return columnNames.length;
	}

	public int getRowCount()
	{
		return reindeers.size();
	}

	public String getColumnName(int col)
	{
		return columnNames[col];
	}

	public Object getValueAt(int row, int col)
	{
		return reindeers.get(row).getData().get(col);
	}

	public Class<?> getColumnClass(int column)
	{
		if (column == 1)
		{
			return ImageIcon.class;
		}
		else
		{
			Object value = getValueAt(0, column);
			if (value == null)
			{
				return Object.class;
			}
			else
			{
				return value.getClass();
			}
		}
	}

	public boolean isCellEditable(int row, int col)
	{
		return false;
	}
}
