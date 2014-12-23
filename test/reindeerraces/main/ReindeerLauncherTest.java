package reindeerraces.main;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import reindeerraces.configuration.ReindeerLauncherConfiguration;

@RunWith(PowerMockRunner.class)
@PrepareForTest({AnnotationConfigApplicationContext.class, 
	ReindeerLauncher.class, 
	ReindeerRacingGame.class})
public class ReindeerLauncherTest
{
	@Mock
	private AnnotationConfigApplicationContext context;
	
	@Mock
	private ReindeerRacingGame game;

	@Before
	public void setup() throws Exception
	{
		whenCreatingContext().thenReturn(context);
		when(context.getBean(ReindeerRacingGame.class)).thenReturn(game);
	}
	
	private OngoingStubbing<AnnotationConfigApplicationContext> whenCreatingContext() throws Exception
	{
		return whenNew(AnnotationConfigApplicationContext.class).withParameterTypes(Class[].class).withArguments(classArgs(ReindeerLauncherConfiguration.class));
	}
	
	private Class<?> classArgs(Class<?>... classes)
	{
		return classes[0];
	}
	
	@Test
	public void shouldLaunchGame()
	{
		ReindeerLauncher.main(null);
		
		verify(game).launch();
	}
	
	@Test
	public void shouldCloseContext()
	{
		ReindeerLauncher.main(null);
		
		verify(context).close();
	}
}
