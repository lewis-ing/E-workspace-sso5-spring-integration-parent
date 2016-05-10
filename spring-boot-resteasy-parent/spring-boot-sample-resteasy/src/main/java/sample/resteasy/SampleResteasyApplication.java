package sample.resteasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class SampleResteasyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleResteasyApplication.class, args);
	}

}
