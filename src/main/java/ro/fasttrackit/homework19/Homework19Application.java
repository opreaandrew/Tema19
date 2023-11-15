package ro.fasttrackit.homework19;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Homework19Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Homework19Application.class, args);

		CountryReader reader = new CountryReader();
		System.out.println(reader.readCountries());
	}

}
