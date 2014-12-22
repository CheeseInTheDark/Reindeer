package reindeerraces.track.functions;

import static java.lang.Math.cos;

public class HorizontalComponent implements TwoParameterFunction
{

	@Override
	public double applyTo(double input, double angle)
	{
		return input * cos(angle);
	}

}
