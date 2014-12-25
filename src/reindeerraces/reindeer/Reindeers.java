package reindeerraces.reindeer;

import java.awt.Graphics;
import java.util.List;

import reindeerraces.reindeer.skill.Skill;
import reindeerraces.reindeer.skill.SkillFactory;

public class Reindeers
{
	private List<Reindeer> reindeerList;
	
	private SkillFactory skillFactory;
	
	public Reindeers(List<Reindeer> reindeerList, SkillFactory behaviorFactory)
	{
		this.reindeerList = reindeerList;
		this.skillFactory = behaviorFactory;
	}

	public void drawOn(Graphics canvas)
	{
		for(Reindeer reindeer : reindeerList)
		{
			reindeer.drawOn(canvas);
		}
	}

	public void update()
	{
		for(Reindeer reindeer : reindeerList)
		{
			reindeer.update();
		}
	}

	public void scrambleReindeerOdds()
	{
		List<Skill> skills = skillFactory.generate(reindeerList.size());
		
		for (int index = 0; index < reindeerList.size(); index++)
	    {
			reindeerList.get(index).setSkill(skills.get(index));
		}
	}

}
