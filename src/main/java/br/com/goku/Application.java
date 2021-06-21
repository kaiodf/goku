package br.com.goku;

import br.com.goku.config.RestConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@ComponentScan(basePackages = "br.com.goku")
@Import({ RestConfiguration.class })
@EnableSwagger2
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

	private static Class<?> applicationClass = Application.class;

	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}
}