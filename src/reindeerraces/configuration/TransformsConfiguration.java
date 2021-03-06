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
		TrapezoidalXTransform xTransform = new TrapezoidalXTransform(116, 0);
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
		
		PolarXTransform xTransform = new PolarXTransform(457, radiusOffset, arcToAngle, horizontalComponent);
		PolarYTransform yTransform = new PolarYTransform(128, radiusOffset, arcToAngle, verticalComponent);
		
		return new LocationFunction(xTransform, yTransform);
	}
	
	@Bean(name="secondStraightTopDownFunction")
	public LocationFunction secondStraightFunction()
	{
		InvertedTransform xTransform = new InvertedTransform(new TrapezoidalXTransform(457, 0));
		InvertedTransform yTransform = new InvertedTransform(new TrapezoidalYTransform(78));
		
		return new LocationFunction(xTransform, yTransform);
	}
	
	@Bean(name="secondCurveTopDownFunction")
	public LocationFunction secondCurveTopDownFunction()
	{
		RadiusOffset radiusOffset = new RadiusOffset(49.5);
		ArcToAngle arcToAngle = new ArcToAngle(PI/2);
		HorizontalComponent horizontalComponent = new HorizontalComponent();
		VerticalComponent verticalComponent = new VerticalComponent();
		
		PolarXTransform xTransform = new PolarXTransform(140, radiusOffset, arcToAngle, horizontalComponent);
		PolarYTransform yTransform = new PolarYTransform(128, radiusOffset, arcToAngle, verticalComponent);
		
		return new LocationFunction(xTransform, yTransform);
	}
	
	@Bean(name="thirdStraightTopDownFunction")
	public LocationFunction thirdStraightTopDownFunction()
	{
		TrapezoidalXTransform xTransform = new TrapezoidalXTransform(140, 0);
		TrapezoidalYTransform yTransform = new TrapezoidalYTransform(178);
		
		return new LocationFunction(xTransform, yTransform);		
	}
	
}
