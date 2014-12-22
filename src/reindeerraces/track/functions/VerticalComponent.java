package reindeerraces.track.functions;

import static java.lang.Math.sin;

public class VerticalComponent implements TwoParameterFunction
{

	@Override
	public double applyTo(double radius, double angle)
	{
		return radius*sin(angle);
	}

}
