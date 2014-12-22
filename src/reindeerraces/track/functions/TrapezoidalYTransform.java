package reindeerraces.track.functions;

public class TrapezoidalYTransform implements TwoParameterFunction
{
	int yOffset;
	
	public TrapezoidalYTransform(int yOffset)
	{
		this.yOffset = yOffset;
	}

	@Override
	public double applyTo(double distance, double lane)
	{
		return lane + yOffset;
	}

}
