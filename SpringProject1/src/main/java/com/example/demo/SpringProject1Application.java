package com.example.demo;

import com.example.demo.domain.entity.Cliente;
import com.example.demo.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringProject1Application {

	@Bean
	public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
		return args -> {
			Cliente c = new Cliente(null, "Fulano");
			clientes.save(c);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringProject1Application.class, args);
	}
}