package reindeerraces.configuration;

import static java.lang.Math.PI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reindeerraces.track.functions.ArcToAngle;
import reindeerraces.track.functions.HorizontalComponent;
import reindeerraces.track.functions.InvertedTransform;
import reindeerraces.track.functions.LocationFunction;
import reindeerraces.track.functions.PolarXTransform;
import reindeerraces.track.functions.PolarYTransform;
import reindeerraces.track.functions.RadiusOffset;
import reindeerraces.track.functions.TrapezoidalXTransform;
import reindeerraces.track.functions.TrapezoidalYTransform;
import reindeerraces.track.functions.VerticalComponent;

@Configuration
public class TransformsConfiguration
{
	@Bean(name="firstStraightTopDownFunction")
	public LocationFunction firstStraightFunction()
	{
		TrapezoidalXTransform xTransform = new TrapezoidalXTransform(266, 0);
		TrapezoidalYTransform yTransform = new TrapezoidalYTransform(178);
		
		return new LocationFunction(xTransform, yTransform);
	}
	
	@Bean(name="firstCurveTopDownFunction")
	public LocationFunction firstCurveFunction()
	{
		RadiusOffset radiusOffset = new RadiusOffset(49.5);
		ArcToAngle arcToAngle = new ArcToAngle(-PI/2);
		HorizontalComponent horizontalComponent = new HorizontalComponent();
		VerticalComponent verticalComponent = new VerticalComponent();
		
		PolarXTransform xTransform = new PolarXTransform(454, radiusOffset, arcToAngle, horizontalComponent);
		PolarYTransform yTransform = new PolarYTransform(80, radiusOffset, arcToAngle, verticalComponent);
		
		return new LocationFunction(xTransform, yTransform);
	}
	
	@Bean(name="secondStraightTopDownFunction")
	public LocationFunction secondStraightFunction()
	{
		InvertedTransform xTransform = new InvertedTransform(new TrapezoidalXTransform(453, PI));
		InvertedTransform yTransform = new InvertedTransform(new TrapezoidalYTransform(51));
		
		return new LocationFunction(xTransform, yTransform);
	}
	
	@Bean(name="secondCurveTopDownFunction")
	public LocationFunction secondCurveTopDownFunction()
	{
		RadiusOffset radiusOffset = new RadiusOffset(49.5);
		ArcToAngle arcToAngle = new ArcToAngle(-PI/2);
		HorizontalComponent horizontalComponent = new HorizontalComponent();
		VerticalComponent verticalComponent = new VerticalComponent();
		
		InvertedTransform xTransform = new InvertedTransform(new PolarXTransform(141, radiusOffset, arcToAngle, horizontalComponent));
		InvertedTransform yTransform = new InvertedTransform(new PolarYTransform(177, radiusOffset, arcToAngle, verticalComponent));
		
		return new LocationFunction(xTransform, yTransform);
	}
	
	@Bean(name="thirdStraightTopDownFunction")
	public LocationFunction thirdStraightTopDownFunction()
	{
		TrapezoidalXTransform xTransform = new TrapezoidalXTransform(142, PI * 2);
		TrapezoidalYTransform yTransform = new TrapezoidalYTransform(178);
		
		return new LocationFunction(xTransform, yTransform);		
	}
	
}
