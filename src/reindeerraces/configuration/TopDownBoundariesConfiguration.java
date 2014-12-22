package reindeerraces.configuration;

import static java.lang.Math.PI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import reindeerraces.track.functions.Boundary;
import reindeerraces.track.functions.LinearFunction;
import reindeerraces.track.functions.OneParameterFunction;

@Configuration
@Component
public class TopDownBoundariesConfiguration
{
	@Bean(name="firstStraightTopDownBoundaries")
	public Boundary firstStraightTopDownBoundaries()
	{
		OneParameterFunction leftBound = new LinearFunction(-200, 0);
		OneParameterFunction rightBound = new LinearFunction(188, 0);
		
		return new Boundary(leftBound, rightBound);
	}
	
	@Bean(name="firstCurveTopDownBoundaries")
	public Boundary firstCurveTopDownBoundaries()
	{
		OneParameterFunction lowBound = new LinearFunction(188, 0);
		OneParameterFunction topBound = new LinearFunction(343.508836353, PI);
		
		return new Boundary(lowBound, topBound);
	}
	
	@Bean(name="secondStraightTopDownBoundaries")
	public Boundary secondStraightTopDownBoundaries()
	{
		OneParameterFunction rightBound = new LinearFunction(343.508836353, PI);
		OneParameterFunction leftBound = new LinearFunction(657.508836353, PI);
		
		return new Boundary(rightBound, leftBound);
	}
	
	@Bean(name="secondCurveTopDownBoundaries")
	public Boundary secondCurveTopDownBoundaries()
	{
		OneParameterFunction topBound = new LinearFunction(657.508836353, PI);
		OneParameterFunction lowBound = new LinearFunction(813.017672706, PI * 2);
		
		return new Boundary(topBound, lowBound);
	}
	
	@Bean(name="thirdStraightTopDownBoundaries")
	public Boundary thirdStraightTopDownBoundaries()
	{
		OneParameterFunction leftBound = new LinearFunction(813.017672706, PI * 2);
		OneParameterFunction rightBound = new LinearFunction(3000, PI * 2);
		
		return new Boundary(leftBound, rightBound);
	}
}