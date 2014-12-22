package reindeerraces.track.functions;

public class RadiusOffset implements OneParameterFunction
{

	private double radius;
	
	public RadiusOffset(double radius)
	{
		this.radius = radius;
	}

	@Override
	public double applyTo(double toAdd)
	{
		return radius + toAdd;
	}

}
