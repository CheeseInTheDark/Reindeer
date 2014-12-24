package reindeerraces.reindeer;

import java.util.Random;

public class RandomRange
{
	private Random random;
	
	private double minimumValue;
	
	private double maximumValue;
	
	public RandomRange(Random random, double minimumValue, double maximumValue) 
	{
		this.random = random;
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
	}

	public double next()
	{
		return (maximumValue - minimumValue) * random.nextDouble() + minimumValue;
	}

}
