package reindeerraces.configuration;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import reindeerraces.track.functions.Boundary;
import reindeerraces.track.functions.LocationFunction;
import reindeerraces.track.functions.Transform;

@Configuration
@Component
public class TopDownTransformsConfiguration
{
	@Resource(name="firstStraightTopDownFunction")
	private LocationFunction firstStraightTopDownFunction;
	
	@Resource(name="firstStraightTopDownBoundaries")
	private Boundary firstStraightTopDownBounds;
	
	@Resource(name="firstCurveTopDownFunction")
	private LocationFunction firstCurveTopDownFunction;
	
	@Resource(name="firstCurveTopDownBoundaries")
	private Boundary firstCurveTopDownBounds;
	
	@Resource(name="secondStraightTopDownFunction")
	private LocationFunction secondStraightTopDownFunction;
	
	@Resource(name="secondStraightTopDownBoundaries")
	private Boundary secondStraightTopDownBounds;

	@Resource(name="secondCurveTopDownFunction")
	private LocationFunction secondCurveTopDownFunction;
	
	@Resource(name="secondCurveTopDownBoundaries")
	private Boundary secondCurveTopDownBoundary;
	
	@Resource(name="thirdStraightTopDownFunction")
	private LocationFunction thirdStraightTopDownFunction;
	
	@Resource(name="thirdStraightTopDownBoundaries")
	private Boundary thirdStraightTopDownBoundary;
	
	@Bean(name="topDownTransforms")
	public List<Transform> topDownTransforms()
	{
		List<Transform> transforms = new ArrayList<Transform>();
		
		transforms.add(new Transform(firstStraightTopDownFunction, firstStraightTopDownBounds));
		transforms.add(new Transform(firstCurveTopDownFunction, firstCurveTopDownBounds));
		transforms.add(new Transform(secondStraightTopDownFunction, secondStraightTopDownBounds));
		transforms.add(new Transform(secondCurveTopDownFunction, secondCurveTopDownBoundary));
		transforms.add(new Transform(thirdStraightTopDownFunction, thirdStraightTopDownBoundary));
		
		return transforms;
	}
}
