package reindeerraces.track.functions;

import static java.lang.Math.round;

import java.awt.Dimension;

public class LocationFunction 
{
	private TwoParameterFunction xTransform;
	
	private TwoParameterFunction yTransform;

	public LocationFunction(TwoParameterFunction xTransform, TwoParameterFunction yTransform)
	{
		this.xTransform = xTransform;
		this.yTransform = yTransform;
	}
	
	public Dimension applyTo(int distance, int lane)
	{
		int x = (int) round(xTransform.applyTo(distance, lane));
		int y = (int) round(yTransform.applyTo(distance, lane));
		
		return new Dimension(x, y);
	}
}
