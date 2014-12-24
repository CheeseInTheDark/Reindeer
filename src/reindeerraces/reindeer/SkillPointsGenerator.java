package reindeerraces.reindeer;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SkillPointsGenerator
{
	private Random random = new Random();

	private int averagePoints = 4;
	
	public List<Integer> generateSkillPoints(int values)
	{
		List<Integer> points = new ArrayList<Integer>();
		
		int remainingPoints = values * averagePoints;
		
		for (int value = 0; value < values; value++)
		{
			int skillPoints = getNext(remainingPoints);
			remainingPoints -= skillPoints;
			
			points.add(skillPoints);
		}
			
		return points;
	}

	private int getNext(int remainingPoints)
	{
		return min(remainingPoints, random.nextInt(9));
	}
	
}
