package com.aln.esceulamusicabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.aln.esceulamusicabackend", "Data", "Model", "Services", "Controller.Persona"})
public class EsceulaMusicaBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsceulaMusicaBackEndApplication.class, args);
	}

}
