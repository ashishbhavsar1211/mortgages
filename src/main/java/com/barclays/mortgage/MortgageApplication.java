package com.barclays.mortgage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**+
 *  Main Class of Mortgage Business Layer.
 */
@SpringBootApplication
public class MortgageApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MortgageApplication.class, args);
	}


}
