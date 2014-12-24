package reindeerraces.reindeer.skill;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class MovementBehaviorFactory
{
	private SkillPointsGenerator generator = new SkillPointsGenerator();
	
	@Resource
	private SkillPointsToMovementConverter converter = new SkillPointsToMovementConverter();
	
	public List<MovementBehavior> generate(int reindeer)
	{
		List<Integer> skillPoints = generator.generateSkillPoints(reindeer);
		List<MovementBehavior> toReturn = new ArrayList<MovementBehavior>();
		
		for(int points : skillPoints)
		{
			toReturn.add(converter.convertFrom(points));
		}
		
		return toReturn;
	}
}
