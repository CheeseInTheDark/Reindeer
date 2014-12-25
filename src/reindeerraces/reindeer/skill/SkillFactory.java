package reindeerraces.reindeer.skill;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class SkillFactory 
{
	@Resource
	private SkillPointsGenerator generator;
	
	@Resource
	private SkillPointsToOddsConverter oddsConverter;
	
	@Resource
	private SkillPointsToMovementConverter movementConverter;
	
	public List<Skill> generate(int size)
	{
		List<Skill> skills = new ArrayList<Skill>();
		
		List<Integer> points = generator.generateSkillPoints(size);
		
		for(int pointValue : points)
		{
			skills.add(createFrom(pointValue));
		}
		
		return skills;
	}
	
	private Skill createFrom(int points)
	{
		String odds = oddsConverter.convertFrom(points);
		MovementBehavior movement = movementConverter.convertFrom(points);
		
		return new Skill(odds, movement);
	}

}
