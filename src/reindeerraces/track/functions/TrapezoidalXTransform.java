package reindeerraces.track.functions;

public class TrapezoidalXTransform implements TwoParameterFunction
{
	private int xOffset;

	private double laneSkew;
	
	public TrapezoidalXTransform(int xOffset, double laneSkew)
	{
		this.xOffset = xOffset; 
		this.laneSkew = laneSkew;
	}

	@Override
	public double applyTo(double distance, double lane)
	{
		return distance + xOffset - (lane * laneSkew);
	}

}
