package com.romanyuta.autoGuide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AutoGuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoGuideApplication.class, args);
	}

}
