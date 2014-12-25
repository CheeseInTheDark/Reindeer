package reindeerraces.reindeer;

import javax.swing.ImageIcon;

import reindeerraces.reindeer.skill.Skill;

public class ReindeerData
{
	private ReindeerName name;
	
	private ImageIcon icon;
	
	private Skill skill;
	
	private FinishPosition position;
	
	public ReindeerData(ReindeerName name, ImageIcon icon,
			Skill skill, FinishPosition position)
	{
		this.name = name;
		this.icon = icon;
		this.skill = skill;
		this.position = position;
	}

	public Object get(int index)
	{
		if (index == 0)
		{
			return name.getValue();
		}
		else if (index == 1)
		{
			return icon;
		}
		else if (index == 2)
		{
			return skill.getOdds();
		}
		else
		{
			return position.getValue();
		}
	}

	public void setSkill(Skill anotherSkill)
	{
		this.skill = anotherSkill;
	}
}
