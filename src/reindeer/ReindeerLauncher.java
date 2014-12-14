package reindeer;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReindeerLauncher
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ReindeerLauncherConfiguration.class);
		context.getBean(ReindeerRacingGame.class).launch();
		context.close();
	}
}
