package reindeerraces.track.functions;


public class Boundary
{
	private OneParameterFunction upperBound;
	
	private OneParameterFunction lowerBound;
	
	public Boundary(OneParameterFunction lowerBound,
			OneParameterFunction upperBound)
	{
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}

	public boolean contains(double distance, double lane)
	{
		return distance < upperBound.applyTo(lane) && 
			   distance >= lowerBound.applyTo(lane);
	}

	public double relativeDistance(double distance, double lane)
	{
		return distance - lowerBound.applyTo(lane);
	}
}
