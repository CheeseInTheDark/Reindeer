package reindeerraces.reindeer.skill;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class SkillPointsToOddsConverter
{
	@Resource(name="oddsMapping")
	private Map<Integer, String> oddsMapping;
	
	public String convertFrom(int skillPoints) 
	{
		return oddsMapping.get(skillPoints);
	}
}
