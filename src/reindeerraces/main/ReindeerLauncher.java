package reindeerraces.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import reindeerraces.configuration.ReindeerLauncherConfiguration;

public class ReindeerLauncher
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ReindeerLauncherConfiguration.class);
		context.getBean(ReindeerRacingGame.class).launch();
		context.close();
	}
}
