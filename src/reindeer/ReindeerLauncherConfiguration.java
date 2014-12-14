package reindeer;

import javax.swing.JFrame;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("reindeer")
public class ReindeerLauncherConfiguration {
	
	@Bean
	public JFrame window()
	{
		return new JFrame();
	}
}
