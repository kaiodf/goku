package br.com.goku;

import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.builder.SpringApplicationBuilder;

@RunWith(JMockit.class)
public class ApplicationTests {

	@Tested
	Application application;

	@Injectable
	SpringApplicationBuilder springApplication;
	
	@Test(expected=Exception.class)
	public void construtor() {
		Application.main(null);
	}
	
	@Test(expected=Exception.class)
	public void onStartupException() throws Exception {
		application.onStartup(null);
	}

}
