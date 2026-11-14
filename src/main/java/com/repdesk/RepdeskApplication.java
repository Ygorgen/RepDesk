package com.repdesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class RepdeskApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepdeskApplication.class, args);
	}

}
