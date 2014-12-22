package reindeerraces.track.functions;

public class PolarXTransform implements TwoParameterFunction
{
	private OneParameterFunction radiusFunction;
	
	private TwoParameterFunction angleCalculator;
	
	private TwoParameterFunction horizontalComponent;
	
	private int xOffset;
	
	public PolarXTransform(int xOffset, RadiusOffset radiusOffset, ArcToAngle arcToAngle, HorizontalComponent horizontalComponent2)
	{
		this.xOffset = xOffset;
		this.radiusFunction = radiusOffset;
		this.angleCalculator = arcToAngle;
		this.horizontalComponent = horizontalComponent2;
	}
	
	@Override
	public double applyTo(double distance, double lane)
	{
		double radius = radiusFunction.applyTo(lane);
		double angle = angleCalculator.applyTo(radius, distance);
		
		return horizontalComponent.applyTo(radius, angle) + xOffset;
	}
}
