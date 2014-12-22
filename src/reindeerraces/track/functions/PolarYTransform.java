package reindeerraces.track.functions;

public class PolarYTransform implements TwoParameterFunction
{

	private OneParameterFunction radiusFunction;
	
	private TwoParameterFunction angleCalculator;
	
	private TwoParameterFunction verticalComponent;
	
	private int yOffset;
	
	public PolarYTransform(int yOffset, RadiusOffset radiusOffset, ArcToAngle arcToAngle, VerticalComponent verticalComponent2)
	{
		this.yOffset = yOffset;
		this.radiusFunction = radiusOffset;
		this.angleCalculator = arcToAngle;
		this.verticalComponent = verticalComponent2;
	}

	@Override
	public double applyTo(double distance, double lane)
	{
		double radius = radiusFunction.applyTo(lane);
		double angle = angleCalculator.applyTo(distance, lane);
		
		return yOffset + radius - verticalComponent.applyTo(radius, angle);
	}

}
