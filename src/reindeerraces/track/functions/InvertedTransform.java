package reindeerraces.track.functions;

public class InvertedTransform implements TwoParameterFunction {

	private TwoParameterFunction function;
	
	public InvertedTransform(TwoParameterFunction function)
	{
		this.function = function;
	}
	
	@Override
	public double applyTo(double x, double y)
	{
		return function.applyTo(-x, -y);
	}

}
