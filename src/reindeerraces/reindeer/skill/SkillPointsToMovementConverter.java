package reindeerraces.reindeer.skill;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class SkillPointsToMovementConverter
{
	@Resource(name="skillPointsMapping")
	private Map<Integer, MovementBehavior> mapping;
	
	public MovementBehavior convertFrom(int skillPoints)
	{
		return mapping.get(skillPoints);
	}

}
