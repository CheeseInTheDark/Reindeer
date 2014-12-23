package reindeerraces.configuration;

import static java.lang.Math.PI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reindeerraces.track.functions.Boundary;
import reindeerraces.track.functions.LinearFunction;
import reindeerraces.track.functions.OneParameterFunction;

@Configuration
public class TopDownBoundariesConfiguration
{
	@Bean(name="firstStraightTopDownBoundaries")
	public Boundary firstStraightTopDownBoundaries()
	{
		OneParameterFunction leftBound = new LinearFunction(-150, 0);
		OneParameterFunction rightBound = new LinearFunction(190, 0);
		
		return new Boundary(leftBound, rightBound);
	}
	
	@Bean(name="firstCurveTopDownBoundaries")
	public Boundary firstCurveTopDownBoundaries()
	{
		OneParameterFunction lowBound = new LinearFunction(190, 0);
		OneParameterFunction topBound = new LinearFunction(345.508836353, PI);
		
		return new Boundary(lowBound, topBound);
	}
	
	@Bean(name="secondStraightTopDownBoundaries")
	public Boundary secondStraightTopDownBoundaries()
	{
		OneParameterFunction rightBound = new LinearFunction(345.508836353, PI);
		OneParameterFunction leftBound = new LinearFunction(663.508836353, PI);
		
		return new Boundary(rightBound, leftBound);
	}
	
	@Bean(name="secondCurveTopDownBoundaries")
	public Boundary secondCurveTopDownBoundaries()
	{
		OneParameterFunction topBound = new LinearFunction(663.508836353, PI);
		OneParameterFunction lowBound = new LinearFunction(819.017672706, PI * 2);
		
		return new Boundary(topBound, lowBound);
	}
	
	@Bean(name="thirdStraightTopDownBoundaries")
	public Boundary thirdStraightTopDownBoundaries()
	{
		OneParameterFunction leftBound = new LinearFunction(819.017672706, PI * 2);
		OneParameterFunction rightBound = new LinearFunction(3000, PI * 2);
		
		return new Boundary(leftBound, rightBound);
	}
}