package org.fasttrackit.trainginspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
@EnableScheduling
@SpringBootApplication
public class TrainingSpringApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(TrainingSpringApplication.class, args);
	}
}
