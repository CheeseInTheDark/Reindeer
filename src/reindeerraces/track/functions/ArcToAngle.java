package reindeerraces.track.functions;

public class ArcToAngle implements TwoParameterFunction
{

	private double offset;
	
	public ArcToAngle(double offset)
	{
		this.offset = offset;
	}

	@Override
	public double applyTo(double radius, double arc)
	{
		return (radius/arc) + offset;
	}

}
