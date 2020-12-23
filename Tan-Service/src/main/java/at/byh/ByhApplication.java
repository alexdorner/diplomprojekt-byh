package at.byh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import at.byh.tan.TAN;

@SpringBootApplication
public class ByhApplication {

	public static void main(String[] args) {
		TAN.createTan();
		
		SpringApplication.run(ByhApplication.class, args);
	}
}
