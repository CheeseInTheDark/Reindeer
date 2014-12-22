package reindeerraces.track.functions;

public class LinearFunction implements OneParameterFunction {

	private double intercept;
	
	private double slope;
	
	public LinearFunction(double intercept, double slope)
	{
		this.intercept = intercept;
		this.slope = slope;
	}

	@Override
	public double applyTo(double x)
	{
		return intercept + x * slope;
	}

}
